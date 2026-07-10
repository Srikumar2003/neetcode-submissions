class Solution {
    public int[][] directions = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int Rows, Cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Rows = heights.length;
        Cols = heights[0].length;

        boolean[][] pac = new boolean[Rows][Cols];
        boolean[][] atl = new boolean[Rows][Cols];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for(int c = 0; c < Cols; c++){
            pacQ.add(new int[]{0, c});
            atlQ.add(new int[]{Rows - 1, c});
        }

        bfs(pac, pacQ, heights);
        bfs(atl, atlQ, heights);

        for(int r = 0; r < Rows; r++){
            pacQ.add(new int[]{r, 0});
            atlQ.add(new int[]{r, Cols - 1});
        }

        bfs(pac, pacQ, heights);
        bfs(atl, atlQ, heights);

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

    public void bfs(boolean[][] ocean, Queue<int[]> q, int[][] heights){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for(int[] dir : directions){
                int nr =  r + dir[0], nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < Rows && nc < Cols && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
