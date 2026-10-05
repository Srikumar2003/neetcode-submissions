class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        for(int node = 0; node < n; node++){
            if(!visit[node]){
                bfs(adj, visit, node);
                res++;
            }
        }

        return res;
    }

    private void bfs(List<List<Integer>> adj, boolean[] visit, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.get(node)){
                if(!visit[nei]){
                    visit[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
}
