/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

Example
    Given array A = [2,3,1,1,4]
    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

/*
Thought process:

*/

public class Solution {
    public int jump(int[] A) {
	int numJumps = 0, prevJumpMax = 0, curJumpMax = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (i + A[i] > curJumpMax) {
		curJumpMax = i + A[i];
	    }
            if (i == prevJumpMax) {
                numJumps++;
                prevJumpMax = curJumpMax;
            } 
        }
        return numJumps;
    }
}
