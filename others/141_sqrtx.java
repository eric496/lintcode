/*
Implement int sqrt(int x).
Compute and return the square root of x.

Example
sqrt(3) = 1
sqrt(4) = 2
sqrt(5) = 2
sqrt(10) = 3
*/

class Solution {
    public int sqrt(int x) {
        if(x <= 0) return 0;
        long start = 1;
        long end = x;
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            if(mid == x / mid) {
                return (int) mid;
            } else if(mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return (int) start;
    }
}
