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
           First pass counts the max length of all words.
           Second pass adds all strings of the max length to the result list. 
    2. One-pass method:
           Iterate the dictionary, if the length of the current string is greater than that of the strings in the result list, then clear the result list and add the current string.
           If the length of the current string equals that of the strings in the result list, then append it to the result list.
*/

//two passes
class Solution {
    public ArrayList<String> longestWords(String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) return null;
        int max = 0;
        for(String s : dictionary)
            if(s.length() > max) max = s.length();
        ArrayList<String> res = new ArrayList<String>();
        for(String s : dictionary)
            if(s.length() == max) res.add(s);
        return res;
    }
}

//one pass
class Solution {
    public ArrayList<String> longestWords(String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) return null;
        ArrayList<String> res = new ArrayList<String>();
        for(String s : dictionary) {
            if(res.isEmpty() || s.length() > res.get(0).length()) {
                res.clear();
                res.add(s);
            } else if(s.length() == res.get(0).length()) {
                res.add(s);
            }
        }
        return res;
    }
}
