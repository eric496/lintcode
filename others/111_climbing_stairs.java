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
    2. Iterative solution
    3. DP - similar to fibonacci sequence, 
       1,1,2,3,5, ...
*/

// recursive
public class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

// iterative
public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int prevPrev = 1;
        int prev = 1;
        int cur = 0;
        for(int i = 2; i <= n; i++) {
            cur = prevPrev + prev;
            prevPrev = prev;
            prev = cur;
        }
        return cur;
    }
}

// DP
public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++) res[i] = res[i-1] + res[i-2];
        return res[n];
    }
}
