class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int target, int total, int i, List<Integer> curr){
        if(total == target){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(total + nums[j] > target){
                return;
            }
            curr.add(nums[j]);
            dfs(nums, target, total + nums[j], j, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
