import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * PerimeterWithConditions
 */
public class PerimeterWithConditions {
  public static class LongestSideComparator implements Comparator<Integer[]> {
    public int compare(Integer[] s1, Integer[] s2) {
        return s2[0].compareTo(s1[0]);
    }
}

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int longestSide = Integer.MIN_VALUE;
    int smallestSide = Integer.MAX_VALUE;
    int n = in.nextInt();
    List<Integer> sides = new ArrayList<>();
    for(int i = 0; i < n; i++)
      sides.add(in.nextInt());
    in.close();
    Collections.sort(sides, Collections.reverseOrder());
    SortedSet<Integer[]> triangle = new TreeSet<>(new LongestSideComparator());
    int maxPerimeter = Integer.MIN_VALUE;
    for(int i = 2; i < n; i++) {
      int sideA = sides.get(i - 2);
      int sideB = sides.get(i - 1);
      int sideC = sides.get(i);
      if(sideA < sideB + sideC) {
        int perimeter = sideA + sideB + sideC;
        if(perimeter == maxPerimeter) {
          triangle.add(new Integer[] {sideA, sideB, sideC});
          longestSide = Math.max(longestSide, sideA);
          smallestSide = Math.min(smallestSide, sideC);
        } else if (perimeter > maxPerimeter) {
          maxPerimeter = perimeter;
          triangle.clear();
          triangle.add(new Integer[] {sideA, sideB, sideC});
          longestSide = sideA;
          smallestSide = sideC;
        }
      }
    }

    if(triangle.isEmpty()) {
      System.out.println("-1");
      return;
    } else if (triangle.size() == 1) {
      for (Integer[] arr : triangle)
        System.out.println(arr[2] + " " + arr[1] + " " + arr[0]);
      return;
    }

    // Triangle set is having more traingles with same perimeter
    for (Integer[] arr : triangle) {
      if(arr[0] == longestSide && arr[2] == smallestSide) {
        System.out.println(arr[2] + " " + arr[1] + " " + arr[0]);
        return;
      }
    }
  }
}
