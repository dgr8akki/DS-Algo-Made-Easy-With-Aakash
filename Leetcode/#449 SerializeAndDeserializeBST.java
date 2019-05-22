public class Codec {

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  public void serialize(TreeNode root, StringBuilder sb) {
    if (root == null)
      return;
    sb.append(root.val).append(",");
    serialize(root.left, sb);
    serialize(root.right, sb);
  }

  public TreeNode deserialize(String data) {
    if (data.isEmpty())
      return null;
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public TreeNode deserialize(Queue<String> q, int lower, int upper) {
    if (q.isEmpty())
      return null;
    String s = q.peek();
    int val = Integer.parseInt(s);
    if (val < lower || val > upper)
      return null;
    q.poll();
    TreeNode root = new TreeNode(val);
    root.left = deserialize(q, lower, val);
    root.right = deserialize(q, val, upper);
    return root;
  }
}
