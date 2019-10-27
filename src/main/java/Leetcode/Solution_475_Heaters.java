package Leetcode;

public class Solution_475_Heaters {
  public int findRadius(int[] houses, int[] heaters) {
      Arrays.sort(heaters);
      int result = Integer.MIN_VALUE;
      for (int house : houses) {
          int index = Arrays.binarySearch(heaters, house);
          if (index < 0)
            index = -(index + 1);
          int houseToLeftHeater = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
          int houseToRightHeater = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
          result = Math.max(result, Math.min(houseToLeftHeater, houseToRightHeater));
      }
      return result;
  }
}
