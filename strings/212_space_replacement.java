/*
Write a method to replace all spaces in a string with %20. The string is given in a characters array, you can assume it has enough space for replacement and you are given the true length of the string.
You code should also return the new length of the string after replacement.

Notice
    If you are using Java or Python，please use characters array instead of string.

Example
    Given "Mr John Smith", length = 13.
    The string after replacement should be "Mr%20John%20Smith", you need to change the string in-place and return the new length 17.

Challenge
    Do it in-place.
*/

/*
Thought process:
    Two passes: First pass counts the length of the new array. Second pass fills in "%20" from backward.
*/

public class Solution {
    public int replaceBlank(char[] string, int length) {
        if (length == 0 || string == null) return 0;
        int count = length; 
        for (char c : string) {
	    if (c == ' ') {
		count += 2;
	    }
	}
        int ix = count - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[ix--] = '0';
                string[ix--] = '2';
                string[ix--] = '%';
            } else {
                string[ix--] = string[i];
            }
        }
        return count;
    }
}
