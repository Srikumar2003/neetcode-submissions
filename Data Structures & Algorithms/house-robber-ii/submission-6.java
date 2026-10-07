class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);         

        int n =  nums.length;

        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length - 1; i++){
            int temp = prev2;
            prev2 = Math.max(prev2, nums[i] + prev1);
            prev1 = temp;
        }

        int cur1 = nums[1];
        int cur2 = Math.max(nums[1], nums[2]);
        for(int i = 3; i < nums.length; i++){
            int temp = cur2;
            cur2 = Math.max(cur2, nums[i] + cur1);
            cur1 = temp;
        }

        return Math.max(prev2, cur2);
    }
}
