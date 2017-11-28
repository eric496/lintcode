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
    If the characters are all in ASCII, use an extra array with size 256. Use a map otherwise.
*/

// O(n) time and O(1) space
public class Solution {
    public boolean compareStrings(String A, String B) {
        if (A.length() < B.length() || A == null || B == null) return false;
        int[] count = new int[256];
        for (char c : A.toCharArray()) {
	    count[c]++;
	}
        for (char c : B.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return false;
        }
        return true;
    }
}

// O(n) time and O(n) space
public class Solution {
    public boolean compareStrings(String A, String B) {
        if (A.length() < B.length() || A == null || B == null) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : B.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c) < 0) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}

// Sorting 
public class Solution {
    public boolean compareStrings(String A, String B) {
        if (A.length() < B.length()) return false;
        if (B == null || B.length() == 0) return true;
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        Arrays.sort(charA);
        Arrays.sort(charB);
        int ixa = 0, ixb = 0;
        while (ixa < charA.length && ixb < charB.length) {
            if (charA[ixa] == charB[ixb]) {
                ixb++;
            }
            ixa++;
        }
        if (ixb < charB.length) return false;
        return true;
    }
}
