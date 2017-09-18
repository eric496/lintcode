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
    1. Sort the array first and loop through it. For each element, 
       loop through from the the element right to it to the end of the array.
       If 3sum equals 0, keep them in the result. If it is greater than 0, reduce the high end; 
       if it is less than 0, increment the low end. 
    2. Remember to skip the same result, since once num[i] is fixed for each loop, if num[low] equals
       num[low-1] or num[high] = num[high+1] then we will get the extacly same result as previous loop. 
*/

// O(n^2) time
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        if(num == null || num.length < 3) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++) {
            if(i != 0 && num[i] == num[i-1]) continue;
            int low = i + 1, high = num.length - 1;
            while(low < high) {
                if(num[i] + num[low] + num[high] == 0) {
                    res.add(Arrays.asList(num[i], num[low++], num[high--]));
                    while(low < high && num[low] == num[low-1]) low++;
                    while(low < high && num[high] == num[high+1]) high--;
                } else if(num[i] + num[low] + num[high] < 0) {
                    low++;
                } else {
                    high--;  
                }
            }
        }
        return res;
    }
}
