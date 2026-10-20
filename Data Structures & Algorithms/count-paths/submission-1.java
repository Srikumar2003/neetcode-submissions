class Solution {
    private int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];

        for(int[] mem : memo){
            Arrays.fill(mem, -1);
        }
        
        return dfs(0, 0, m, n);
    }

    public int dfs(int i, int j, int m, int n){
        if(i >= m || j >= n) return 0;
        if(i == (m - 1) && j == (n - 1)) return 1;
        if(memo[i][j] != -1) return memo[i][j];

        return memo[i][j] = dfs(i+1, j, m, n) + dfs(i, j + 1, m, n);
    }
}
