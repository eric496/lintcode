/*
Given a string of numbers, write a function to find the maximum value from the string, you can add a + or * sign between any two numbers.

Example
    Given str = 01231, return 10
    ((((0 + 1) + 2) * 3) + 1) = 10 we get the maximum value 10
    Given str = 891, return 73
    As 8 * 9 * 1 = 72 and 8 * 9 + 1 = 73 so 73 is maximum.
*/

/*
Thought process:
    Method 1:
        Create a current maximum variable to store the max so far. Iterate the array, the principle to get the global max is 
            1) By adding the current digit to the max so far if the current digit and the max so far are both either 0 or 1 (otherwise, the result will be smaller by multiplication in these cases).
            2) By multiplying the current digit by the max so far if the current digit and the max so far are both greater than 1.
        Notice that there is a corner case that if the first digit is greater than 1, we should add it to the max so far instead of multiplying by the max so far since the initial value of max is set to 0.
    Method 2:
        Iterate the string, if the current number is 0 or 1, addition always yields the best result.
        If the current number is greater than 1, then there are 2 sub cases:
            1) add it to sum if current sum is 0 or 1.
            2) multiply it by sum if current sum is greater than 1.
*/

// method 1
public class Solution {
    public int calcMaxValue(String str) {
        if (str == null || str.length() == 0) return 0;
        int maxSofar = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = (int)(str.charAt(i) - '0');
            if (maxSofar == 0 && digit > 1) {
                maxSofar = digit;
                continue;
            }
            if (maxSofar <= 1 || digit <= 1) {
                maxSofar += digit;
            } else if (maxSofar > 1 && digit > 1) {
                maxSofar *= digit;
            }
        } 
        return maxSofar;
    }
}

// method 2
public class Solution {
    public int calcMaxValue(String str) {
        if (str == null || str.length() == 0) return 0;
        int sum = 0;
        for (char c : str.toCharArray()) {
            int num = (int)(c-'0');
            if (num == 0 || num == 1) {
                sum += num;
            } else if (num > 1) {
                if (sum == 0 || sum == 1) {
                    sum += num;
                } else {
                    sum *= num;
                }
            }
        }
        return sum;
    }
}
