package Leetcode;

import java.time.LocalDate;

class Solution_1154_DayOfYear {
  public int dayOfYear(String date) {
    return LocalDate.parse(date).getDayOfYear();
  }
}
