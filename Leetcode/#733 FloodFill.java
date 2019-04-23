class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] != newColor)
      dfs(image, sr, sc, image[sr][sc], newColor);
    return image;
  }

  private void dfs(int[][] image, int currentRow, int currentCol, int oldColor, int newColor) {
    if (currentRow < 0 || currentCol < 0 || currentRow >= image.length || currentCol >= image[0].length
        || image[currentRow][currentCol] != oldColor)
      return;
    image[currentRow][currentCol] = newColor;
    dfs(image, currentRow, currentCol - 1, oldColor, newColor);
    dfs(image, currentRow, currentCol + 1, oldColor, newColor);
    dfs(image, currentRow - 1, currentCol, oldColor, newColor);
    dfs(image, currentRow + 1, currentCol, oldColor, newColor);
  }
}
