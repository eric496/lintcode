/*
Given a non-overlapping interval list which is sorted by start point.
Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

Example
    Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].
    Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
*/

/*
Thought process
    There are 3 cases: 
        1) new interval is strictly greater than the current interval (newInterval.start > i.end)
        2) new interval is strictly smaller than the current interval (newInterval.end < i.start)
        3) new interval is overlapping with the current interval (newInterval.end >= i.start or newInterval.start <= i.end)
    Set a position pointer to keep track of the insert position so we can insert interval outside the for loop.
    Increment position pointer if 1) occurs.
    For case 3), update the new interval start with new interval start or current interval start, whichever is smaller. 
    Similarly, update the new interval end with new interval end or current interval end, whichever is greater.
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) return intervals;
        List<Interval> result = new ArrayList<>();
        int insertPos = 0;
        for (Interval i : intervals) {
            // current interval is strictly smaller than new interval
            // insert current interval to result list and increment insert position index by 1
            if (newInterval.start > i.end) {
                result.add(i);
                insertPos++;
            // current interval is strictly greater than new interval
            // insert current interval to result list but do not change insert position index
            } else if (newInterval.end < i.start) {
                result.add(i);
            // merge interval, take new interval start or current interval start, whichever is smaller,
            // similarly, take new interval end or current interval end, whichever is greater.
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        // insert new interval or merged interval 
        result.add(insertPos, newInterval);
        return result;
    }
}
