/*
Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
    Given "abcdefg".
    offset=0 => "abcdefg"
    offset=1 => "gabcdef"
    offset=2 => "fgabcde"
    offset=3 => "efgabcd"

Challenge
    Rotate in-place with O(1) extra memory.
*/

/*
Thought process:
    Two corner cases: 
        1) Return if str is null or str is empty.
        2) When offset is greater than the length of the string, take the modulo.
    Use the three-step reversal method. 
*/

public class Solution {
    public void rotateString(char[] str, int offset) {
	if (str == null || str.length == 0) return;
	// normalize offest
        offset %= str.length;
        reverse(str, 0, str.length-offset-1);
        reverse(str, str.length-offset, str.length-1);
        reverse(str, 0, str.length-1);
    }
    
    private void reverse(char[] str, int low, int high) {
        while (low < high) {
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
    }
}
