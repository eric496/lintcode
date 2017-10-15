/*
Given n and k, return the k-th permutation sequence.

Notice
    n will be between 1 and 9 inclusive.

Example
    For n = 3, all permutations are listed as follows:
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    If k = 4, the fourth permutation is "231"

Challenge
    O(n*k) in time complexity is easy, can you do it in O(n^2) or less?
*/

public class Solution {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i; // factorial
        StringBuilder strBuilder = new StringBuilder();
        for (k--; n > 0; n--) {
            fact /= n;
            strBuilder.append(list.remove(k / fact));
            k %= fact;
        }
        return strBuilder.toString();
    }
}

// O(n) time
public class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();
        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        // create a list of numbers to get indices
        for(int i=1; i<=n; i++) numbers.add(i);
        // numbers = {1, 2, 3, 4}
        k--;
        for(int i = 1; i <= n; i++){
            int index = k / factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n-i];
        }
        
        return String.valueOf(sb);
    }
}
