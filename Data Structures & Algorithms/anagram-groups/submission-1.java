class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] Chararray = s.toCharArray();
            Arrays.sort(Chararray);
            String sortedS = new String (Chararray);
            map.putIfAbsent(sortedS, new ArrayList<>());
            map.get(sortedS).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
