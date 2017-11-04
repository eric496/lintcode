/*
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.

Notice
    You are not necessary to keep the original order of positive integers or negative integers.

Example
    Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.

Challenge
    Do it in-place and without extra memory.
*/

/*
Thought process:
    Two pointers:
    1. Sort the array, iterate and find the index of the first positive integer. There will be 3 cases:
           1) # positive equals # negative. The sequence should start with a negative and end with a positive.    i.e. -, +, -, ..., +, -, +
           2) # positive is greater than # negative. The sequence should both start and end with a positive.      i.e. +, -, +, ..., +, -, +
           3) # positive is smaller than # negative. The sequence should both start and end with a negative.      i.e. -, +, -, ..., -, +, -
       Case 1) and 3) index low end starts at 1; case 2) index low end starts at 0.
       Case 1) and 2) index high end starts at A.length - 2; case 3) index high end starts at A.length - 1.
    2. Without sorting, both pointers start from low end, iterate the array and locate the next mis-positioned positive and negative integers and swap them.
       If # positive is greater than # negative, positive index should start at 0 (so that the first element should be positive), and the negative index should accordingly start at 1.
       Otherwise, positive index should start at 1 and negative index should start at 0.
*/

// method 1
class Solution {
    public void rerange(int[] A) {  
        Arrays.sort(A);
        int pos = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                pos = i;
                break;
            }
        }
        int low = A.length - pos > pos ? 0 : 1;
        int high = A.length - pos < pos ? A.length - 1 : A.length - 2;
        while (low < high) {
            swap(low, high, A);
            low += 2;
            high -= 2;
        }
    }  
      
    private void swap(int left, int right, int[] A) {  
        int tmp = A[left];  
        A[left] = A[right];  
        A[right] = tmp;  
    }  
}

// method 2
class Solution {
    public void rerange(int[] A) {  
        int numPos = 0, numNeg = 0;  
        for (int i = 0; i < A.length; i++) {  
            if (A[i] > 0) {
                numPos++;
            } else {
                numNeg++;
            }
        }  
        int posIndex = numPos > numNeg ? 0 : 1;
        int negIndex = numPos > numNeg ? 1 : 0;
        while (negIndex < A.length && posIndex < A.length) {  
            while (negIndex < A.length && A[negIndex] < 0) negIndex += 2;  
            while (posIndex < A.length && A[posIndex] > 0) posIndex += 2;
            if (posIndex < A.length && negIndex < A.length) {
                swap(posIndex, negIndex, A);
                posIndex += 2;
                negIndex += 2;
            }
        }
    }

    void swap(int left, int right, int[] A) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}
