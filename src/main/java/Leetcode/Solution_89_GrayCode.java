package Leetcode;

class Solution {
  public List<Integer> grayCode(int n) {
    List<Integer> resultList = new ArrayList<Integer>();
    resultList.add(0);
    for (int i = 0; i < n; i++) {
      int size = resultList.size();
      for (int k = size - 1; k >= 0; k--)
        resultList.add(resultList.get(k) | 1 << i);
    }
    return resultList;
  }
}
