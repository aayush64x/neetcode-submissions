
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node != null) {
                list.add(node.val);
                q.add(node.left);
                q.add(node.right);
            } else {
                list.add(null);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }

            sb.append(list.get(i) == null ? "null" : list.get(i));
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] list = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(list[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < list.length) {
            TreeNode parent = q.poll();

            // Left child
            if (!list[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(list[i]));
                q.offer(parent.left);
            }
            i++;

            // Right child
            if (i < list.length && !list[i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(list[i]));
                q.offer(parent.right);
            }
            i++;
        }

        return root;
    }
}
