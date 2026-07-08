class Solution {
    private int Rows, Cols;
    private int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        Rows = grid.length; Cols = grid[0].length;
        int island = 0;

        for(int r = 0; r < Rows; r++){
            for(int c = 0; c < Cols; c++){
                if(grid[r][c] == '1'){
                    bfs(r, c, grid);
                    island++;
                }
            }
        }
        return island;
    }

    public void bfs(int r, int c, char grid[][]){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r, c});
        grid[r][c] = '0';

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for(int[] dir : directions){
                int nr = row + dir[0], nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < Rows && nc < Cols && grid[nr][nc] == '1'){
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
