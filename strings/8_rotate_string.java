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
    1. Two corner cases: 
           1) Return if str is null or str is empty.
           2) When offset is greater than the length of the string, take the modulo.
    2. Use the three-step reversal. 
*/

public class Solution {
    public void rotateString(char[] str, int offset) {
	if(str == null || str.length == 0) return;
        offset %= str.length;
        reverse(str, 0, str.length-offset-1);
        reverse(str, str.length-offset, str.length-1);
        reverse(str, 0, str.length-1);
    }
    
    private void reverse(char[] str, int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
