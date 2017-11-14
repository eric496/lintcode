/*
Implement int sqrt(int x).
Compute and return the square root of x.

Example
    sqrt(3) = 1
    sqrt(4) = 2
    sqrt(5) = 2
    sqrt(10) = 3

Challenge
    O(log(x))
*/

/*
Thought process:
    1. Use Newton's method: Let f(x) = x^2 - n, and calculate f(x) = 0
       by using the formula x_n+1 = x_n - f(x_n) / f'(x_n) = x_n - (x^2 - n) / (2x) = 1/2 (x_n + n / x_n)
    2. Since requirement is O(log(x)) time complexity, it is easy to come up with binary search. 
       So we can write a typical iterative binary search solution.
*/

// Newton's method
class Solution {
    public int sqrt(int x) {
        if (x <= 0) return 0;
        long r = x;
        while (r * r > x) {
	    r = (r + x/r) / 2;
	}
        return (int)r;
    }
}

// O(log(x)) time
class Solution {
    public int sqrt(int x) {
        if (x <= 0) return 0;
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return (int)mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return (int)start;
    }
}
