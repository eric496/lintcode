/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.

Notice
    The array may contain duplicates.

Example
    Given [4,4,5,6,7,0,1,2] return 0.
*/

public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0) return -1;
        int low = 0, high = num.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(num[mid] < num[high]) {
                high = mid;
            } else if(num[mid] > num[high]) {
                low = mid + 1;
            } else {
            // num[high] == num[mid]
                high--;
            }
        }
        return num[low];
    }
}
