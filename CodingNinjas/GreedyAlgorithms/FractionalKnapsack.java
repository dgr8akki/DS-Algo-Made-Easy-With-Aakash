import java.util.Scanner;
import java.util.*;

public class FractionalKnapsack {

  static class Painter implements Comparable<Painter> {
    int time;
    int cost;
    int speed;

    Painter(int time, int cost, int speed) {
      this.time = time;
      this.cost = cost;
      this.speed = speed;
    }

    @Override
    public int compareTo(Painter other) {
      if(this.time == other.time) {
        if(this.speed == other.speed) {
          return Integer.compare(this.cost, other.cost);
        } else {
          return Integer.compare(other.speed, this.speed);
        }
      }
      return Integer.compare(this.time, other.time);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long area = in.nextLong();
    List<Painter> painters = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      int x = in.nextInt();
      int y = in.nextInt();
      painters.add(new Painter(t, x, y));
    }
    in.close();
    Collections.sort(painters);
    long areaCovered = 0, cost = 0, bestSpeed = 0, lastTime = painters.get(0).time;
    for(int i = 0; i < n; i++) {
      long currentPainterTime = painters.get(i).time;
      areaCovered += (bestSpeed * (currentPainterTime - lastTime));
      if(areaCovered >= area) break;
      if(painters.get(i).speed > bestSpeed) {
        bestSpeed = painters.get(i).speed;
        cost += painters.get(i).cost;
      }
      lastTime = currentPainterTime;
    }
    System.out.println(cost);
  }

}