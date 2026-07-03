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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int lsize = Integer.MIN_VALUE;

        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                lsize = i;
                break;
            }
        }

        int[] pleft = Arrays.copyOfRange(preorder, 1, lsize + 1);
        int[] ileft = Arrays.copyOfRange(inorder, 0, lsize);

        root.left = buildTree(pleft, ileft);

        int[] pright = Arrays.copyOfRange(preorder, lsize + 1, preorder.length);
        int[] iright = Arrays.copyOfRange(inorder, lsize + 1, inorder.length);

        root.right = buildTree(pright, iright);

        return root;
    }
}
