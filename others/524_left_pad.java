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
        int padLen = size - originalStr.length();
        if (padLen <= 0) return originalStr;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < padLen; i++) {
	    sb.append(" ");
	}
        return sb.append(originalStr).toString();
    }

    static public String leftPad(String originalStr, int size, char padChar) {
        int padLen = size - originalStr.length();
        if (padLen <= 0) return originalStr;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < padLen; i++) {
	    sb.append(String.valueOf(padChar));
	}
        return sb.append(originalStr).toString();
    }
}
