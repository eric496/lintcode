/*
Given two binary strings, return their sum (also a binary string).

Example
a = 11
b = 1
Return 100
*/

public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        int ia = a.length()-1;
        int ib = b.length()-1;
        int carry = 0;
        String result = "";
        while(ia >= 0 && ib >= 0){
            int sum = (int)(a.charAt(ia) - '0') + (int)(b.charAt(ib) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum / 2;
            ia--;
            ib--;
        }
        while(ia >= 0){
            int sum = (int)(a.charAt(ia) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum / 2;
            ia--;
        }       
        while(ib >= 0) {
            int sum = (int)(a.charAt(ib) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum /2;
            ib--;
        }
        if (carry == 1) result = "1" + result;
        return result;
    }

}
