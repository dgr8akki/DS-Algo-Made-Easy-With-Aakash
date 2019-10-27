package Leetcode;

class Solution_118_PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    if (numRows == 0)
      return res;
    List<Integer> row = new ArrayList<>();
    row.add(1);
    res.add(row);
    for (int i = 2; i <= numRows; i++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i - 1)
          temp.add(1);
        else {
          List<Integer> prev = res.get(i - 2);
          temp.add(prev.get(j - 1) + prev.get(j));
        }
      }
      res.add(temp);
    }
    return res;
  }
}
