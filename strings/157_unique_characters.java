/*
Implement an algorithm to determine if a string has all unique characters.

Example
Given "abc", return true.
Given "aab", return false.

Challenge
What if you can not use additional data structures?
*/

/*
Thought process:
    1. Since we need to check duplication, it is easy to come up with the hash set method.
    2. If it is only ASCII characters, use an array will save overhead.
    3. O(1) space solution: use two for loops with O(n2) time
*/

// O(n) time and O(1) space - with an extra array
public class Solution {
    public boolean isUnique(String str) {
        if(str == null || str.length() == 0) return false;
        int[] count = new int[256];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
            if(count[str.charAt(i)] > 1) return false;
        }
        return true;
    }
}

// O(n) time and O(n) space - with an extra hash set
public class Solution {
    public boolean isUnique(String str) {
        if(str == null || str.length() == 0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < str.length(); i++) {
            if(!set.contains((int)str.charAt(i))) {
                set.add((int)str.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}

// O(n2) time and O(1) space
public class Solution {
    public boolean isUnique(String str) {
        if(str == null || str.length() == 0) return false;
        for(int i = 0; i < str.length(); i++) {
            for(int j = i+1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }
}
