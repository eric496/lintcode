/*
Given an integer, convert it to a roman numeral.
The number is guaranteed to be within the range from 1 to 3999.

Clarification
    What is Roman Numeral?
        https://en.wikipedia.org/wiki/Roman_numerals
        https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
        http://baike.baidu.com/view/42061.htm

Example
    4 -> IV
    12 -> XII
    21 -> XXI
    99 -> XCIX
    more examples at: http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm
*/

// solution 1
public class Solution {
    public String intToRoman(int num) {
	int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}

// solution 2
public class Solution {
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
