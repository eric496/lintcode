/*
Given a continuous stream of numbers, write a function that returns the first unique number whenever terminating number is reached(include terminating number). If there no unique number before terminating number or you can't find this terminating number, return -1.

Example
    Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 5
    return 3
    Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 7
    return -1
*/

/*
Thought process:
*/

public class Solution {
    public int firstUniqueNumber(int[] nums, int number) {
        boolean flag = false;
        for (int num : nums) {
            if (num == number) {
                flag = true;
                break;
            }
        }
        if (flag == false) return -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, 0);
            if (num == number) break;
        }
        for (int num : nums) {
            map.put(num, map.get(num)+1);
            if (num == number) break;
        }
        for (int num: nums) { 
            if (map.get(num) == 1) return num;
	}
        return -1;
    }
}
