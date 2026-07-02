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

class Solution {
    List<Integer> inorder =  new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for(int i = 1; i < inorder.size(); i++){
            if(inorder.get(i) <= inorder.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);

        inorder.add(root.val);

        dfs(root.right);
    }
}
