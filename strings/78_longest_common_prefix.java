/*
Given k strings, find the longest common prefix (LCP).

Example
    For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
    For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
*/

/*
Thought process:
    1. Set the first string in the array as the prefix.
       Iterate the string array, if the prefix is not a substring of the current string, then remove the last character from the prefix.
       It is like calculate the intersection of a couple of events, we first calculate A1 intersects A2, then (A1 intersects A2) intersects A3, ...
    2. Sort the array first, then the common prefix of the first and the last strings is the longest common prefix.
*/

// method 1
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
		pre = pre.substring(0, pre.length()-1);
	    }
	}
        return pre;
    }
}

// method 2
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < first.length(); i++) {
            if (last.length() > i && first.charAt(i) == last.charAt(i)) {
                sb.append(first.charAt(i));
            } else {
                return sb.toString();
            }
	}
        return sb.toString();
    }
}
