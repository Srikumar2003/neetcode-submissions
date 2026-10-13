class Solution {
    Map<Integer, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> word = new HashSet<>(wordDict);
        map = new HashMap<>();
        map.put(s.length(), true);
        return dfs(s, word, 0);
    }

    public boolean dfs(String s, HashSet<String> word, int i){
        if(map.containsKey(i)){
            return map.get(i);
        }
        for(int j = i; j < s.length(); j++){
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
