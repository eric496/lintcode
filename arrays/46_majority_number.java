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
    1. Intuitive solution would use hash map to store <number, count> pairs.
       Keep track of the max count in the iteration to avoid two passes. 
    2. Boyer-Moore majority vote algorithm: (https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm)
       The algorithm maintains in its local variables a sequence element and a counter, with the counter initially zero. 
       It then processes the elements of the sequence, one at a time. When processing an element x, if the counter is zero, 
       the algorithm stores x as its remembered sequence element and sets the counter to one. 
       Otherwise, it compares x to the stored element and either increments the counter (if they are equal) or decrements the counter (otherwise). 
       At the end of this process, if the sequence has a majority, it will be the element stored by the algorithm.
*/

//O(n) time and O(n) space using hash map
public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE, majority = Integer.MIN_VALUE;
        for(Integer i : nums) {
            if(res.containsKey(i)) {
                res.put(i, res.get(i) + 1);
            } else {
                res.put(i, 1);
            }
            if(res.get(i) > max) {
                max = res.get(i);
                majority = i;
            }
        }
        return majority;
    }
}

//O(n) time and O(1) space - Boyer-Moore majority vote algorithm
public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        int majority = Integer.MIN_VALUE, count = 0;
        for(Integer n : nums) {
            if(count == 0) {
                majority = n;
                count++;
            } else if(majority == n) {
                count++;
            } else if(majority != n) {
                count--;
            }
        }
        return majority;
    }
}
