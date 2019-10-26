package Leetcode;

import java.time.LocalDate;

class Solution {
  public int dayOfYear(String date) {
    return LocalDate.parse(date).getDayOfYear();
  }
}
