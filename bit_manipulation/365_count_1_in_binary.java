/*
Count how many 1 in binary representation of a 32-bit integer.

Example
    Given 32, return 1
    Given 5, return 2
    Given 1023, return 9
*/

/*
Thought process:
    1. An easy approach is to bit and num and 1, this will check if the last digit is a 1. 
       Then right shift num by 1, and loop to check every place.
    2. Brian Kernighan’s Algorithm: Subtraction of 1 from a number toggles all the bits (from right to left) 
       till the rightmost set bit(including the righmost set bit). 
       So if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), 
       we unset the righmost set bit. If we do n & (n-1) in a loop and count the no of times loop executes we get the set bit count. 
*/

// method 1
public class Solution {
    public int countOnes(int num) {
        int count = 0;
        while(num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}

// Brian Kernighan’s Algorithm
public class Solution {
    public int countOnes(int num) {
        int count = 0;
        while(num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
