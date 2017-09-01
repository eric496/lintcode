/*
Given a collection of intervals, merge all overlapping intervals.

Example
Given intervals => merged intervals:
[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]
*/

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return intervals;
        List<Interval> result = new ArrayList<Interval>();
        // sort with Comparator
        Collections.sort(intervals, new IntervalComparator());
        Interval prev = intervals.get(0);
        for (Interval interval : intervals) {
            if (prev.end < interval.start) {
                result.add(prev);
                prev = interval;
            } else {
                prev.start = Math.min(prev.start, interval.start);
                prev.end = Math.max(prev.end, interval.end);
            }
        }
        result.add(prev);
        return result;
    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
