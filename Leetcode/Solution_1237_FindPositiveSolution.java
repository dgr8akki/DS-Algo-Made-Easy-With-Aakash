package main.java.Leetcode;

/**
 * Solution_1237_FindPositiveSolution
 */
public class Solution_1237_FindPositiveSolution {

  public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
    List<List<Integer>> res = new ArrayList<>();
    int x = 1, y = 1000;
    while (x <= 1000 && y > 0) {
      int v = customfunction.f(x, y);
      if (v > z)
        --y;
      else if (v < z)
        ++x;
      else
        res.add(Arrays.asList(x++, y--));
    }
    return res;
  }
}
