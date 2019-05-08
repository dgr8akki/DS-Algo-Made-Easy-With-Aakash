class Solution {
  public List<Integer> partitionLabels(String S) {
    List<Integer> list = new ArrayList<Integer>();

    int maxLen = 0;
    int start = 0;

    for (int i = 0; i < S.length(); i++) {
      if (maxLen < S.lastIndexOf(S.charAt(i))) {
        maxLen = S.lastIndexOf(S.charAt(i));
      }
      if (i == maxLen) {
        list.add(maxLen - start + 1);
        start = maxLen + 1;
      }
    }
    return list;
  }
}
