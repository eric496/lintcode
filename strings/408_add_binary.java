/*
Given two binary strings, return their sum (also a binary string).

Example
a = 11
b = 1
Return 100
*/

/*
Thought process:
    1. Use two position trackers to keep track of both a and b. 
       Calculate the addition of the current two digits plus the carry from previous place %2 as the current. 
       Update carry = sum / 2. Use a string buffer to store the result to save space (instead of using string addition)
       Remember to reverse the string buffer in order to make it correct order.
    2. Can be more concise using only one while loop.   
*/

// 
public class Solution {
    public String addBinary(String a, String b) {
        int ixa = a.length()-1;
        int ixb = b.length()-1;
        int carry = 0;
        StringBuffer res = new StringBuffer(); 
        while(ixa >= 0 && ixb >= 0){
            int sum = (int)(a.charAt(ixa--) - '0') + (int)(b.charAt(ixb--) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        while(ixa >= 0){
            int sum = (int)(a.charAt(ixa--) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }       
        while(ixb >= 0) {
            int sum = (int)(b.charAt(ixb--) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) res.append(carry);
        return res.reverse().toString();
    }
}

// a concise version
public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int ixa = a.length() - 1, ixb = b.length() - 1, carry = 0;
        while(ixa >= 0 || ixb >= 0) {
            int sum = carry;
            if(ixa >= 0) sum += a.charAt(ixa--) - '0';
            if(ixb >= 0) sum += b.charAt(ixb--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
