/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example
    Given an example n=3 , 1+1+1=2+1=1+2=3
    return 3
*/

/*
Thought process:
    1. Recursive solution
           Base case: return 0 when n equals 0; return 1 when n equals 1; return 2 when n equals 2.
           Recursive steps: distinct ways of climbing to n is the sum of distinct ways of climbing to n-1 and n-2, because 
                            we can climb 1 or 2 steps each time. These two paths do not overlap.
    2. Iterative solution: Refer to 366. Fibonacci
    3. DP: bottom-up method
*/

// recursive (it causes TLE)
public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

// iterative
public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int prevPrev = 1, prev = 2, cur = prevPrev + prev;
        for (int i = 3; i <= n; i++) {
            cur = prevPrev + prev;
            prevPrev = prev;
            prev = cur;
        }
        return cur;
    }
}

// DP - bottom up
public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
	    dp[i] = dp[i-1] + dp[i-2];
	}
        return dp[n];
    }
}
