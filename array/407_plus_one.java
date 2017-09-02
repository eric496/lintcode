/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.

Example
Given [1,2,3] which represents 123, return [1,2,4].
Given [9,9,9] which represents 999, return [1,0,0,0].
*/

/*
Thought process
1. To solve this type of problems in 3 steps:
   1) sum = current number + carry;
   2) sum % 10 as the number at ones place / tens place / hundreds place ...
   3) carry sum / 10 to the next higher place.  
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0, carry = 1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            res.add(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) res.add(carry);
        Collections.reverse(res);
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) result[i] = res.get(i);
        return result;
    }
}
