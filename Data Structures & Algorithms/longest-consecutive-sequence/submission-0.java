class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> store = new HashSet<>();

        for(int num : nums){
            store.add(num);
        }

        for(int num : nums){
            int curr = num, streak = 0;
            while(store.contains(curr)){
                curr++;
                streak++;
            }
            res = Math.max(res, streak);
        }
        return res;
    }
}
