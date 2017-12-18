/*
Given a string which contains only letters. Sort it by lower case first and upper case second.

Notice
    It's NOT necessary to keep the original order of lower-case letters and upper case letters.

Example
    For "abAcD", a reasonable answer is "acbAD"

Challenge
    Do it in one-pass and in-place.
*/

/*
Thought process:
    Two pointers: traversing from both ends of the array, the head pointer keeps pointing to the next upper case character, while the tali pointer pointing to the next lower case character. 
                  Swap the two characters in place.
*/

public class Solution {
    public void sortLetters(char[] chars) {
        int low = 0, high = chars.length - 1;
	while (low <= high) {
	    while (low <= high && Character.isLowerCase(chars[low])) {
		low++;
	    }
	    while (low <= high && Character.isUpperCase(chars[high])) {
	        high--;
	    }
	    if (low <= high) {
		swap(low, high, chars);
		low++;
		high--;
	    }
	}
    }
    
    private void swap(int ix1, int ix2, char[] chars) {
        char temp = chars[ix1];
        chars[ix1] = chars[ix2];
        chars[ix2] = temp;
    }
}
