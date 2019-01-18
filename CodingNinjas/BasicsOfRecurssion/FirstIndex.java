class Solution {
  public static int firstIndex(int input[], int x) {
    return firstIndex(input, x, 0);
  }

  private static int firstIndex(int input[], int x, int index) {
    if (index == input.length)
      return -1;
    if (input[index] == x)
      return index;
    return firstIndex(input, x, index + 1);
  }
}
