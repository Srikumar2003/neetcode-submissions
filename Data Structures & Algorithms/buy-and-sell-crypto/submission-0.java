class Solution {
    public int maxProfit(int[] prices) {
        int maxprof = 0;
        int l = 0, r = 1;
        while(r < prices.length){
            if(prices[l] < prices[r]){
                maxprof = Math.max(maxprof, prices[r] - prices[l]);
            }
            else{
                l = r;
            }
            r++;
        }
        return maxprof;
    }
}
