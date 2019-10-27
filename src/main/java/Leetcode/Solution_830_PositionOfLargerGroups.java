package Leetcode;

class Solution_830_PositionOfLargerGroups {
  public List<List<Integer>> largeGroupPositions(String S) {
    S += "0";
    List<List<Integer>> res = new ArrayList<>();
    char last = S.charAt(0);
    int count = 1;
    for (int i = 1; i < S.length(); i++) {
      char current = S.charAt(i);
      if (current == last) {
        count++;
      } else {
        if (count >= 3) {
          List<Integer> temp = new ArrayList<>(2);
          temp.add(i - count);
          temp.add(i - 1);
          res.add(temp);
        }

        count = 1;
        last = current;
      }
    }

    return res;
  }
}
