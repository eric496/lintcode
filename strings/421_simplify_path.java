/*
Given an absolute path for a file (Unix-style), simplify it.

Example
    "/home/", => "/home"
    "/a/./b/../../c/", => "/c"

Challenge
    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
*/

public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> stack = new LinkedList<String>();
        for(String s: path.split("/")){
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.removeLast();
            }
            else if(!s.equals("") && !s.equals(".")) {
                stack.add(s);
            }
        }
        for(String s: stack)
            sb.append(s+"/");
        if(!stack.isEmpty()) sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
