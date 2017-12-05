/*
We are given two numbers A and B such that B >= A. We need to compute the last digit of this resulting F such that F = B! / A! where 1 <= A, B <= 10^18 (A and B are very large)

Example
    Given A = 2, B = 4, return 2
    A! = 2 and B! = 24, F = 24 / 2 = 12 --> last digit = 2
    Given A = 107, B = 109, return 2
*/

/*
Thought process:
    If two numbers are identical, the result is 1. It is known that the last digit of factorial always belongs to the set {0, 1, 2, 4, 6}.
    If B - A >= 5, the last digit is always 0. Otherwise, we multiply from A+1 to B. We only care about the last digit which is determined 
    by the multiplication of the last digits.
*/

public class Solution {
    public int computeLastDigit(long A, long B) {
        int result = 1;
        if (A == B) {
            return 1;
        } else if (B - A >= 5) {
            return 0;
        } else {
            for (long i = A + 1; i <= B; i++) {
                result = (int)(result * (i % 10)) % 10;
            }
        }
        return result % 10;
    }
}
