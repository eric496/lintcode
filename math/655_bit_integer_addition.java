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
    Similar to 408. Add Binary
*/

// O(n) time and O(1) space
public class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0, sum = 0, ix1 = num1.length() - 1, ix2 = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (ix1 >= 0 && ix2 >= 0) {
            sum = (int)(num1.charAt(ix1--)-'0') + (int)(num2.charAt(ix2--)-'0') + carry;
            sb.append(sum%10);
            carry = sum / 10;
        }
        while (ix1 >= 0) {
            sum = carry + (int)(num1.charAt(ix1--)-'0');
            sb.append(sum%10);
            carry = sum / 10;
        }
        while (ix2 >= 0) {
            sum = carry + (int)(num2.charAt(ix2--)-'0');
            sb.append(sum%10);
            carry = sum / 10;
        }
        if (carry != 0) {
	    sb.append(carry);
	}
        return sb.reverse().toString();
    }
}

// a more concise version
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int sum = 0, carry = 0, ix1 = num1.length() - 1, ix2 = num2.length() - 1;
        while (ix1 >= 0 || ix2 >= 0) {
            sum = carry;
            if (ix1 >= 0) {
                sum += (int)(num1.charAt(ix1--)-'0');
            }
            if (ix2 >= 0) {
                sum += (int)(num2.charAt(ix2--)-'0');
            }
            sb.append(sum%10);
            carry = sum / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
