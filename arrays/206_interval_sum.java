/*
Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers [start, end]. For each query, calculate the sum number between index start and end in the given array, return the result list.

Notice
    We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Example
    For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]

Challenge
    O(logN) time for each query
*/

/*
Thought process:
    1. Create an array to store cumulative sum from start to the current position. 
       For each query, the result is just the difference between cumulative sum at the interval end position and that at the interval start position.
    2. Segment tree
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

// O(n) time
public class Solution {
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        long[] sumSofar = new long[A.length+1];
        for (int i = 0; i < A.length; i++) {
            sumSofar[i+1] = sumSofar[i] + A[i];
        }
        List<Long> result = new ArrayList<Long>();
        for (Interval interval : queries) {
            int start = interval.start;
            int end = interval.end;
            long queryResult = sumSofar[end+1] - sumSofar[start];
            result.add(queryResult);
        }
        return result;
    }
} 

// O(logn) time using segment tree
public class Solution {

    SegmentTreeNode root;

    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        List<Long> res = new ArrayList<Long>();
        root = build(A, 0, A.length-1);
        for (Interval interval : queries) {
            int start = interval.start;
            int end = interval.end;
            res.add(query(root, start, end));
        }
        return res;
    }
    
    public class SegmentTreeNode {
        long sum;
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end) {
            this.sum = 0;
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }

    public SegmentTreeNode build(int[] A, int start, int end) {
        SegmentTreeNode cur = new SegmentTreeNode(start, end);
        if (start == end) {
            cur.sum = A[start];
        }
        else {
            int mid = start + (end - start) / 2;
            cur.left = build(A, start, mid);
            cur.right = build(A, mid+1, end);
            cur.sum = cur.left.sum + cur.right.sum;
        }
        return cur;
    }

    public Long query(SegmentTreeNode cur, int start, int end) {
        if (cur.start==start && cur.end==end) return cur.sum;
        int mid = (cur.start + cur.end) / 2;
        if (end <= mid) {
	    return query(cur.left, start, end);
	} else if (start > mid) {
	    return query(cur.right, start, end);
	} else {
	    return query(cur.left, start, mid) + query(cur.right, mid+1, end);
	}
    }
}
