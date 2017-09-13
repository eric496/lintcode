/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Notice
    The sequence of integers will be represented as a string.

Example
    Given n = 5, return "111221".
*/

public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return null;
        String result = "1";
        for(int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < result.length(); j++) {
                if(j < result.length() - 1 && result.charAt(j) == result.charAt(j+1)) {
                    count++;
                } else {
                    sb.append(Integer.toString(count) + result.charAt(j));
                    count = 1;
                }
            }
            result = sb.toString();
        }
        return result;
    }
}
