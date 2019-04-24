class Solution {
  public int repeatedStringMatch(String A, String B) {
    if (A == null || B == null)
      return -1;
    StringBuilder builder = new StringBuilder();
    int count = 0;
    while (builder.length() < B.length()) {
      builder.append(A);
      count++;
    }

    if (builder.toString().contains(B))
      return count;
    if (builder.append(A).toString().contains(B))
      return count + 1;
    return -1;
  }
}
