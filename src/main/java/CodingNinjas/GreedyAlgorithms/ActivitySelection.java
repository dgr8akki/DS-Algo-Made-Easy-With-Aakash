package CodingNinjas.GreedyAlgorithms;

import java.util.*;

public class ActivitySelection {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    List<Activity> activities = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      int st = in.nextInt();
      int et = in.nextInt();
      activities.add(new Activity(st, et));
    }
    in.close();
    Collections.sort(activities);

    int count = 1;
    int j = 0;
    for (int i = 1; i < n; i++) {
      if (activities.get(i).startTime >= activities.get(j).endTime) {
        count++;
        j = i;
      }
    }

    System.out.println(count);
  }

  private static class Activity implements Comparable<Activity> {
    Integer startTime = 0;
    Integer endTime = 0;

    private Activity(Integer st, Integer et) {
      startTime = st;
      endTime = et;
    }

    @Override
    public int compareTo(Activity o) {
      return this.endTime.compareTo(o.endTime);
    }
  }
}
