/*
Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

Example
    Given array S = [3,4,6,7], return 3. They are:
    [3,4,6]
    [3,6,7]
    [4,6,7]
    Given array S = [4,4,4,4], return 4. They are:
    [4(1),4(2),4(3)]
    [4(1),4(2),4(4)]
    [4(1),4(3),4(4)]
    [4(2),4(3),4(4)]
*/

public class Solution {
    public int triangleCount(int[] S) {
        Arrays.sort(S);
        int count = 0;
        for (int i = 0; i < S.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    // The edge from S[left] to S[right - 1] will also form a triangle
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
