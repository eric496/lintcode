/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.

Example
Given [1,2,3] which represents 123, return [1,2,4].
Given [9,9,9] which represents 999, return [1,0,0,0].
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;
        int carry = 1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) result.add(carry);
        int[] res = new int[result.size()];
        for(int i = result.size() - 1; i >= 0; i--) {
            res[result.size() - i - 1] = result.get(i);
        }
        return res;
    }
}

