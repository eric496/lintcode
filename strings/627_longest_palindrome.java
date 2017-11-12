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
    1. The frequency of any character in the string is either even or odd. If it is even, by symmetry, it should be included in the palindrome. 
       If it is odd, we can make it an even number by subtracting 1, which can be included in the palindrome then. 
       Detect whether the string contains a character whose frequency is even. If so, the final result should add 1, because we can extend the palindrome by adding one character in the middle.
    2. Method 1 can be simplified with one pass by using a set data structure. The basic idea is the same, but it counts how many "pairs" of the same characters by 
       toggling add (if it appears an odd number of times) or remove (if it appears an even number of times). When a character is removed from the set, count variable should increment by 1, 
       because it matches a pair. If set is not empty in the end, it means there is at least one character whose frequency is odd. Thus we need to add 1 in the result as the same reason explained in method 1.
*/

// O(n) time and O(n) space - two passes
public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            ] else {
                map.put(c, 1);
	    }
        }
        int count = 0;
        boolean hasOdd = false;
        for (char c : map.keySet()) {
            count += map.get(c) % 2 == 0 ? map.get(c) : map.get(c) - 1;
            if (map.get(c) % 2 != 0) {
		hasOdd = true;
	    }
        }
        return hasOdd ? count + 1 : count;
    }
}

// O(n) time and O(n) space - one pass
public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }
        if (!set.isEmpty()) return count * 2 + 1;
        return count * 2;
    }
}
