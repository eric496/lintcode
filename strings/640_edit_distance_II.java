/*
Given two strings S and T, determine if they are both one edit distance apart.

Example
    Given s = "aDb", t = "adb"
    return true
*/

/*
Thought process:
    There are two cases that two strings are one edit distance away from each other:
        1) One string is one character less than the other, and the relative order of other characters is the same for the two strings.
           By inserting an character in the short string (or by deleting an character in the long string) can we convert one to the other. 
        2) Two strings are of the same length with only one character different. Conversion can be done by replacement of the different character.
    Notice two corner cases: return false if difference of lengths is greater than 1 or two strings are extactly the same (no distance)
    Differentiate the shorter string from the longer one. Create two index variables and a counter variable to keep the number of different characters.
    If the current characters are the same, increment both short and long indices. Otherwise, if two strings have the same length, increment both indices as well.
    If they have different length, increment only the long index. Finally check if count of different characters are less than or equals one 
    (there is a corner case that diff == 0 when the last character of the long string is the only different character).
*/

// method 1
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
        String strLong, strShort;
        if (s.length() >= t.length()) {
            strLong = s;
            strShort = t;
        } else {
            strLong = t;
            strShort = s;
        }
        int ixLong = 0, ixShort = 0, diff = 0;
        while (ixShort < strShort.length()) {
            if (strLong.charAt(ixLong) != strShort.charAt(ixShort)) {
                diff++;
                if (strLong.length() == strShort.length()) {
                    ixLong++;
                    ixShort++;
                } else {
                    ixLong++;
                }
            } else {
                ixLong++;
                ixShort++;
            }
	    if (diff > 1) return false;
        }
        if (diff == 0 && strLong.length() > strShort.length()) return true;
        if (diff == 1) return true;
        return false;
    }
}

// method 2
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
        String strLong = s.length() >= t.length() ? s : t;
        String strShort = s.length() <= t.length() ? t : s;
        int ixShort = 0, ixLong = 0, diff = 0;
        while (ixShort < strShort.length()) {
            if (strShort.charAt(ixShort) == strLong.charAt(ixLong)) {
                ixShort++;
                ixLong++;
            } else {
                if (++diff > 1) return false;
                if (strShort.length() == strLong.length()) {
                    ixShort++;
                    ixLong++;
                } else {
                    ixLong++;
                }
            }
        }
        return diff <= 1 ? true : false;
    }
}
