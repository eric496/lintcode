/*
Two strings are given and you have to modify 1st string such that all the common characters of the 2nd strings have to be removed and the uncommon characters of the 2nd string have to be concatenated with uncommon characters of the 1st string.

Example
    Given s1 = aacdb, s2 = gafd
    return cbgf
    Given s1 = abcs, s2 = cxzca;
    return bsxz
*/

/*
Thought process:
    1. Brute force
    2. Three passes using hashmap:
           First pass stores s2 characters in map.
           Second pass adds all unique characters in s1 to result.
           Third pass adds all unique characters in s2 to result.
*/

// O(n^2) time
public class Solution {
    public String concatenetedString(String s1, String s2) {
        StringBuffer sb1 = new StringBuffer(s1);
        StringBuffer sb2 = new StringBuffer(s2);
        for (char c : s2.toCharArray()) {
            String s = String.valueOf(c);
            if (sb1.indexOf(s) != -1) {
                while (sb1.indexOf(s) != -1) {
                    sb1.deleteCharAt(sb1.indexOf(s));
                }
                while (sb2.indexOf(s) != -1) {
                    sb2.deleteCharAt(sb2.indexOf(s));
                }
            }
        }
        return sb1.append(sb2).toString();
    }
}

// O(n) time using hashmap
public class Solution {
    public String concatenetedString(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (char c : s2.toCharArray()) {
            map.put(c, 1);
        }
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, 0);
            } else {
                sb.append(String.valueOf(c));
            }
        }
        for (char c : s2.toCharArray()) {
            if (map.get(c) == 1) {
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}
