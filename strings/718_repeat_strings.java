/*
Write a function, give a string A consisting of N characters and a string B consisting of M characters, returns the number of times A must be stated such that B is a substring of the repeated string. If B can never be a substring of the repeated A, then your function should return -1.

Notice
    Assume that 0 <= N <= 1000, 1 <= M <= 1000

Example
    Given A = abcd, B = cdabcdab
    your function should return 3, bcause after stating string A three times we otain the string abcdabcdabcd. String B is a substring of this string.
*/

public class Solution {
    public int repeatedString(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return -1;
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.toString().contains(B)) return count;
        if (sb.append(A).toString().contains(B)) return count++;
        return -1;
    }
}
