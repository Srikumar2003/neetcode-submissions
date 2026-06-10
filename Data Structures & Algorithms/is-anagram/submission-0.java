class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }

        char[] Ssort = s.toCharArray();
        char[] Tsort = t.toCharArray();

        Arrays.sort(Ssort);
        Arrays.sort(Tsort);

        return Arrays.equals(Ssort,Tsort);
    }
}
