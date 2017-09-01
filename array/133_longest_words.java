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

class Solution {
    ArrayList<String> longestWords(String[] dictionary) {
        if(dictionary.length == 0) return null;
        int max = 0;
        ArrayList<String> result = new ArrayList<String>();
        for(String s: dictionary) {
            if(s.length() > max) max = s.length();
        }
        for(String s: dictionary) {
            if(s.length() == max) result.add(s);
        }
        return result;
    }
}
