class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, target, cur, 0);
        return res;
    }

    public void dfs(int[] num, int tar, List<Integer> curr, int i){
        if(tar == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(tar < 0 || i >= num.length) return;

        curr.add(num[i]);

        dfs(num, tar - num[i], curr, i);

        curr.remove(curr.size() - 1);

        dfs(num, tar, curr, i + 1);
    }
}
