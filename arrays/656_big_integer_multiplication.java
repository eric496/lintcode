/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2

Example
    The length of both num1 and num2 is < 110.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public class Solution {
    public String multiply(String num1, String num2) {
        int[] num = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int prod = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                num[i+j] += (prod + num[i+j+1]) / 10;
                num[i+j+1] = (num[i+j+1] + prod) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: num) if(sb.length() > 0 || i > 0)  sb.append(i);
        return (sb.length() == 0) ? "0" : sb.toString(); 
    }
}
