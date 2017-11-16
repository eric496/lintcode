/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Notice
    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.

Example
    Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:
    (-1, 0, 0, 1)
    (-2, -1, 1, 2)
    (-2, 0, 0, 2)
*/

/*
Thought process:
    Similar to 57. 3Sum, but with an extra nested for loop. Fix the first number, and search for qualified 3sum.
*/

// O(n^3) time - cannot be reduced
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) continue;
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) continue;
                int low = j + 1, high = num.length - 1;
                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    if (sum == target) {
                        result.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        low++;
                        high--;
                        while (low < high && num[low] == num[low - 1]) low++;
                        while (low < high && num[high] == num[high + 1]) high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}
