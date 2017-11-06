/*
Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?

Example
    Given n = 3, there are a total of 5 unique BST's.
    1           3    3       2      1
     \         /    /       / \      \
      3      2     1       1   3      2
     /      /       \                  \
    2     1          2                  3
*/

/*
Thought process:
    Suppose function f(n) maps the number of values n to the number of unique BSTs. Observe that f(n) = g(1, n) + g(2, n) + g(3, n) + ... + g(n-1, n) + g(n, n)
    where g(i, n) is a function which maps the number of values n to the number of unique BSTs given i as the root. Observe that g(i, n) = f(i-1) * f(n-i). Given 
    i as root, the total number of unique BSTs is just the product of the number of unique BSTs using all nodes left to i and the number of unique BSTs using all nodes right to i.
*/

// DP
public class Solution {
    public int numTrees(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                dp[i] += dp[j-1] * dp[i-j];
        }
        return dp[n];
    }
}
