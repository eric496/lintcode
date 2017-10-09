/*
Given a list of non negative integers, arrange them such that they form the largest number.

Notice
    The result may be very large, so you need to return a string instead of an integer.

Example
    Given [1, 20, 23, 4, 8], the largest formed number is 8423201.

Challenge
    Do it in O(nlogn) time complexity.
*/

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
	    // Convert int array to String array, so we can sort later on
	    String[] s_nums = new String[nums.length];
	    for(int i = 0; i < nums.length; i++) s_nums[i] = String.valueOf(nums[i]);
	    // Comparator to decide which string should come first in concatenation
	    Comparator<String> comp = new Comparator<String>(){
	        @Override
		public int compare(String str1, String str2){
		    String s1 = str1 + str2;
			String s2 = str2 + str1;
			return s2.compareTo(s1); // reverse order here, so we can do append() later
	        }
	    };
	Arrays.sort(s_nums, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_nums[0].charAt(0) == '0') return "0";
	    StringBuilder sb = new StringBuilder();
	    for(String s: s_nums) sb.append(s);
	    return sb.toString();
    }
}
