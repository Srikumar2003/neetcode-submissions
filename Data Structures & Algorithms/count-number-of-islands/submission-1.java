class Solution {
    private int[][]directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int Rows, Cols;
    public int numIslands(char[][] grid) {
        int island = 0;
        Rows = grid.length; Cols = grid[0].length;

        for(int r = 0; r < Rows; r++){
            for(int c = 0; c < Cols; c++){
                if(grid[r][c] == '1'){
                    dfs(r, c, grid);
                    island++;
                }
            }
        }
        return island;
    }

    public void dfs(int r, int c, char[][] grid){
        if(r < 0 || c < 0 || r >= Rows || c >= Cols || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        for(int[] dir : directions){
            dfs(r + dir[0], c + dir[1], grid);
        }
    }
}
