/*
Given a digit string excluded 01, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Notice
    Although the above answer is in lexicographical order, your answer could be in any order you want.

Example
    Given "23"
    Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        Queue<String> q = new LinkedList<>();
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        q.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while (q.peek().length() == i) {
                String str = q.remove();
                for (char c : map[num].toCharArray()) {
                    q.add(str+c);
                }
            }
        }
        List<String> result = new ArrayList(q);
        return result;
    }
}
