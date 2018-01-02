/*
Given a string containing uppercase alphabets and integer digits (from 0 to 9), write a function to return the alphabets in the order followed by the sum of digits.

Example
    Given str = AC2BEW3, return ABCEW5
    Alphabets in the lexicographic order, followed by the sum of integers(2 and 3).
*/

public class Solution {
    public String rearrange(String str) {
        int[] count = new int[26];
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                count[str.charAt(i)-'A']++;
            } else {
                sum += str.charAt(i) - '0';
            } 
        }
        String result = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('A'+i);
            while (count[i]-- != 0) {
                result += ch;
            }
        }
        if (sum > 0) {
            result += sum;
        }
        return result;
    }
}
