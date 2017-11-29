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

Challenge
    O(n log n) time and O(1) extra space.
*/

/*
Thought process
    Sort the interval list by interval start values.
    Two pointers: Compare the current interval with the previous interval.
		  If current start value is smaller than the previous end value (overlapping occurs), compare the previous end value with the current end value, store the greater one.
                  If current start value is greater than the end value, add the previous interval to the result list and update the previous start and end value with the current ones.
    DO NOT forget to add the last interval to the result list.
*/

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        /*
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        */
        List<Interval> result = new LinkedList<>();
        int prevStart = intervals.get(0).start;
        int prevEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval curInterval = intervals.get(i);
            if (curInterval.start <= prevEnd) {
                prevEnd = Math.max(curInterval.end, prevEnd);
            } else {
                result.add(new Interval(prevStart, prevEnd));
                prevStart = curInterval.start;
                prevEnd = curInterval.end;
            }
        }
        // add the last interval
        result.add(new Interval(prevStart, prevEnd));
        return result;
    }
}
