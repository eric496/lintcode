/*
Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
Given "abcdefg".
offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
*/

/*
Thought process:
    1. 3-step reversal, but be careful of the order of the 3 reversal. 
    2. Notice the offset can be larger than the length of the string, so use the modulus as the offset.
*/

//
public class Solution {
    public void rotateString(char[] str, int offset) {
        if(str == null || str.length == 0) return;
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
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
