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

// solution 1
public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        int farthest = A[0];
        for (int i = 1; i < A.length; i++)
            if (i <= farthest && A[i] + i >= farthest) farthest = A[i] + i;
        return farthest >= A.length - 1;
    }
}

// soulution 2
public class Solution {
    public boolean canJump(int[] A) {
        int last = A.length - 1;
        for(int i = A.length - 2; i >= 0; i--) if(i + A[i] >= last) last = i;
        return last <= 0;
    }
}

// solution 3
public class Solution {
    public boolean canJump(int[] nums) {
        int maxLocation = 0;
        for(int i = 0; i < nums.length; i++) {
            if(maxLocation < i) return false; // if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
            maxLocation = (i + nums[i]) > maxLocation ? i + nums[i] : maxLocation; // greedy:
        }
        return true;
    }
}
