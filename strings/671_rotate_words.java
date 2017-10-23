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
    1. Two strings str1 and str2 are rotate words if str1.length() == str2.length() and (str1+str1).indexOf(str2) != -1.
    2. We can use either a hash set to store the unique strings or a boolean array to flag whether each string is a rotate word.
*/

// method 1
public class Solution {
    public int countRotateWords(List<String> words) {
        if(words == null || words.size() == 0) return 0;
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < words.size(); i++) {
            boolean isRotate = false;
            for(String str : set) {
                if(isRotateWords(words.get(i), str)) {
                    isRotate = true;
                    break;
                }
            }
            if(!isRotate) set.add(words.get(i));
        }
        return set.size();
    }
    
    private boolean isRotateWords(String str1, String str2) {
        return str1.length() == str2.length() && (str1+str1).indexOf(str2) != -1 ? true : false;
    }
}

// method 2
public class Solution {
    public int countRotateWords(List<String> words) {
        if(words == null || words.size() == 0) return 0;
        boolean[] isRotate = new boolean[words.size()];
        for(int i = 0; i < words.size(); i++) {
            if(isRotate[i]) continue;
            for(int j = i + 1; j < words.size(); j++) {
                if(isRotateWords(words.get(i), words.get(j)))
                    isRotate[j] = true;
            }
        }
        int count = 0;
        for(boolean bool : isRotate)
            if(!bool) count++;
        return count;
    }

    private boolean isRotateWords(String str1, String str2) {
        return str1.length() == str2.length() && (str1+str1).indexOf(str2) != -1 ? true : false;
    }
}
