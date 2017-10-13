/*
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

Notice
    If landing and flying happens at the same time, we consider landing should happen at first.

Example
    For interval list
    [
      [1,10],
      [2,3],
      [5,8],
      [4,7]
    ]
    Return 3
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

class Point{
    int time;
    int flag;
    Point(int t, int s){
      this.time = t;
      this.flag = s;
    }
    
    public static Comparator<Point> PointComparator  = new Comparator<Point>(){
      public int compare(Point p1, Point p2){
        if(p1.time == p2.time) return p1.flag - p2.flag;
        else return p1.time - p2.time;
      }
    };
}
  
class Solution {
    public int countOfAirplanes(List<Interval> airplanes) { 
        List<Point> list = new ArrayList<>(airplanes.size()*2);
        for(Interval i : airplanes){
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
    
        Collections.sort(list, Point.PointComparator);
        int count = 0, max = 0;
        for(Point p : list){
            if(p.flag == 1) 
                count++;
            else 
                count--;
            max = Math.max(max, count);
        }
    return max;
    }
}
