/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Notice
    You are not suppose to use the library's sort function for this problem.
    You should do it in-place (sort numbers in the original array).

Example
    Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].

Challenge
    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    Could you come up with an one-pass algorithm using only constant space?
*/

/*
Thought process:
    1. Two passes:
    2. One pass:
*/

// two passes
public class Solution {
    public void sortColors(int[] A) {
	if (A == null || A.length < 2) return;
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
		num0++;
	    } else if (A[i] == 1) {
		num1++;
	    } else {
		num2++;	
	    }
        }
	for (int i = 0; i < A.length; i++) {
	    if (i < num0) {
		A[i] = 0;
	    } else if (i < num0 + num1) {
		A[i] = 1;
	    } else {
		A[i] = 2;	
	    }
	}
    }
}

// one pass
public class Solution {
    public void sortColors(int[] A) {
        if (A==null || A.length < 2) return;
        int low = 0, high = A.length - 1, pos = 0;
        while (pos <= high) {
            if (A[pos] == 0) {
                // swap A[i] and A[low] and pos,low both ++
                int temp = A[pos];
                A[pos] = A[low];
                A[low] = temp;
                pos++;
                low++;
            } else if (A[pos] == 2) {
               //swap A[pos] and A[high] and high--;
                int temp = A[pos];
                A[pos] = A[high];
                A[high] = temp;
                high--;
            } else {
                pos++;
            }
        }
    }
}
