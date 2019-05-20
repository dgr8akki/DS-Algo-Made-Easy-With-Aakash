class Solution {
  public boolean escapeGhosts(int[][] ghosts, int[] target) {
    int max = Math.abs(target[0]) + Math.abs(target[1]);
    for (int[] ghost : ghosts) {
      int d = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
      if (d <= max)
        return false;
    }
    return true;
  }
}
