/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example
    Given "aacecaaa", return "aaacecaaa".
    Given "abcd", return "dcbabcd".
*/

/*
Thought process:
    1. Recursive solution:
    2. KMP
*/

// recursion
public class Solution {
    public String convertPalindrome(String str) {
        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == str.charAt(j)) {
		j += 1;
	    }
        }
        if (j == str.length()) return str; 
        String suffix = str.substring(j);
        return new StringBuffer(suffix).reverse().toString() + convertPalindrome(str.substring(0, j)) + suffix;
    }
}

// KMP
public class Solution {
    public String convertPalindrome(String str) {
        String temp = str + "#" + new StringBuilder(str).reverse().toString();
        int[] table = getTable(temp);
        //get the maximum palin part in s starts from 0
        return new StringBuilder(str.substring(table[table.length-1])).reverse().toString() + str;
    }
    
    public int[] getTable(String str){
        //get lookup table
        int[] table = new int[str.length()];
        //pointer that points to matched char in prefix part
        int index = 0;
        //skip index 0, we will not match a string with itself
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(index) == str.charAt(i)){
                //we can extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index ++;
            } else {
                //match failed, we try to match a shorter substring
                //by assigning index to table[i-1], we will shorten the match string length, and jump to the 
                //prefix part that we used to match postfix ended at i - 1
                index = table[i-1];
                while (index > 0 && str.charAt(index) != str.charAt(i)){
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index-1];
                }
                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if (str.charAt(index) == str.charAt(i)){
                    //if match, then extend one char 
                    index ++ ;
                }
                table[i] = index;
            }
        }
        return table;
    }
}
