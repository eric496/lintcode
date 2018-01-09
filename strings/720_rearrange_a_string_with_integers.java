/*
Given a string containing uppercase alphabets and integer digits (from 0 to 9), write a function to return the alphabets in the order followed by the sum of digits.

Example
    Given str = AC2BEW3, return ABCEW5
    Alphabets in the lexicographic order, followed by the sum of integers(2 and 3).
*/

/*
Thought process:
    Since there is only uppercase alphabets (26 in total) and integers, we can use an array of length 26 to count the frequency of the characters.
    If it is not a alphabet, then it must be an integer, add it to sum. 
    After a whole pass of the string, we get the alphabets in order and their frequencies.
    Append the ordered alphabets to result and append the sum at the end.
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('A'+i);
            while (count[i]-- != 0) {
                result.append(ch);
            }
        }
        if (sum > 0) {
            result.append(sum);
        }
        return result.toString();
    }
}
