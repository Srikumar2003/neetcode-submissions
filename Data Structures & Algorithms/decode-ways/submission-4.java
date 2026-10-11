class Solution {
    public int numDecodings(String s) {
        int dp1 = 1, dp2 = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int dp = 0;
            if(s.charAt(i) == '0'){
                dp = 0;
            }
            else{
                dp = dp1;
                if(i < s.length() - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
                    dp += dp2; 
                }
            }
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
