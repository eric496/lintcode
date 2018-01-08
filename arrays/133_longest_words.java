/*
Given a dictionary, find all of the longest words in the dictionary.

Example
    Given
    {
      "dog",
      "google",
      "facebook",
      "internationalization",
      "blabla"
    }
    the longest words are(is) ["internationalization"].
    Given
    {
      "like",
      "love",
      "hate",
      "yes"
    }
    the longest words are ["like", "love", "hate"].

Challenge
    It's easy to solve it in two passes, can you do it in one pass?
*/

/*
Thought process
    1. A trivial solution: two passes
           First pass counts the max length of all words. Second pass adds all strings of the max length to the result list. 
    2. One-pass method:
           Iterate the dictionary, if the length of the current string is greater than that of the strings in the result list, then clear the result list and add the current string and update the max length.
           If the length of the current string equals the max length, then append it to the result list.
*/

// two passes
class Solution {
    public ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<>();
        if (dictionary == null || dictionary.length == 0) return result;
        int maxLen = 0;
        for (String s : dictionary) {
            if (s.length() > maxLen) {
		maxLen = s.length();
	    }
	}
        for (String s : dictionary) {
            if (s.length() == max) {
		result.add(s);
	    }
	}
        return result;
    }
}

// one pass
class Solution {
    public ArrayList<String> longestWords(String[] dictionary) {
	ArrayList<String> result = new ArrayList<>();
        if (dictionary == null || dictionary.length == 0) return result;
        int maxLen = 0;
        for (String s : dictionary) {
            if (s.length() > maxLen) {
                result.clear();
                result.add(s);
		maxLen = s.length();
            } else if (s.length() == maxLen) {
                result.add(s);
            }
        }
        return result;
    }
}
