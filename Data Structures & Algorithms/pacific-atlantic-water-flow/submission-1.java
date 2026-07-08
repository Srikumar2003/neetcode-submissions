class Solution {
    private int[][] directions  = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int Rows, Cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Rows = heights.length;
        Cols =  heights[0].length;
        boolean[][] pac = new boolean[Rows][Cols];
        boolean[][] atl = new boolean[Rows][Cols];
        for(int c = 0; c < Cols; c++){
            dfs(0, c, pac, heights);
            dfs(Rows - 1, c, atl, heights);
        }

        for(int r = 0; r < Rows; r++){
            dfs(r, 0, pac, heights);
            dfs(r, Cols - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < Rows; r++){
            for(int c = 0; c < Cols; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;
        for(int[] dir : directions){
            int nr = r + dir[0], nc = c + dir[1];
            if(nr >= 0 && nc >= 0 && nr < Rows && nc < Cols && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
