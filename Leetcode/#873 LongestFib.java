class Solution {
  public int lenLongestFibSubseq(int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int num : A)
      set.add(num);
    int maxLength = 2;
    for (int i = 0; i < A.length; i++)
      for (int j = i + 1; j < A.length; j++) {
        int prev = A[i], current = A[j], next = prev + current, currentLength = 2;
        while (set.contains(next)) {
          prev = current;
          current = next;
          next = prev + current;
          currentLength++;
        }
        maxLength = Math.max(maxLength, currentLength);
      }
    return maxLength > 2 ? maxLength : 0;
  }
}
