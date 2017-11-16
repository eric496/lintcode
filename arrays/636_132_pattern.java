/*
Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
n will be less than 20,000.

Example
    Given nums = [1, 2, 3, 4]
    return False // There is no 132 pattern in the sequence.
    Given nums = [3, 1, 4, 2]
    return True // There is a 132 pattern in the sequence: [1, 4, 2].
*/

/*
Thought process:
    1. Brute-force: a no-brainer O(n^3) solution, iterate every (i, j, k) combination and return true if an 132 pattern occurs.
    2. O(n^2) time improved solution:
           Basic idea is for any fixed j, we would like to obtain the minimum element in nums[0 : j] (j exclusive), such that (nums[argmin], nums[j])
           gives the largest difference range possible so far. 
           Then in the inner loop, we search for the an element that is greater than the nums[argmin] and smaller than the current element nums[j].
    3. Use stack: Maintain a second largest variable "second" which always stores ak in the example. Iterate the array from end, push all elements that greater than ak into the stack.
                  If the current element is smaller than "second", we found a 132 pattern and return. 
                  If the current element is greater than the top element in the stack, pop the top element and make it "second" repeat this until the top is greater than the current, 
                  push the current element into the stack. This will make sure that the element in the stack is always the largest one in a 3-element sequence. 
*/

// O(n^3) time brute-force
// this will cause TLE
public class Solution {
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
                }
            }
        }
        return false;
    }
}

// O(n^2) time
public class Solution {
    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < min) min = nums[j];
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] > min && nums[j] > nums[k]) return true;
            }
        }
        return false;
    }
}

// O(n) time with two passes
public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int[] minSofar = new int[nums.length];
        minSofar[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minSofar[i] = Math.min(nums[i], minSofar[i-1]);
        }
        int top = nums.length;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] <= minSofar[j]) continue;
            while (top < nums.length && minSofar[top] <= minSofar[j]) top++;
            if (top < nums.length && nums[j] > minSofar[top]) return true;
            minSofar[--top] = nums[j];
        }
        return false;
    }
}

// O(n) time using stack
public class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
	    }
            stack.push(nums[i]);
        }
        return false;
    }
}
