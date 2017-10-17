/*
Given a string which contains only letters. Sort it by lower case first and upper case second.

Notice
    It's NOT necessary to keep the original order of lower-case letters and upper case letters.

Example
    For "abAcD", a reasonable answer is "acbAD"

Challenge
    Do it in one-pass and in-place.
*/

public class Solution {
    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
	char tmp ;
	while(i <= j) {
	    while (i <= j && Character.isLowerCase(chars[i]) ) i++;
	    while (i <= j && Character.isUpperCase(chars[j]) ) j--;
	    if (i <= j) {
		tmp = chars[i];
		chars[i] = chars[j];
		chars[j] = tmp;
		i++; 
		j--;
	    }
	}
	return ;
    }
}
