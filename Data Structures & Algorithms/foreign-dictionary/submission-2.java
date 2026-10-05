class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
                indegree.put(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))){
                return "";
            }

            for(int j = 0; j < minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.getOrDefault(w2.charAt(j), 0)+ 1);
                    }
                    break;
                }
            }         
        }
        Queue<Character> q = new LinkedList<>();

        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0){
                q.add(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while(!q.isEmpty()){
            char ch = q.poll();
            result.append(ch);
            for(char nei : adj.get(ch)){
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0){
                    q.add(nei);
                }
            }
        }

        if(result.length() != indegree.size()){
            return "";
        }

        return result.toString();
        
    }
}
