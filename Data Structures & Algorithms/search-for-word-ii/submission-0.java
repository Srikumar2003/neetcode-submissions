class TrieNode {
    TrieNode[] children;
    boolean word;

    public TrieNode(){
        children = new TrieNode[26];
        word =  false;
    }
}

class Solution {
    private int Rows, Cols;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        Rows = board.length; Cols = board[0].length;

        for(String word : words){
            boolean flag = false;
            for(int r = 0; r < Rows && !flag; r++){
                for(int c = 0; c < Cols; c++){
                    if(board[r][c] != word.charAt(0)) continue;

                    if(dfs(board, word, r, c, 0)){
                        flag = true;
                        result.add(word);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int i){

        if(i == word.length()) return true;

        if(r < 0 || c < 0 || r >=  Rows || c >= Cols || board[r][c] != word.charAt(i)){
            return false;
        }

        board[r][c] = '*';
        boolean res = dfs(board, word, r - 1, c, i + 1) || dfs(board, word, r + 1, c, i + 1) || dfs(board, word, r, c - 1, i + 1) || dfs(board, word, r, c + 1, i + 1);
        board[r][c] = word.charAt(i);

        return res;
    }
}
