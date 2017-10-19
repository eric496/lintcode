/*
Compare two strings A and B, determine whether A contains all of the characters in B.
The characters in string A and B are all Upper Case letters.

Notice
The characters of B in A are not necessary continuous or ordered.

Example
For A = "ABCD", B = "ACD", return true.
For A = "ABCD", B = "AABC", return false.
*/

/*
Thought process:
    1. If the characters are all in ASCII, use an extra array with size 256.
    2. If unicode, use a hash map.
*/

// O(n) time and O(1) space by using array
public class Solution {
    public boolean compareStrings(String A, String B) {
        if(A.length() < B.length() || A == null || B == null) return false;
        int[] count = new int[256];
        for(char c : A.toCharArray()) count[(int)c]++;
        for(char c : B.toCharArray()) {
            count[(int)c]--;
            if(count[(int)c] < 0) return false;
        }
        return true;
    }
}

// O(n) time and O(n) space by using hash map
public class Solution {
    public boolean compareStrings(String A, String B) {
        if(A.length() < B.length() || A == null || B == null) return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : A.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for(char c : B.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c) < 0) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
