public class TrieNode {
    TrieNode[] children;
    boolean word;

    public TrieNode(){
        children = new TrieNode[26];
        word = false;
    }
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, TrieNode root, int j){
        TrieNode cur = root;
        
        for(int i = j; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child : cur.children){
                    if(child != null && dfs(word, child , i + 1)){
                        return true;
                    }
                }
                return false;
            }

            else{
                if(cur.children[c - 'a'] == null){
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return cur.word;
    }
}
