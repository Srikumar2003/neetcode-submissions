class Solution {
    Map<Integer, Boolean> map;
    int t;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> word = new HashSet<>(wordDict);
        map = new HashMap<>();
        map.put(s.length(), true);

        t = 0;
        for(String w : wordDict){
            t = Math.max(t, w.length());
        }
        
        return dfs(s, word, 0);
    }

    public boolean dfs(String s, HashSet<String> word, int i){
        if(map.containsKey(i)){
            return map.get(i);
        }
        for(int j = i; j < Math.min(s.length(), i + t); j++){
            if(word.contains(s.substring(i, j + 1))){
                if(dfs(s, word, j + 1)){
                    map.put(i, true);
                    return true;
                }
            }
        }
        map.put(i, false);
        return false;
    }
}
