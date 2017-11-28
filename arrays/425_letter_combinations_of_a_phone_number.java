/*
Given a digit string excluded 01, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Cellphone

Notice
    Although the above answer is in lexicographical order, your answer could be in any order you want.

Example
    Given "23"
    Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        Queue<String> ans = new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t+s);
                }
            }
        }
        List<String> result = new ArrayList(ans);
        return result;
    }
}
