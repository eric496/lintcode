/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Notice
    The solution is guaranteed to be unique.

Example
    Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. The starting gas station's index is 2.

Challenge
    O(n) time and O(1) extra space
*/

/*
Thought process:
    Iterate the gas array, calculate the cumulative remaining gas by sum += gas[i] + cost[i]. Once sum is found smaller than 0, 
    we should set sum to default and keep the current index, based on the fact that if the car starts at A and cannot reach B (but can reach any station before B), 
    then any we cannot reach B starting from any station between A and B.
    This is not that intuitive but we can prove it by contradiction. Suppose the car starts from a station C which is between A and B.
    We assume that the car can reach B, since B is the first station that the car cannot reach starting from A, and C is before B, 
    so the car can reach C. Thus, the car can reach B starting from A via C, which is a contradiction with the fact that the car cannot reach B starting from A.
    This assures that we do not need to check the starting stations between the current starting station and its first unreachable station.   
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;
        int sum = 0, total = 0, index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        return total < 0 ? -1 : index + 1;
    }
}
