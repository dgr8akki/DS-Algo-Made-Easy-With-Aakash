class Solution {
  public static int lastIndex(int input[], int x) {
    return lastIndex(input, x, input.length - 1);
  }

  private static int lastIndex(int input[], int x, int index) {
    if (index == -1)
      return -1;
    if (input[index] == x)
      return index;
    return lastIndex(input, x, index + -1);
  }
}
