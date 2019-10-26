package Leetcode;

class Solution {
  public boolean uniqueOccurrences(int[] arr) {
    int[] temp = new int[2003];
    for (int i : arr)
      temp[i + 1000]++;
    Set<Integer> set = new HashSet<>();
    for (int i : temp)
      if (i == 0)
        continue;
      else if (set.contains(i))
        return false;
      else
        set.add(i);
    return true;
  }
}
