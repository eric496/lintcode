/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.

Notice
Assume the length of given string will not exceed 1010.

Example
Given s = "abccccdd" return 7
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

/*
Thought process:
    1. This is equivalent to counting how many "pairs" of the same character at most. 
       Say, if we have "aa" that is one pair of "a", if we have "bbbb" that is two pairs of "b".
       The final count is just number of pairs * 2. If there are even number of some characters that cannot match up a pair. 
       Then we can add any one of them in the middle of the string to extend the palindrome by 1.
    2. Programatically this can be solved using a hash set. If the set does not have the character, 
       add it to the set. If it has the character, the current character matches up a pair. We add count by 1 and remove the
       existing character from the set.
       Remember to check if the set is empty. Empty means all characters match up pairs. If not, we should add 1 in order to make it longest.   
*/

public class Solution {
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }
}
