/*
Given a set of integers, write a function to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example
    Given nums = [1, 6, 11, 5], return 1
    // Subset1 = [1, 5, 6], sum of Subset1 = 12 
    // Subset2 = [11], sum of Subset2 = 11   
    // abs(11 - 12) = 1     
*/

// O(2^n) time recursive solution; it causes TLE
public class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int sumTotal = 0;
        for (int i = 0; i < n; i++) {
            sumTotal += arr[i];
        }
        return findMinRec(arr, n, 0, sumTotal);
    }
    
    public int findMinRec(int arr[], int i, int sumCalculated, int sumTotal) {
        if (i == 0) {
            return Math.abs((sumTotal-sumCalculated) - sumCalculated);
        }
        return Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i-1], sumTotal), findMinRec(arr, i-1, sumCalculated, sumTotal));
    }
}

// O(n^2) time by DP
public class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        int sum = 0;
        for (int i = 0; i < n ; ++i) {
            sum += arr[i];
        }
        int[] dp = new int[sum/2+1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= arr[i]; --j) {
                dp[j] = dp[j - arr[i]] + arr[i] > dp[j] ? dp[j - arr[i]] + arr[i] : dp[j];
            }
        }
        return Math.abs(sum - 2 * dp[sum/2]);
    }
}
