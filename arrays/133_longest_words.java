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
*/

/*
Thought process
    1. An obvious approach is two passes: first for loop to count the max length of all words; 
       second for loop to pick out the words which are of the max length.
    2. Don't forget the corner case when the dictionary is null or empty.
*/

//two passes
class Solution {
    ArrayList<String> longestWords(String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) return null;
        int max = 0;
        for(String s : dictionary) {
            if(s.length() > max) max = s.length();
        }
        ArrayList<String> res = new ArrayList<String>();
        for(String s : dictionary) {
            if(s.length() == max) res.add(s);
        }
        return res;
    }
}

//one pass
class Solution {
    ArrayList<String> longestWords(String[] dictionary) {
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
