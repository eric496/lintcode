/*
Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers [start, end]. For each query, calculate the sum number between index start and end in the given array, return the result list.

Notice
    We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Example
    For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]

Challenge
    O(logN) time for each query
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
 
public class Solution {
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        long[] prefixSum = new long[A.length+1];
        for (int i=0; i<A.length; i++)
            prefixSum[i+1] = prefixSum[i] + A[i];
        List<Long> res = new ArrayList<Long>();
        for (Interval interval : queries) {
            int start = interval.start;
            int end = interval.end;
            long result = prefixSum[end+1] - prefixSum[start];
            res.add(result);
        }
        return res;
    }
}
