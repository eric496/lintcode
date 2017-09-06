/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 40,000.
The order of output does not matter.

Example
Given s = "cbaebabacd" p = "abc"
return [0, 6]
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
*/

/*
Thought process:
    1. It is easy to come up with the brute-force algorithm:
       loop through s, at each element e, check whether the substring starting at e with the same length as p 
       is an anagram of p. It uses O(n2) time and O(1) space.
    2. Sliding window method
*/


// O(n2) time 
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() < p.length()) return null;
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        for(int i = 0; i <= schar.length - p.length(); i++) {
            if(isAnagrams(Arrays.copyOfRange(schar, i, i+pchar.length), pchar)) res.add(i);
        }
        return res;
    }

    private boolean isAnagrams(char[] schar, char[] pchar){
        int[] count = new int[26];
        for(int i = 0; i < schar.length; i++) {
            count[schar[i]-'a']++;
            count[pchar[i]-'a']--;
        }
        for(int n : count) {
            if(n != 0) return false;
        }
        return true;
    }
}
