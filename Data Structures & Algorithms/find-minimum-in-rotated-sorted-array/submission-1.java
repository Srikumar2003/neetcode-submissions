class Solution {
    public int findMin(int[] nums) {
        int left = 0; 
        int right = nums.length - 1; 
        int minNum = Integer.MAX_VALUE;
        while(left < right){
            if(nums[left] < nums[right]){
                return nums[left];
            }
            int mid = left + (right - left)/2;
            minNum = Math.min(minNum, nums[mid]);
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        minNum = Math.min(minNum, nums[left]);
        return minNum;
    }
}
