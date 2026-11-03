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
    List<Integer> ans;
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ans = new ArrayList<>();
        bfs(root);
        return ans;
    }

    public void bfs(TreeNode node) {
        if(node == null) return;
        bfs(node.left);
        bfs(node.right);
        ans.add(node.val);
    }
}