/*
Given a string s, cut s into some substrings such that every substring is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example
    Given s = "aab",
    Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.
*/

public class Solution {
    public int minCut(String s) {
        if(s.length() == 0) return 0;
        int[] c = new int[s.length()+1];
        for(int i = 0; i < s.length(); i++) 
            c[i]=Integer.MAX_VALUE;
        c[s.length()] = -1;
        for(int i=s.length()-1;i>=0;i--){
            for(int a = i, b = i; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--,b++) 
                c[a] = Math.min(c[a], 1+c[b+1]);
            for(int a = i, b = i + 1 ; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++) 
                c[a]=Math.min(c[a],1+c[b+1]);
        }
        return c[0];
    }
}

// DP
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        //Initiation
        int length = s.length();
        boolean[][] palindrome= new boolean[length][length];
        for (int i = 0; i < length; i++)
            Arrays.fill(palindrome[i], false);
        int[] results = new int[length];
       //Start looping 
        for (int start = length - 1; start >= 0; start--){
            results[start] = length - start - 1; //Worst case:need length-start-i cuts
            for (int end = start; end < length; end++){
                if (s.charAt(start) == s.charAt(end)){
                    if (end - start < 2)    //Refer to these two cases: xx OR xyx
                        palindrome[start][end] = true;
                    else //Depends on the inner substring,if the inner substring is palindrome,the outer is
                        palindrome[start][end] = palindrome[start+1][end-1];
                }
                if (palindrome[start][end])
                    if (end == length-1)
                        results[start]=0;
                    else
                        results[start] = Math.min(results[start], results[end+1]+1);
            }
        }
        return results[0];
    }
}
