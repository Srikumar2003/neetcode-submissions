/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serialdfs(root, sb);
        return sb.toString();
    }

    public void serialdfs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#").append(",");
            return;
        }

        sb.append(root.val).append(",");
        serialdfs(root.left, sb);
        serialdfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = new int[]{0};

        return dfs(vals, i);
    }

    public TreeNode dfs(String[] vals, int[] i){
        if(vals[i[0]].equals("#")) {
            i[0]++;
            return null;
        
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfs(vals, i);
        node.right = dfs(vals, i);

        return node;
    }
}
