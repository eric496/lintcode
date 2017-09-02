/*
Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

Notice
There is at least one subarray that it's sum equals to zero.

Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*/

/*
Thought process
1. Keep track of every sum, if two sums equal, then the numbers in between add up to 0
2. Use hash map to store sums: sum as key and index as value
3. Notice the base case - first value of the hash map. Given two sums (i and j) equals, then numbers from index i+1 to j (inclusive) add up to 0. So first index should be -1. 
*/

public class Solution {
    public ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            }
            map.put(sum, i);
        }
        return res;
    }
}
