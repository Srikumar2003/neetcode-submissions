class Solution {
    public int characterReplacement(String s, int k) {
        Set <Character> setChar = new HashSet <>();
        int ans = 0;

        for(char c : s.toCharArray()){
            setChar.add(c);
        }

        for(char c : setChar){
            int count = 0; int l = 0;
            for(int r = 0; r < s.length(); r++){
                if(s.charAt(r) == c){
                    count++;
                }

                while((r - l + 1) - count > k){
                    if(s.charAt(l) == c){
                        count--;
                    }
                    l++;
                }
                
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
