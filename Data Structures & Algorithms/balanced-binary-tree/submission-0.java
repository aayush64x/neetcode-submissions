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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int h1 = height(root.left); 
        int h2 = height(root.right); 

        int diff = Math.abs(h1 - h2);
        if (diff > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
        
    } 
    public int height(TreeNode root){
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        int max = 1 + Math.max(left, right); 
        return max;

       
    }
}
