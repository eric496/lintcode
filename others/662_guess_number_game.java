/*
We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number is higher or lower.
You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

Example
    n = 10, I pick 4 (but you don't know)
    Return 4. Correct !
*/

/*
Thought process:
    Binary search
*/

// O(logn) time
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        // does not matter whether include edge case "="
        while (low < high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result == -1) {
                high = mid - 1;
            } else if (result == 1) {
                low = mid + 1;
            }
        }
	// does not matter return low or high
        return low;
    }
}
