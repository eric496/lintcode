/*
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Notice
    You may assume that the array is non-empty and the majority number always exist in the array.

Example
    Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge
    O(n) time and O(1) extra space
*/

/*
Thought process:
    1. The easiest solution is using a hash map to store <number, frequency>. Create a max count variable to keep track the majority number so far. 
    2. Boyer-Moore majority vote algorithm: (https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm)
       The algorithm maintains in its local variables a sequence element and a counter, with the counter initially zero. 
       It then processes the elements of the sequence, one at a time. When processing an element x, if the counter is zero, 
       the algorithm stores x as its remembered sequence element and increment counter by 1. 
       Otherwise, it compares x to the stored element and either increments the counter (if they are equal) or decrements the counter (otherwise). 
       At the end of this process, if the sequence has a majority, it will be the element stored by the algorithm.
       This algorithm works based on the fact that the majority number counts for more than 50% of the whole list. So the remained number will always be the majority number
       if we offset the numbers by their frequency.
*/

//O(n) time and O(n) space using hash map
public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return Integer.MIN_VALUE;
        if (nums.size() <= 2) return nums.get(0);
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE, majority = Integer.MIN_VALUE;
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
            if (map.get(i) > maxFreq) {
                maxFreq = map.get(i);
                majority = i;
            }
        }
        return majority;
    }
}

//O(n) time and O(1) space - Boyer-Moore majority vote algorithm
public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
	if (nums == null || nums.size() == 0) return Integer.MIN_VALUE;
        if (nums.size() <= 2) return nums.get(0);
        int majority = Integer.MIN_VALUE, count = 0;
        for (int n : nums) {
            // start a new majority number if count equals 0
            if (count == 0) {
                majority = n;
                count++;
            // increment count by 1 if identical number occurs
            } else if (majority == n) {
                count++;
            // decrease count by 1 if different number occurs
            } else if (majority != n) {
                count--;
            }
        }
        return majority;
    }
}
