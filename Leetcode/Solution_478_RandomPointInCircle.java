package Leetcode;

class Solution_478_RandomPointInCircle {

  private final double r;
  private final double x;
  private final double y;

  public Solution_478_RandomPointInCircle(double radius, double x_center, double y_center) {
    r = radius;
    x = x_center;
    y = y_center;
  }

  public double[] randPoint() {
    double len = Math.sqrt(Math.random()) * r;
    double deg = Math.random() * 2 * Math.PI;
    return new double[] {len * Math.cos(deg) + x, len * Math.sin(deg) + y};
  }
}
