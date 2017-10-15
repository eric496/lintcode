/*
Given a list of numbers with duplicate number in it. Find all unique permutations.

Example
    For numbers [1,2,2] the unique permutations are:
    [
      [1,2,2],
      [2,1,2],
      [2,2,1]
    ]

Challenge
    Using recursion to do it is acceptable. If you can do it without recursion, that would be great!
*/

// recursive 
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}

// iterative
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            Set<String> cache = new HashSet<>();
            while (res.peekFirst().size() == i) {
                List<Integer> l = res.removeFirst();
                for (int j = 0; j <= l.size(); j++) {
                    List<Integer> newL = new ArrayList<>(l.subList(0,j));
                    newL.add(nums[i]);
                    newL.addAll(l.subList(j, l.size()));
                    if (cache.add(newL.toString())) res.add(newL);
                }
            }
        }
        return res;
    }
}
