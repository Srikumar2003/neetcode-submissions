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
    public TreeNode invertTree(TreeNode root) {
        return inv(root);
    }

    public TreeNode inv(TreeNode root){
        if(root == null) return null;

        TreeNode newRoot = new TreeNode (root.val);

        newRoot.left = inv(root.right);
        newRoot.right = inv(root.left);

        return newRoot;
    }
}
