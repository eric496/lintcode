/*
Given a non-negative integer n, print the number in words.

Notice
    n <= 2147483647

Example
    Given n = 125
    Return one hundred twenty five
*/

public class Solution {
    private final String[] LESS_THAN_20 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private final String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private final String[] THOUSANDS = {"", "thousand", "million", "billion"};
    
    public String convertWords(int num) {
        if (num == 0) return "zero";
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) +THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }
        return words.trim();
    }
    
    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " hundred " + helper(num % 100);
    }
}
