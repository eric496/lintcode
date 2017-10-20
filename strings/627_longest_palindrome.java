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
    1. The frequency of a character can either be even or odd. If it is even, we always want it to be included in the palindrome 
       in order to extend the palindrome as far as possible. If it is odd, we always want (n-1), i.e. the largest even number to 
       be included in the palindrome. What we need is a flag variable to keep track whether the array has odd numbered characters.
       If so, the final result should increment by one in order to get the largest length. 
    2. This is equivalent to counting how many "pairs" of the same character at most. 
       Say, if we have "aa" that is one pair of "a", if we have "bbbb" that is two pairs of "b".
       The final count is just number of pairs * 2. If there are even number of some characters that cannot match up a pair. 
       Then we can add any one of them in the middle of the string to extend the palindrome by one.
       This can be solved using a hash set. If the set does not have the character, 
       add it to the set. If it has the character, the current character matches up a pair. We add count by one and remove the
       existing character from the set. Remember to check if the set is empty. Empty means all characters match up pairs. 
       If not, we should add 1 in order to make it longest.   
*/

// O(n) time and O(n) space - two passes
public class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else 
                map.put(c, 1);
        }
        int cnt = 0;
        boolean hasOdd = false;
        for(char c : map.keySet()) {
            cnt += map.get(c) % 2 == 0 ? map.get(c) : map.get(c) - 1;
            if(map.get(c) % 2 != 0) hasOdd = true;
        }
        return hasOdd ? cnt + 1 : cnt;
    }
}

// O(n) time and O(n) space - one pass
public class Solution {
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }
        if(!set.isEmpty()) return count * 2 + 1;
        return count * 2;
    }
}
