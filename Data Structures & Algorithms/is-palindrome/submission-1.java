class Solution {
    public boolean isPalindrome(String s) {
        int r = s.length() - 1, l = 0;

        while(l < r){
            while(l < r && !alphaNum(s.charAt(l))){
                l++;
            }

            while(r > l && !alphaNum(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean alphaNum(char c) {
        return Character.isLetterOrDigit(c);
    }
}
