/*
Given an array of strings, return all groups of strings that are anagrams.

Notice
    All inputs will be in lower-case

Example
    Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
    Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
*/

/*
Thought process:
    Create a hashmap, iterate the string list and sort each string in the list, use the sorted string as key and a list of its anagrams as value.
    Create a result list, append all lists which contains more than one anagram from the hashmap. 
*/

// O(n) time and O(n) space using hashmap
public class Solution {
    public List<String> anagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return null;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(s);
                map.put(key, temp);
            }
        }
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.addAll(entry.getValue());   
            }
        }
        return result;
    }
}
