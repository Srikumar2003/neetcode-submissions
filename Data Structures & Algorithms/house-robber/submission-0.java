class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            cache[i] =  -1;
        }
        return dfs(nums, 0);
    }

    public int dfs(int[] nums, int i){
        if(i >= nums.length){
            return 0;
        }

        if(cache[i] != -1){
            return cache[i];
        }

        return cache[i] = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
    }
}
