class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int dfs(String s, int i){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(map.containsKey(i)){
            return map.get(i);
        }

        int res = dfs(s, i + 1);
        map.put(i, res);

        if(i < s.length() - 1){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')){
                res +=  dfs(s, i+2);
            }
        }

        map.put(i, res);
        return res;
    }
    public int numDecodings(String s) {
        return dfs(s,0);
    }
}
