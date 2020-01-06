package CodingNinjas.SearchingAndSortingApplications;

class InversionsCount {

  private static long mergeInversion(int[] A, int start, int mid, int end) {

    int[] temp = new int[(end - start) + 1];
    long inversions = 0;

    int leftRunner = start;
    int rightRunner = mid + 1;
    int mergedRunner = 0;
    int leftLength = mid + 1;

    while (leftRunner <= mid && rightRunner <= end) {
      if (A[leftRunner] <= A[rightRunner]) {
        temp[mergedRunner] = A[leftRunner];
        leftRunner++;
      } else {
        temp[mergedRunner] = A[rightRunner];
        inversions += (leftLength - leftRunner);
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

  private static long mergeSortInversion(int[] A, int start, int end) {
    long count = 0;
    if (start < end) {
      int mid = (start + end) / 2;
      long leftCount = InversionsCount.mergeSortInversion(A, start, mid);
      long rightCount = InversionsCount.mergeSortInversion(A, mid + 1, end);
      long mergeCount = InversionsCount.mergeInversion(A, start, mid, end);
      return leftCount + rightCount + mergeCount;
    }
    return count;
  }

  static long solve(int[] A, int n) {
    return InversionsCount.mergeSortInversion(A, 0, n - 1);
  }
}
