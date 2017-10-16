/*
Given a roman numeral, convert it to an integer.
The answer is guaranteed to be within the range from 1 to 3999.

Clarification
    What is Roman Numeral?
        https://en.wikipedia.org/wiki/Roman_numerals
        https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
        http://baike.baidu.com/view/42061.htm

Example
    IV -> 4
    XII -> 12
    XXI -> 21
    XCIX -> 99
*/

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
	map.put('M', 1000);
	int number = 0;
	char prev = '#';
	for (int i = s.length() - 1; i >= 0; i--) {
	    char ch = s.charAt(i);
            int value = map.get(ch);
	    if (value < number && ch != prev)
		number = number - value;
	    else
		number = number + value;
		prev = ch;
	}
	return number;
    }
}
