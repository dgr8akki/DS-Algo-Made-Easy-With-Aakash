class Solution {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    boolean result = false;
    if (s != null && t != null) {
      result = isSame(s, t);
      if (!result)
        result = isSubtree(s.left, t);
      if (!result)
        result = isSubtree(s.right, t);
    }
    return result;
  }

  public boolean isSame(TreeNode s, TreeNode t) {
    if (null == t && null == s)
      return true;
    if (null == t || null == s)
      return false;
    if (s.val != t.val)
      return false;
    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }
}
