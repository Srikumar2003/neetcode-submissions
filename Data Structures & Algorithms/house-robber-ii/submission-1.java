class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        int[]cache = new int[n];
        int[]memo = new int[n];

        for(int i = 0; i < n; i++){
            cache[i] = -1;
            memo[i] = -1;
        }

        return Math.max(dfs(nums, 1, cache), dfs1(nums, 0, memo));
        
    }

    public int dfs(int[] nums, int i, int[] cache){
        if(i >= nums.length) return 0;

        if(cache[i] != -1){
            return cache[i];
        }

        return cache[i] = Math.max(dfs(nums, i + 1, cache), nums[i] + dfs(nums, i + 2, cache));
    }

    public int dfs1(int[] nums, int i, int[] memo){
        if(i >= nums.length - 1) return 0;

        if(memo[i] != -1){
            return memo[i];
        }

        return memo[i] = Math.max(dfs1(nums, i + 1, memo), nums[i] + dfs1(nums, i + 2, memo));
    }
}
