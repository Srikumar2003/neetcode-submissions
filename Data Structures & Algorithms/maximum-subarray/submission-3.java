class Solution {
    public int maxSubArray(int[] nums) {
        int total = 0;
        int res = nums[0];

        for(int n :  nums){
            if(total < 0){
                total = 0;
            }

            total += n;
            res = Math.max(res, total);
        }

        return res;
    }
}
