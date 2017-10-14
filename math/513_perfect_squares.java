/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example
    Given n = 12, return 3 because 12 = 4 + 4 + 4
    Given n = 13, return 2 because 13 = 4 + 9
*/

// BFS 1
public class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            depth++;
            while(size-- > 0) {
                int u = q.poll();
                for(int i = 1; i * i <= n; i++) {
                    int v = u + i * i;
                    if(v == n) return depth;
                    if(v > n) break;
                    if(!visited.contains(v)) {
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
        }
        return depth;
    }
}

// BFS 2
public class Solution {
    public int numSquares(int n) {
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        for (int level = 0; !q.isEmpty(); level++) {
            for (int i = q.size(); i > 0; i--) {
                int num = q.poll();
                if (num == 0) return level;
                for (int j = 1; j * j <= num; j++)
                    if (vis.add(num - j * j)) q.offer(num - j * j);
            }
        }
        return 0;
    }
}

// DP


// math 
public class Solution {
    public int numSquares(int n) {
        // If n is a perfect square, return 1.
        if(is_square(n)) return 1;  
        // The result is 4 if and only if n can be written in the 
        // form of 4^k*(8*m + 7). Please refer to 
        // Legendre's three-square theorem.
        // n%4 == 0 
        while ((n & 3) == 0) n >>= 2; 
        // n%8 == 7
        if ((n & 7) == 7) return 4;
        // Check whether 2 is the result.
        int sqrt_n = (int)(Math.sqrt(n)); 
        for(int i = 1; i <= sqrt_n; i++) {
            if (is_square(n - i * i)) return 2;  
        }
        return 3; 
    }
    
    private boolean is_square(int n) {  
        int sqrt_n = (int)(Math.sqrt(n));  
        return sqrt_n * sqrt_n == n;  
    }
}
