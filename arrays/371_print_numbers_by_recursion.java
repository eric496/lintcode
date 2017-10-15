/*
Print numbers from 1 to the largest number with N digits by recursion.

Notice
    It's pretty easy to do recursion like:
    recursion(i) {
        if i > largest number:
            return
        results.add(i)
        recursion(i + 1)
    }
however this cost a lot of recursion memory as the recursion depth maybe very large. Can you do it in another way to recursive with at most N depth?

Example
    Given N = 1, return [1,2,3,4,5,6,7,8,9].
    Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].

Challenge
    Do it in recursion, not for-loop.
*/

public class Solution {
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 0) return result;
        dfs(n, result);
        return result;
    }

    private void dfs(int n, List<Integer> result) {
        if(n == 0) return;
        dfs(n - 1, result);
        // current base such as 10, 20, 30...
        int base = (int)Math.pow(10, n-1);
        // get List size before for loop
        int size = result.size();
        for (int i = 1; i < 10; i++) {
            // add 10, 100, 1000...
            result.add(i * base);
            for (int j = 0; j < size; j++)
                // add 11, 12, 13...
                result.add(result.get(j) + base * i);
        }
    }
}
