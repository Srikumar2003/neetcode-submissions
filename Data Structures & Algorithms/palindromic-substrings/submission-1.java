class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            res += countPal(s, i, i);
            res += countPal(s, i, i+1); 
        }

        return res;
    }

    public int countPal(String p, int l, int r){
        int res = 0;
        while(l >= 0 && r < p.length() && p.charAt(l) == p.charAt(r)){
            l--;
            r++;
            res++;
        }
        return res;
    }
}