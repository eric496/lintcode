/*
Given a non-overlapping interval list which is sorted by start point.
Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

Example
Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].
Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
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

/*
Thought process
1. There are 3 cases: 1) new interval is strictly smaller than the current interval (newInterval.end < i.start)
                      2) new interval is strictly greater than the current interval (newInterval.start > i.end)
                      3) new interval is overlapping with the current interval
2. Set a position pointer to keep track of the insertion position so we can insert interval outside the for loop.
   It should increment only when case 2) is true.
   For case 3), update the new interval start with the smaller value of new interval start and the current interval start, 
   similarly, update the new interval end with the greater value of new interval end and the current interval end.
*/

class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null) return intervals;
        ArrayList<Interval> res = new ArrayList<Interval>();
        int pos = 0;
        for(Interval i : intervals) {
            if(newInterval.end < i.start) {
                res.add(i);
            } else if(newInterval.start > i.end) {
                res.add(i);
		pos++;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        res.add(pos, newInterval);
        return res;
    }
}
