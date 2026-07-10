class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indigree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList());
        }

        for(int[] pre : prerequisites){
            indigree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indigree[i] == 0){
                q.add(i);
            }
        }
        int finish = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            finish++;
            for(int pre :  adj.get(node)){
                indigree[pre]--;
                if(indigree[pre] == 0){
                    q.add(pre);
                }
            }
        }
        return finish == numCourses;
    }
}
