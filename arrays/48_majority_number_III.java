/*
Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
Find it.

Notice
    There is only one majority number in the array.

Example
    Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

Challenge
    O(n) time and O(k) extra space
*/

public class Solution {
    public int majorityNumber(List<Integer> nums, int k) {
        // count at most k keys.
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            if (!countMap.containsKey(i)) {
                countMap.put(i, 1);
	    } else {
                countMap.put(i, countMap.get(i)+1);
	    }
            if (countMap.size() >= k) {
		removeKey(countMap);
	    }
        }
        // corner case
        if (countMap.size() == 0) return Integer.MIN_VALUE;
        // recalculate counters
        for (int i : countMap.keySet()) {
	    countMap.put(i, 0);
	}
        for (int i : nums) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i)+1);
	    }
        }
        // find the max key
        int maxCount = 0, majority = 0;
        for (int i : countMap.keySet()) {
            if (countMap.get(i) > maxCount) {
                maxCount = countMap.get(i);
                majority = i;
            }
        }
        return majority;
    }
    
    private void removeKey(Map<Integer, Integer> countMap) {
        Set<Integer> keySet = countMap.keySet();
        List<Integer> removeList = new ArrayList<>();
        for (int key : keySet) {
            countMap.put(key, countMap.get(key)-1);
            if (countMap.get(key) == 0) {
		removeList.add(key);
	    }
        }
        for (int key : removeList) {
	    countMap.remove(key);
	}
    }
}
