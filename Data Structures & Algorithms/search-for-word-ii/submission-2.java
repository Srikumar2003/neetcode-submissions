class Solution {

    class TrieNode{
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();
    private int Rows, Cols;
    public List<String> findWords(char[][] board, String[] words) {
        
        for(String word : words){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                if(cur.child[idx] == null){
                    cur.child[idx] = new TrieNode();
                }
                cur = cur.child[idx];
            }
            cur.word = word;
        }

        List<String> res = new ArrayList<>();
        Rows = board.length;
        Cols = board[0].length;

        for(int r = 0; r < Rows; r++){
            for(int c = 0; c < Cols; c++){
                dfs(board, r, c, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, List<String>res){
        if(r < 0 || c < 0 || r >= Rows || c >= Cols) return;

        char ch =  board[r][c];
        if(ch == '#') return;

        TrieNode next =  node.child[ch - 'a'];

        if(next == null)return;
        
        if(next.word != null){
            res.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';

        dfs(board, r - 1, c, next, res);
        dfs(board, r + 1, c, next, res);
        dfs(board, r, c - 1, next, res);
        dfs(board, r, c + 1, next, res);

        board[r][c] = ch;
    }
}
