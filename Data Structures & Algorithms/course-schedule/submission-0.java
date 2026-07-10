class Solution {
    private Map <Integer, List<Integer>> map =  new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre :  prerequisites){
            map.get(pre[1]).add(pre[0]);
        }

        for(int c = 0; c <  numCourses; c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int c){
        if(visited.contains(c)){
            return false;
        }

        if(map.get(c).isEmpty()){
            return true;
        }

        visited.add(c);
        for(int pre : map.get(c)){
            if(!dfs(pre)){
                return false;
            }
        }

        visited.remove(c);
        map.put(c, new ArrayList<>());
        return true;
    }
}
