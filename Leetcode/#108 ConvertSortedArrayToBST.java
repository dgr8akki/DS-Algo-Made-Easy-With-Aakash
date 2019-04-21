class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
    if (left > right)
      return null;
    int mid = (left + right) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    if (left == right)
      return node;
    node.left = sortedArrayToBST(nums, left, mid - 1);
    node.right = sortedArrayToBST(nums, mid + 1, right);
    return node;
  }
}
