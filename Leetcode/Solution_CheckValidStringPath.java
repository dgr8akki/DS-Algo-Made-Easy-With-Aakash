/**
 * InnerSolution_CheckValidStringPath
 */
public class InnerSolution_CheckValidStringPath {
  public boolean isValidSequence(TreeNode root, int[] arr) {
    if (root == null || arr == null || arr.length == 0)
      return false;
    return isValid(root, arr, 0);
  }

  private boolean isValid(TreeNode root, int[] arr, int index) {
    if (root == null)
      return (arr == null) || (arr.length == 0);
    if (root.left == null && root.right == null && index == arr.length - 1 && root.val == arr[index])
      return true;
    return index < arr.length && root.val == arr[index] && isValid(root.left, arr, index + 1)
        || isValid(root.right, arr, index + 1);
  }
}
