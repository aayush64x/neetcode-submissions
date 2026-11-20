
class Solution {
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null || count >= k) {
            return;
        }

        // 1. Visit left subtree
        dfs(root.left, k);

        // 2. Stop if kth element was already found
        if (count >= k) return;

        // 3. Visit current node
        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        // 4. Visit right subtree
        dfs(root.right, k);
    }
}
