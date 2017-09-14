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
    1. Use hashmap, sorted strings as keys and anagrams as values. 
       Loop through the map, append all array list whose length is greater than 1 to the result.
*/

public class Solution {
    public List<String> anagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return null;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] charStr = strs[i].toCharArray();
            Arrays.sort(charStr);
            String charSort = new String(charStr);
            if(map.containsKey(charSort)) {
                map.get(charSort).add(strs[i]);
            } else {
                ArrayList<String> li = new ArrayList<String>();
                li.add(strs[i]);
                map.put(charSort, li);
            }
        }
        ArrayList<String> result = new ArrayList<String>();
        for(ArrayList<String> s : map.values()) if(s.size() > 1) result.addAll(s);
        return result;
    }
}
