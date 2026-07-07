class TrieNode{
    HashMap <Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word){
        TrieNode cur = this;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}

class Solution {
    Set <String> res;
    private boolean visit[][];
    private int Rows, Cols;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            root.addWord(word);
        }

        Rows = board.length; Cols = board[0].length;
        visit = new boolean[Rows][Cols];
        res = new HashSet<>();

        for(int r = 0; r < Rows; r++){
            for(int c = 0; c < Cols; c++){
                dfs(board, "", r, c, root);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, String word, int r, int c, TrieNode node){
        if(r < 0 || c < 0 || r >= Rows || c >= Cols || visit[r][c] || !node.children.containsKey(board[r][c])){
            return;
        }

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isWord){
            res.add(word);
        }

        dfs(board, word, r - 1, c, node);
        dfs(board, word, r + 1, c, node);
        dfs(board, word, r, c - 1, node);
        dfs(board, word, r, c + 1, node);

        visit[r][c] = false;
    }
}
