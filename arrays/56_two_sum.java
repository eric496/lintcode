/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.

Notice
    You may assume that each input would have exactly one solution

Example
    numbers=[2, 7, 11, 15], target=9
    return [0, 1]

Challenge
    Either of the following solutions are acceptable:
    O(n) Space, O(nlogn) Time
    O(n) Space, O(n) Time
*/

/*
Thought process:
    Use hashmap to store <target-number, index> pairs. 
    Iterate the array, check if the hash map contains key number. If so, then n2 = target - n1, where n1 is the first number and n2 is the second. 
    Retrieve the indices of these two numbers - the first is the matched key, the second is just the current index. 
*/

// O(n) time and O(n) space
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]);
                result[1] = i;
            } else {
                map.put(target-numbers[i], i);
            }
        }
        return result;
    }
}
