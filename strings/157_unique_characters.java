/*
Implement an algorithm to determine if a string has all unique characters.

Example
    Given "abc", return true.
    Given "aab", return false.

Challenge
    What if you can not use additional data structures?
*/

/*
Thought process:
    1. Use an array (for ASCII) or hash set (for other encodings) to keep track of occurence of the characters.
    2. Iterate the array, at each iteration, check duplicates of the current element with those elements come after it only, 
       because it is assured that there are no duplicates that comes before it (or it would break and return already).
*/

// O(n) time and O(1) space using array
public class Solution {
    public boolean isUnique(String str) {
        if(str == null || str.length() == 0) return false;
        boolean[] occurred = new boolean[256];
        for(char c : str.toCharArray()) {
            if(occurred[c]) return false;
            else occurred[c] = true;
        }
        return true;
    }
}

// O(n) time and O(n) space using hash set
public class Solution {
    public boolean isUnique(String str) {
        if(str == null || str.length() == 0) return false;
        HashSet<Character> set = new HashSet<Character>();
        for(char c : str.toCharArray()) {
            if(set.contains(c)) return false;
            else set.add(c);
        }   
        return true;
    }   
}

// O(n2) time and O(1) space
public class Solution {
    public boolean isUnique(String str) {
        if(str == null || str.length() == 0) return false;
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++)
                if(str.charAt(i) == str.charAt(j)) return false;
        }
        return true;
    }
}
