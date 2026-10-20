class Solution {
    private int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] mem : memo){
            Arrays.fill(mem, -1);
        }
        return dfs(text1, text2, 0, 0);
    }

    public int dfs(String text1, String text2, int i, int j){
        if(i == text1.length() || j == text2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            return memo[i][j] = 1 + dfs(text1, text2, i+1, j+1);
        }
        else{
            return memo[i][j] = Math.max(dfs(text1, text2, i+1, j) , dfs(text1, text2, i, j+1));
        }
    }
}
