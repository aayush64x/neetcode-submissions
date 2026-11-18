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
class Pair{
    TreeNode node; 
    int max; 
    public Pair(TreeNode node, int max){
        this.node = node; 
        this.max = max; 
    }
    public TreeNode getNode(){
        return node; 
    }
    public int getMax(){
        return max; 
    }

}

class Solution {
    public int goodNodes(TreeNode root) {
        int maxLeft = 0; 
        int maxRight = 0; 

        int count = 1; 

        Queue<Pair> q = new LinkedList<>(); 

        Pair pair= new Pair(root, root.val);
        q.add(pair); 

        while( !q.isEmpty() ){
            Pair p = q.poll(); 
            TreeNode node = p.getNode(); 
            int max = p.getMax(); 
            if(node.left != null){
                if(node.left.val >= max){
                    q.add(new Pair(node.left, node.left.val));
                    count += 1; 
                }
                else{
                    q.add(new Pair(node.left, max));
                }
            }
            if(node.right != null){
                if(node.right.val >= max){
                    q.add(new Pair(node.right, node.right.val));
                    count += 1; 
                }
                else{
                    q.add(new Pair(node.right, max));
                } 
            }  
        }
        return count; 
    }
}

