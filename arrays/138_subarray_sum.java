/*
Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

Notice
    There is at least one subarray that it's sum equals to zero.

Example
    Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*/

/*
Thought process
    Keep track of every sum so far. If two sums equal, then the numbers in between add up to 0.
    Use a hash map: sum so far as key and index as value.
    Given two sums (i and j) equals, then numbers from index i+1 to j (inclusive) add up to 0. So first index should be -1. 
*/

public class Solution {
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // set the default sum to 0 at index -1.
        // think about test case [1,-1].
        map.put(0, -1);
        int sumSofar = 0;
        for(int i = 0; i < nums.length; i++) {
            sumSofar += nums[i];
            if(map.containsKey(sumSofar)) {
                result.add(map.get(sumSofar)+1);
                result.add(i);
                return result;
            }
            map.put(sumSofar, i);
        }
        return result;
    }
}
