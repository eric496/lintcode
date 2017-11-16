/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

Example
    For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

/*
Thought process:
    Sort the array, for any fixed i, iterate all elements on its right using two pointers (iterate from head and tail simultaneously).
    Add 3sum to result list if 3sum equals 0. Otherwise, increment low pointer if 3sum is smaller than 0, decrease high pointer if 3sum is greater than 0.
    Don't forget to skip duplicate element during iteration.
*/

// O(n^2) time
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 3) return result;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            // skip duplicate element
            if (i != 0 && num[i] == num[i-1]) continue;
            int low = i + 1, high = num.length - 1;
            while (low < high) {
                if (num[i] + num[low] + num[high] == 0) {
                    result.add(Arrays.asList(num[i], num[low], num[high]));
		    low++;
		    high--;
                    // skip duplicate element
                    while (low < high && num[low] == num[low-1]) low++;
                    while (low < high && num[high] == num[high+1]) high--;
                } else if (num[i] + num[low] + num[high] < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}
