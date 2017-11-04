/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Notice
    This problem have two method which is Greedy and Dynamic Programming.
    The time complexity of Greedy method is O(n).
    The time complexity of Dynamic Programming method is O(n^2).
    We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.

Example
    A = [2,3,1,1,4], return true.
    A = [3,2,1,0,4], return false.
*/

/*
Thought process:
    Create a variable to store the max jump (which is the largest reachable index). Iterate the array, if the max jump is smaller than the current index, 
    which means it can not jump to the next index, return false immediately.
    Update the max jump if sum of the current index and current jump length is greater than or equal to max jump so far.
    Finally check if the max jump is greater than or equal to the last index of the array.
*/

// O(n) time
public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        int maxJump = 0;
        for (int i = 0; i < A.length; i++) { 
            if (i > maxJump) return false;
            if (A[i] + i >= maxJump) {
                maxJump = A[i] + i;
            }
        }
        return maxJump >= A.length - 1;
    }
}
