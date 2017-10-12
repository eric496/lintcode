/*
Given a string, find the length of the longest substring without repeating characters.

Example
    For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
    For "bbbbb" the longest substring is "b", with the length of 1.

Challenge
    O(n) time
*/

// use an extra array
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // map from character's ASCII to its last occured index
        int[] map = new int[256];
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }
        return ans;
    }
}

// use an extra hash map
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for(int i=0, j=0; i<s.length(); ++i) {
            if (map.containsKey(s.charAt(i)))
                j = Math.max(j,map.get(s.charAt(i))+1);
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}

// use an extra hash set
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}

// DP
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cache = new int[128];
        Arrays.fill(cache, -1);
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
          start = Math.max(cache[s.charAt(i)] + 1, start);
          max = Math.max(max, i - start + 1);
          cache[s.charAt(i)] = i;
        }
        return max;
    }
}
