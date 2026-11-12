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
        //put the root in the queue, and do a bfs. 
        //put the root
        //invert the tree, 
        // the nodes and continue
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root);
        while(!q.isEmpty() ){
            TreeNode node = q.remove();
            if( node.left != null) q.add(node.left); 
            
            if(node.right != null) q.add(node.right);
            TreeNode temp = node.left; 
            node.left = node.right; 
            node.right = temp; 
            
        }
        return root; 

    }
}
