class Solution {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int count = 0;
    double lineADistance = getLineDistance(p1, p2);
    double lineBDistance = getLineDistance(p2, p3);
    double lineCDistance = getLineDistance(p3, p4);
    double lineDDistance = getLineDistance(p1, p4);
    double lineEDistance = getLineDistance(p1, p3);
    double lineFDistance = getLineDistance(p2, p4);

    List<Double> arr = Arrays.asList(lineADistance, lineBDistance, lineCDistance, lineDDistance, lineEDistance,
        lineFDistance);
    Collections.sort(arr);

    for (int i = 1; i < 6; i++) {
      if (arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(0.0))
        count++;
    }

    if (count >= 4)
      return true;

    return false;
  }

  private double getLineDistance(int[] p1, int[] p2) {
    int a = p2[0] - p1[0];
    int b = p2[1] - p1[1];
    return (a * a) + (b * b);
  }
}

class Solution1 {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int count = 0;
    Double d1 = Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2);
    Double d2 = Math.pow((p2[0] - p3[0]), 2) + Math.pow((p2[1] - p3[1]), 2);
    Double d3 = Math.pow((p3[0] - p4[0]), 2) + Math.pow((p3[1] - p4[1]), 2);
    Double d4 = Math.pow((p4[0] - p1[0]), 2) + Math.pow((p4[1] - p1[1]), 2);
    Double d5 = Math.pow((p1[0] - p3[0]), 2) + Math.pow((p1[1] - p3[1]), 2);
    Double d6 = Math.pow((p2[0] - p4[0]), 2) + Math.pow((p2[1] - p4[1]), 2);
    List<Double> arr = Arrays.asList(d1, d2, d3, d4, d5, d6);
    Collections.sort(arr);

    for (int i = 1; i < 6; i++) {
      if (arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(0.0))
        count++;
    }

    if (count >= 4)
      return true;

    return false;

  }
}
