/*
You know what, left pad is javascript package and referenced by React
One day his author unpublished it, then a lot of javascript projects in the world broken.
You can see from github it's only 11 lines.
You job is to implement the left pad function. If you do not know what left pad does, see examples below and guess.

Example
leftpad("foo", 5)
>> "  foo"
leftpad("foobar", 6)
>> "foobar"
leftpad("1", 2, "0")
>> "01"
*/

public class StringUtils {
    static public String leftPad(String originalStr, int size) {
        int diff = size - originalStr.length();
        if(diff <= 0) return originalStr;
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < diff; i++) sb.append(" ");
        sb.append(originalStr);
        return sb.toString();
    }

    static public String leftPad(String originalStr, int size, char padChar) {
        int diff = size - originalStr.length();
        if(diff <= 0) return originalStr;
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < diff; i++) sb.append(Character.toString(padChar));
        sb.append(originalStr);
        return sb.toString();
    }
}
