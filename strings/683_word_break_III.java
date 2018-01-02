/*
Give a dictionary of words and a sentence with all whitespace removed, return the number of sentences you can form by inserting whitespaces to the sentence so that each word can be found in the dictionary.

Example
    Given a String CatMat
    Given a dictionary ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
    return 3
    we can form 3 sentences, as follows:
    CatMat = Cat Mat
    CatMat = Ca tM at
    CatMat = C at Mat
*/

public class Solution {
    private int result = 0;
    public int wordBreak3(String s, Set<String> dict) {
        int n = s.length();
        String lowerCaseStr = s.toLowerCase();
        Set<String> set = new HashSet<>();
        for(String str : dict) {
            set.add(str.toLowerCase());
        }
        wordBreakhelper(lowerCaseStr, set, 0, n);
        return result;
    }

    public void wordBreakhelper(String s, Set<String> dict, int start, int len) {
        if (start == len) {
            result++;
        }
        for(int i = start; i < len; i++) {
            String substr = s.substring(start, i+1);
            if (dict.contains(substr)) {
               wordBreakhelper(s, dict, i+1, len);
            }
        }
    }
}
