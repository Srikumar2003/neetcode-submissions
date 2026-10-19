class Solution {
    private int[] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int [n];
        Arrays.fill(memo, -1);
        
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, dfs(i, nums));
        }
        return res;
    }

    public int dfs(int i, int[] nums){
        if(i == nums.length) return 0;
        if(memo[i] != -1) return memo[i];

        int res = 1;

        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] < nums[j]){
                res = Math.max(res, 1 + dfs(j, nums));
            }
        }

        memo[i] = res;
        return res;
    }
}
