/*
Count the number of k's between 0 and n. k can be 0 - 9.

Example
    if n = 12, k = 1 in
    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    we have FIVE 1's (1, 10, 11, 12)
*/

/*
Thought process:
    1. Brute force: loop through all numbers, digit by digit. Keep the number of apperance of the target digit
*/

class Solution {
    public int digitCounts(int k, int n) {
        if(k < 0 || k > 9 || n < 0) return 0;
        int count = 0;
        char kChar = (char)(k + '0');
        for (int i = k; i <= n; i++) {
            char[] iChars = Integer.toString(i).toCharArray();
            for (char iChar : iChars) 
                if(kChar == iChar) count++;
        }
        return count;
    }
}
