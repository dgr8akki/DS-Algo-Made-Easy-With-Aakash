package Leetcode;

class Solution_1013_PartitionArrayIntoThreeParts {
  public boolean canThreePartsEqualSum(int[] A) {
    int sum = 0, count = 0;
    for (int i : A)
      sum += i;
    int thirdSum = (sum / 3);
    if (thirdSum * 3 != sum)
      return false;
    int currentSum = 0;
    for (int i : A) {
      currentSum += i;
      if (currentSum == thirdSum) {
        count++;
        currentSum = 0;

        if (count == 2)
          break;
      }
    }
    return count == 2;
  }
}
