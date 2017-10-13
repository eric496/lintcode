/*
Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

Notice
    If there is no such window in source that covers all characters in target, return the emtpy string "".
    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

Clarification
    Should the characters in minimum window has the same order in target?
        Not necessary.

Example
    For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

Challenge
    Can you do it in time complexity O(n) ?
*/

public class Solution {
    public String minWindow(String source , String target) {
        HashMap<Character,Integer> map = new HashMap();
        for(char c : source.toCharArray()) map.put(c,0);
        for(char c : target.toCharArray()) {
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                return "";
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = target.length();
        while(end < source.length()) {
            char c1 = source.charAt(end);
            if(map.get(c1) > 0) counter--;
            map.put(c1, map.get(c1)-1);
            end++;
            while(counter == 0) {
                if(minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = source.charAt(start);
                map.put(c2, map.get(c2)+1);
                if(map.get(c2) > 0) counter++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : source.substring(minStart, minStart+minLen);
    }
}
