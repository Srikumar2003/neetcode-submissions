class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        
        int n = nums.length - 1;
        for(int i = 0; i <= n; i++){
            prefix = (prefix == 0 ? 1 : prefix)*nums[i];
            suffix = (suffix == 0 ? 1 : suffix)*nums[n - i];

            res =  Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }
}
