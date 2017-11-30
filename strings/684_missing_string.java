/*
Given two strings, you have to find the missing string.

Example
    Given a string str1 = This is an example
    Given another string str2 = is example
    Return ["This", "an"]
*/

/*
Thought process:
    Use a set to store all strings in sentence 2. Iterate sentence 1 and store missing strings.
*/

// duplicates do not count towards missing string.
public class Solution {
    public List<String> missingString(String str1, String str2) {
        Set<String> set = new HashSet<>();
        String[] arr1 = str1.split("\\s+");
        String[] arr2 = str2.split("\\s+");
        if (arr1.length < arr2.length) {
            String[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        for (String s : arr2) {
	    set.add(s);
	}
        List<String> result = new ArrayList<>();
        for (String s : arr1) {
            if (!set.contains(s)) {
		result.add(s);
	    }
	}
        return result;
    }
}

// find the missing string including duplicates, 
// e.g. str1 = "This is is an example", str2 = "is an example", return ["This", "is"].
public class Solution {
    public List<String> missingString(String str1, String str2) {
        Map<String, Integer> map = new HashMap<>();
        String[] arr1 = str1.split("\\s+");
        String[] arr2 = str2.split("\\s+");
        if (arr1.length < arr2.length) {
            String[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        for (String s : arr2) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s)+1);
            } else { 
                map.put(s, 1);
	    }
        }
        List<String> result = new ArrayList<>();
        for (String s : arr1) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s)-1);
                if (map.get(s) < 0) {
		    result.add(s);
		}
            } else {
                result.add(s);
            }
        }
        return result;
    }
}
