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
    int count = 0;
    int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return answer;
    }

    public void dfs(TreeNode node, int k){
        if(node == null) return;

        dfs(node.left, k);

        count++;
        if(count == k){
            answer = node.val;
        }

        dfs(node.right, k);
    }
}
