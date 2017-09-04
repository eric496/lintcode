/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

Notice
You may assume that each input would have exactly one solution

Example
numbers=[2, 7, 11, 15], target=9
return [1, 2]
*/

/*
Thought process:
    1. O(n) time and O(n) space solution: use hash map to store <target-number, index> pairs. 
       Loop through the array, check if the hash map contains key number. 
       If it does, then n2 = target - n1, where n1 is the first number and n2 is the second. 
       Retrieve the indices of these two numbers - the first is the value of the matched key, 
       the second is just the current iteration number. 
    2. Don't forget to add 1 to the result indices because the result indices are not zero-based.
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }
}
