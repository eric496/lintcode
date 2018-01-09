/*
The words are same rotate words if rotate the word to the right by loop, and get another. Count how many different rotate word sets in dictionary.
E.g. picture and turepic are same rotate words.

Notice
    All words are lowercase.

Example
    Given dict = ["picture", "turepic", "icturep", "word", "ordw", "lint"]
    return 3.
    "picture", "turepic", "icturep" are same ratote words.
    "word", "ordw" are same too.
    "lint" is the third word that different from the previous two words.
*/

/*
Thought process:
    Two strings str1 and str2 are rotate words if str1.length() == str2.length() and (str1+str1).indexOf(str2) != -1.
    Iterate the word list, if the set does not contain the current word, save all of its rotate words in the set. Update the counter at each iteration.   
*/

// method 1
public class Solution {
    public int countRotateWords(List<String> words) {
        if (words == null || words.size() == 0) return 0;
        Set<String> set = new HashSet<>();
        int count = 0;
        for (String str : words) {
            if (!set.contains(str)) {
                count++;
                for (int i = 0; i <= str.length(); i++) {
                    set.add(rotate(str, i));
		}
            }
        }
        return count;
    }
    
    private String rotate(String str, int offset) {
        return str.substring(offset, str.length()) + str.substring(0, offset);
    }
}

// method 2 with MLE; need to figure out why later
public class Solution {
    public int countRotateWords(List<String> words) {
        if (words == null || words.size() == 0) return 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.size(); i++) {
            boolean isRotate = false;
            for (String str : set) {
                if (isRotateWords(words.get(i), str)) {
                    isRotate = true;
                    break;
                }
            }
            if (!isRotate) {
		set.add(words.get(i));
	    }
        }
        return set.size();
    }
    
    private boolean isRotateWords(String str1, String str2) {
        return str1.length() == str2.length() && (str1+str1).indexOf(str2) != -1 ? true : false;
    }
}

// method 3 with MLE; need to figure out why later
public class Solution {
    public int countRotateWords(List<String> words) {
        if (words == null || words.size() == 0) return 0;
        boolean[] isRotate = new boolean[words.size()];
        for (int i = 0; i < words.size(); i++) {
            if (isRotate[i]) continue;
            for (int j = i + 1; j < words.size(); j++) {
                if (isRotateWords(words.get(i), words.get(j))) {
                    isRotate[j] = true;
		}
            }
        }
        int count = 0;
        for (boolean bool : isRotate) {
            if (!bool) {
		count++;
	    }
	}
        return count;
    }

    private boolean isRotateWords(String str1, String str2) {
        return str1.length() == str2.length() && (str1+str1).indexOf(str2) != -1 ? true : false;
    }
}
