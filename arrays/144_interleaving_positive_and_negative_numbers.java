/*
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.

Notice
    You are not necessary to keep the original order of positive integers or negative integers.

Example
    Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.

Challenge
    Do it in-place and without extra memory.
*/

class Solution {
    public void rerange(int[] A) {  
        int posNum = 0, negNum = 0;  
        for (int i = 0; i < A.length; i++) {  
            if (A[i] > 0) 
                posNum++;  
            else 
                negNum++;
        }  
        int posInd = 1, negInd = 0;  
        if (posNum > negNum) {  
            posInd = 0;  
            negInd = 1;  
        }  
       
        while (negInd < A.length && posInd < A.length) {  
            while (negInd < A.length && A[negInd] < 0) negInd += 2;  
            while (posInd < A.length && A[posInd] > 0) posInd += 2;  
            if (posInd < A.length && negInd < A.length) {  
                swap(posInd, negInd, A);  
                posInd += 2;  
                negInd += 2;  
            }  
        }  
    }  
      
    void swap(int left, int right, int[] A) {  
        int tmp = A[left];  
        A[left] = A[right];  
        A[right] = tmp;  
    }  
}
