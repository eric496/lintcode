/*
Given two binary strings, return their sum (also a binary string).

Example
    a = 11
    b = 1
    Return 100
*/

/*
Thought process:
    Iterate both strings in backward order. Think about how binary addition works: it sums up two digits at the same place plus carry obtained from the previous place. 
    Use sum%2 as the digit for the current place, sum/2 as the number needs to be carried to the next place.    
    Iteratively run the above operations until at least one full pass of the shorter string. It is possible that there is an extra number carried to the new place, so remember to check that outside the while loop.
    Remember to reverse the result at the end because digit is appended in reverse order.
*/

public class Solution {
    public String addBinary(String a, String b) {
        int ixa = a.length()-1, ixb = b.length()-1, carry = 0, sum = 0;
        StringBuffer sb = new StringBuffer(); 
        while (ixa >= 0 && ixb >= 0){
            sum = (int)(a.charAt(ixa--)-'0') + (int)(b.charAt(ixb--)-'0') + carry;
            sb.append(sum%2);
            carry = sum / 2;
        }
        // the following code is somewhat duplicated, there is way to make it concise in only one while loop
        while (ixa >= 0){
            sum = (int)(a.charAt(ixa--)-'0') + carry;
            sb.append(sum%2);
            carry = sum / 2;
        }       
        while (ixb >= 0) {
            sum = (int)(b.charAt(ixb--)-'0') + carry;
            sb.append(sum%2);
            carry = sum / 2;
        }
        if (carry != 0) {
	    sb.append(carry);
	}
        return sb.reverse().toString();
    }
}

// a concise version
public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int ixa = a.length() - 1, ixb = b.length() - 1, carry = 0, sum = 0;
        while (ixa >= 0 || ixb >= 0) {
            sum = carry;
            if (ixa >= 0) {
		sum += a.charAt(ixa--) - '0';
	    }
            if (ixb >= 0) {
		sum += b.charAt(ixb--) - '0';
	    }
            sb.append(sum%2);
            carry = sum / 2;
        }
        if (carry != 0) {
	    sb.append(carry);
	}
        return sb.reverse().toString();
    }
}
