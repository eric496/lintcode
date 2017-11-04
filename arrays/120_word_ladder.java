/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

Notice
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.

Example
    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.
*/

public class Solution {
    public int ladderLength(String start, String end, Set<String> wordList) {
        if (wordList == null) return 0;
        if (start.equals(end)) return 1;
        wordList.add(start);
        wordList.add(end);
        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        set.add(start);
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, wordList)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    
                    set.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}
