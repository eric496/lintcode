/*
Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the difference between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum difference.

Notice
    Each given array will have at least 1 number. There will be at least two non-empty arrays.
    The total number of the integers in all the m arrays will be in the range of [2, 10000].
    The integers in the m arrays will be in the range of [-10000, 10000].

Example
    Given arrays = [[1,2,3], [4,5], [1,2,3]]
    Return 4
    One way to reach the maximum difference 4 is to pick 1 in the first or third array and pick 5 in the second array.
*/

/*
Thought process:
    Intuitively, we should subtract the largest value by the smallest value from all arrays.
    But there is a case that both extreme values comes from the same array which is not allowed. 
    So, what we need to do is create four variables to keep smallest, the second smallest, largest, the second largest values.
    If the extreme values come from the same array, then compare |the second largest - smallest| with |largest - the second smallest|, 
    and return whichever is smaller. Otherwise just return |the largest - the smallest|.
*/

// O(n) time and O(1) space
public class Solution {
    public int maxDiff(int[][] arrs) {
        if (arrs == null || arrs.length == 0) return -1;
        int small1 = 0, small2 = 0, large1 = 0, large2 = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i][0] <= arrs[small1][0]) { 
                small2 = small1;
                small1 = i;
            } else if (arrs[i][0] < arrs[small2][0]) {
                small2 = i;
            }
            if (arrs[i][arrs[i].length-1] >= arrs[large1][arrs[large1].length-1]) {
                large2 = large1;
                large1 = i;
            } else if (arrs[i][arrs[i].length-1] > arrs[large2][arrs[large2].length-1]) {
                large2 = i;
            }
        }
        int max1 = Math.abs(arrs[small1][0] - arrs[large2][arrs[large2].length-1]);
        int max2 = Math.abs(arrs[small2][0] - arrs[large1][arrs[large1].length-1]);
        if (small1 == large1) return max1 > max2 ? max1 : max2;
        return Math.abs(arrs[small1][0] - arrs[large1][arrs[large1].length-1]);
    }
}
