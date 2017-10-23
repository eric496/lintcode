/*
For a given source string and a target string, you should output the first index(from 0) of target string in source string.
If target does not exist in source, just return -1.

Clarification
Do I need to implement KMP Algorithm in a real interview?
    Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure your confirm with the interviewer first.

Example
    If source = "source" and target = "target", return -1.
    If source = "abcdabcdefg" and target = "bcd", return 1.

Challenge
    O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
*/

/*
Thought process:
    1. Use string methods (substring, equals) to search for the substring.
       Notice that indices in substring method are inclusive. 
       "=" should be included in the for condition.
    2. Use two for loops - outter loop for source, inner loop for target.
    3. KMP algorithm (TO DO)
*/

// O(n^2) time using string methods
class Solution {
    public int strStr(String source, String target) {
        if(source == null || target == null || source.length() < target.length()) return -1;
        if(target.length() == 0) return 0;
        for(int i = 0; i <= source.length() - target.length(); i++)
            if(source.substring(i, i+target.length()).equals(target)) return i;
        return -1;
    }
}

// O(n^2) time solution
class Solution {
    public int strStr(String source, String target) {
        if(source == null || target == null || source.length() < target.length()) return -1;
        if(target.length() == 0) return 0;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
              if (j == target.length()) return i;
              if (i + j == source.length()) return -1;
              if (target.charAt(j) != source.charAt(i + j)) break;
            }
        }
    }
}
