/*
Given two strings S and T, determine if they are both one edit distance apart.

Example
    Given s = "aDb", t = "adb"
    return true
*/

/*
Thought process:
    There are two cases that two strings are one edit distance away from each other:
        1) one string is one character less than the other, and the relative order of other characters are the same for the two strings
           so by inserting an character in the short string we will get the long string.
        2) two strings are of the same length with only one character different.
    Notice two corner cases: return false if difference of lengths is greater than 1 or two strings are extactly the same (no distance)
    Differentiate the shorter string from the longer one. Create two index variables and a count variable to keep the number of different characters.
    If the current characters are the same, increment both short and long indices. Otherwise, if two strings have the same length, increment both indices as well.
    If they have different length, increment only the long index. Finally check if count of different characters are less than or equals one 
    (there is a corner case that diff == 0 when the last character of the long string is the only different character).
*/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
        String longer = s.length() >= t.length() ? s : t;
        String shorter = s.length() <= t.length() ? t : s;
        int shortIdx = 0, longIdx = 0, diff = 0;
        while (shortIdx < shorter.length()) {
            if (shorter.charAt(shortIdx) == longer.charAt(longIdx)) {
                shortIdx++;
                longIdx++;
            } else {
                if (++diff > 1) return false;
                if (shorter.length() == longer.length()) {
                    shortIdx++;
                    longIdx++;
                } else {
                    longIdx++;
                }
            }
        }
        return diff <= 1 ? true : false;
    }
}
