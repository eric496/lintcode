/*
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.

Notice
    n and k are non-negative integers.

Example
    Given n=3, k=2 return 6
          post 1,   post 2, post 3
    way1    0         0       1 
    way2    0         1       0
    way3    0         1       1
    way4    1         0       0
    way5    1         0       1
    way6    1         1       0
*/

/*
Thought process:
    DP: The first post has k choices, the second one has k choices because it can either be or not be the same color as the first one's. 
        The total number of ways of painting the second post can be decomposed into two cases:
            1) the second post has the same color as the first one, thus the second post has only 1 choice, by multiplication rule (MP): the total number of ways of painting is k*1.
            2) the second post has a different color than the first one, thus the second post has (k-1) choices, by MP, the total number of ways of painting is k*(k-1).
        The total number of ways of painting is thus k+k*(k-1).
        From the third post on, it can either choose the same color or not as the previous post. Since no more than 2 posts can be the same color:
            1) the current and the previous have the same color (i.e. the current has different color than the one before the previous): the total number of ways of painting is (k-1)*dp[i-2].
            2) the current and the previous have different colors: total number of ways of painting is (k-1)*dp[i-1].
        The total number of ways of painting is thus dp[i] = (k-1)*dp[i-1]+(k-1)*dp[i-2] = (k-1)*(dp[i-1]+dp[i-2]).
*/

public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k + k * (k - 1);
        for (int i = 2; i < n; i++) {
            dp[i] = (k - 1) * (dp[i-1] + dp[i-2]);
        }
        return dp[n-1];
    }
}
