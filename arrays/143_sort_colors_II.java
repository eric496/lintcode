/*
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

Notice
    You are not suppose to use the library's sort function for this problem.
    k <= n

Example
    Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

Challenge
    A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?
*/

/*
Thought process:

*/

public class Solution {
    public void sortColors2(int[] colors, int k) {
        int count = 0, low = 0, high = colors.length - 1;
        while (count < k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = low; i <= high; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }
            int pos = low;
            while (pos <= high) {
                if (colors[pos] == min) {
                    swap(low, pos, colors);
                    pos++;
                    low++;
                } else if (colors[pos] > min && colors[pos] < max) {
                    pos++;
                } else {
                    swap(pos, high, colors);
                    high--;
                }
            }
            count += 2;
        }
    }
    
    private void swap(int low, int high, int[] colors) {
        int temp = colors[low];
        colors[low] = colors[high];
        colors[high] = temp;
    }
}
