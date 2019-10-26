package CodingNinjas.SearchingAndSortingApplications;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
      }
      System.out.println(solve(arr, n));
    }
  }

  private static long solve(int[] A, int n) {
    return mergeSortInversion(A, 0, n - 1);
  }

  private static long mergeSortInversion(int[] A, int start, int end) {
    long count = 0;
    if (start < end) {
      int mid = (start + end) / 2;
      long leftCount = mergeSortInversion(A, start, mid);
      long rightCount = mergeSortInversion(A, mid + 1, end);
      long mergeCount = mergeInversion(A, start, mid, end);
      return leftCount + rightCount + mergeCount;
    }
    return count;
  }

  private static long mergeInversion(int[] A, int start, int mid, int end) {
    int[] temp = new int[(end - start) + 1];
    long inversions = 0;

    int leftRunner = start;
    int rightRunner = mid + 1;
    int mergedRunner = 0;
    int rightLength = end - mid;
    while (leftRunner <= mid && rightRunner <= end) {
      if (A[leftRunner] < A[rightRunner]) {
        temp[mergedRunner] = A[leftRunner];
        inversions += (A[leftRunner] * (rightLength + mid + 1 - rightRunner));
        leftRunner++;
      } else {
        temp[mergedRunner] = A[rightRunner];
        rightRunner++;
      }
      mergedRunner++;
    }
    while (leftRunner <= mid) {
      temp[mergedRunner++] = A[leftRunner++];
    }
    while (rightRunner <= end) {
      temp[mergedRunner++] = A[rightRunner++];
    }

    for (int i = start, k = 0; i <= end; i++, k++) {
      A[i] = temp[k];
    }

    return inversions;
  }
}
