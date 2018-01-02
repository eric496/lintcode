/*
Given a matrix, find a element that appear in all the rows in the matrix.You can assume that there is only one such element.

Example
    For example:
    Given a matrix:
    [
      [2,5,3],
      [3,2,1],
      [1,3,5]
    ]
    return 3
*/

// O(mn) time and O(n) space
public class Solution {
    public int FindElements(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> set = new HashSet<>();
            for (int col = 0; col < matrix[0].length; col++) {
                if (!set.contains(matrix[row][col]) && map.containsKey(matrix[row][col])) {
                    map.put(matrix[row][col], map.get(matrix[row][col])+1);
                } else if (!set.contains(matrix[row][col]) && !map.containsKey(matrix[row][col])) {
                    map.put(matrix[row][col], 1);
                }
                set.add(matrix[row][col]);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == matrix.length) return entry.getKey();
        }
        return -1;
    }
}
