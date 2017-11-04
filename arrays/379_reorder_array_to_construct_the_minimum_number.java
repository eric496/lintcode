/*
Construct minimum number by reordering a given non-negative integer array. Arrange them such that they form the minimum number.

Notice
    The result may be very large, so you need to return a string instead of an integer.

Example
    Given [3, 32, 321], there are 6 possible numbers can be constructed by reordering the array:
    3+32+321=332321
    3+321+32=332132
    32+3+321=323321
    32+321+3=323213
    321+3+32=321332
    321+32+3=321323
    So after reordering, the minimum number is 321323, and return it.

Challenge
    Do it in O(nlogn) time complexity.
*/

// O(n) time 
public class Solution {
    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];  
        for (int i = 0; i < nums.length; i++) {  
            arr[i] = nums[i] + "";  
        }  
        Arrays.sort(arr, new Comparator<String>() {  
            public int compare(String s1, String s2) {  
                return (s1 + s2).compareTo(s2 + s1);  
            }  
        });  
        StringBuilder sb = new StringBuilder();  
        for (String s : arr) {  
            if (sb.length() == 0 && s.equals("0")) continue;  
            sb.append(s);  
        }  
        return sb.length() == 0 ? "0" : sb.toString(); 
    }
}
