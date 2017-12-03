/*
Count the number of k's between 0 and n. k can be 0 - 9.

Example
    if n = 12, k = 1 in
    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    we have FIVE 1's (1, 10, 11, 12)
*/

/*
Thought process:
    Iterate the array, check each digit of an element.
*/

// O(n^2) time and O(1) space
public class Solution {
    public int digitCounts(int k, int n) {
        if (k < 0 || k > 9 || n < 0) return 0;
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int num = i;
            // excute at least once in case k = 0
            do {
                if (num % 10 == k) {
		    count++;
		}
                num /= 10;
            } while (num != 0);
        }
        return count;
    }
}
