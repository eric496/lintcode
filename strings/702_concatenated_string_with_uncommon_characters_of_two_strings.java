/*
Two strings are given and you have to modify 1st string such that all the common characters of the 2nd strings have to be removed and the uncommon characters of the 2nd string have to be concatenated with uncommon characters of the 1st string.

Example
    Given s1 = aacdb, s2 = gafd
    return cbgf
    Given s1 = abcs, s2 = cxzca;
    return bsxz
*/

public class Solution {
    public String concatenetedString(String s1, String s2) {
        StringBuffer sb1 = new StringBuffer(s1);
        StringBuffer sb2 = new StringBuffer(s2);
        for(char c : s2.toCharArray()) {
            String s = String.valueOf(c);
            if(sb1.indexOf(s) != -1) {
                while(sb1.indexOf(s) != -1) sb1.deleteCharAt(sb1.indexOf(s));
                while(sb2.indexOf(s) != -1) sb2.deleteCharAt(sb2.indexOf(s));   
            }
        }
        return sb1.append(sb2).toString();
    }
}
