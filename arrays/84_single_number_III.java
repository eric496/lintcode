/*
Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Example
    Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
    O(n) time, O(1) extra space.
*/

public class Solution {
    public List<Integer> singleNumberIII(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int first = 0, second = 0;
        for (int num : nums) {
            if ((num & diff) == 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(first);
        result.add(second);
        return result;
    }
}
