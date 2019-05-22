public class Codec {

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  public void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#").append(",");
    } else {
      sb.append(root.val).append(",");
      serialize(root.left, sb);
      serialize(root.right, sb);
    }
  }

  public TreeNode deserialize(String data) {
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserialize(q);
  }

  public TreeNode deserialize(Queue<String> q) {
    String s = q.poll();
    if (s.equals("#"))
      return null;
    TreeNode root = new TreeNode(Integer.parseInt(s));
    root.left = deserialize(q);
    root.right = deserialize(q);
    return root;
  }
}
