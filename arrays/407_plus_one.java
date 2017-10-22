/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.

Example
    Given [1,2,3] which represents 123, return [1,2,4].
    Given [9,9,9] which represents 999, return [1,0,0,0].
*/

/*
Thought process
   Create a sum and a carry variables. Each number will be processed in 3 steps:
       1) sum = current number + carry;
       2) sum % 10 as the number at ones place / tens place / hundreds place ...
       3) carry sum / 10 to the next higher place.
   Be careful about two things: 
       First, the default value of carry is 1, because 1 will be added to the number.
       Second, iterate the array in backward order because addition operates from ones place, tens place, ...
       Third, because of the second, the result array is in reverse order, we need to reverse it back to the correct order.  
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int sum = 0, carry = 1;
        List<Integer> rev = new ArrayList<Integer>();
        for(int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            carry = sum / 10;
            rev.add(sum % 10);
        }
        if(carry != 0) rev.add(carry);
        int[] result = new int[rev.size()];
        int ix = rev.size() - 1;
        for(int i : rev) result[ix--] = i;
        return result;
    }
}
