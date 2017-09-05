/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
Notice
    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example
Given num1 = "123", num2 = "45"
return "168"
*/

/*
Thought process:
    1. Three passes: first, loop backward through both strings, add up each pair of digits.
       Keep track of the number at the current place (sum % 10) and the number carried to the next place (sum / 10).
    2. Can be more concise with only one pass. But be careful of the condition statement in the for loop.
*/

// Three passes method: O(n) time and O(1) space
public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length() == 0 || num1 == null) return num2;
        if(num2.length() == 0 || num2 == null) return num1;
        int carry = 0, sum = 0, ix1 = num1.length() - 1, ix2 = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        while(ix1 >= 0 && ix2 >= 0) {
            sum = carry + (int)(num1.charAt(ix1--) - '0') + (int)(num2.charAt(ix2--) - '0');
            sb.append(sum % 10);
            carry = sum / 10;
        }
        while(ix1 >= 0) {
            sum = carry + (int)(num1.charAt(ix1--) - '0');
            sb.append(sum % 10);
            carry = sum / 10;
        }
        while(ix2 >= 0) {
            sum = carry + (int)(num2.charAt(ix2--) - '0');
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

// One pass method: O(n) time and O(1) space
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
