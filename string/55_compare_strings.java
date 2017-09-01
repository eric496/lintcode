/*
Compare two strings A and B, determine whether A contains all of the characters in B.
The characters in string A and B are all Upper Case letters.

Notice
The characters of B in A are not necessary continuous or ordered.

Example
For A = "ABCD", B = "ACD", return true.
For A = "ABCD", B = "AABC", return false.
*/

public class Solution {
    public boolean compareStrings(String A, String B) {
        if(A.length() < B.length() || A == null || B == null) return false;
        
        int[] result = new int[256];
        for(int i = 0; i < A.length(); i++) result[A.charAt(i)]++;
        
        for(int i = 0; i < B.length(); i++) {
            result[B.charAt(i)]--;
            if(result[B.charAt(i)] < 0) return false;
        }
        return true;
    }
}
