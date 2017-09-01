/*
Given two strings, write a method to decide if one is a permutation of the other.

Example
abcd is a permutation of bcad, but abbe is not a permutation of abe
*/

public class Solution {
    public boolean Permutation(String A, String B) {
        int[] counter = new int[200];
        for (int i = 0; i < A.length(); i++) counter[A.charAt(i)]++;
        for (int i = 0; i < B.length(); i++) counter[B.charAt(i)]--;
        for (int cnt: counter) {
            if (cnt != 0) return false;
        }
        return true;
    }
}
