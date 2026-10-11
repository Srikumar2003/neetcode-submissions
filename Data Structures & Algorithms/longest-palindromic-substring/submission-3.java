class Solution {
    public int[] manachar(String s){
        StringBuilder t = new StringBuilder("#");
        for(char c : s.toCharArray()){
            t.append(c).append("#");
        }

        int n = t.length();
        int[] p = new int[n];

        int l = 0, r = 0;
        for(int i = 0; i < n; i++){
            p[i] = (i < r) ? Math.min(r - i , p[l + (r - i)]) : 0;
            while(i + p[i] + 1 < n && i - p[i] - 1 >= 0 && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)){
                p[i]++;
            }

            if(i + p[i] > r){
                r = i + p[i];
                l = i - p[i];
            }
        }
        return p;
    }
    public String longestPalindrome(String s) {
        int[] p = manachar(s);
        int resLen = 0;
        int center = 0;

        for(int i = 0; i < p.length; i++){
            if(resLen < p[i]){
                resLen = p[i];
                center = i;
            }
        }

        int resIdx = (center - resLen)/2;
        return s.substring(resIdx, resLen + resIdx);
    }
}
