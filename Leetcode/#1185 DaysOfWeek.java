class Solution {
  public String dayOfTheWeek(int day, int month, int year) {
    String[] daysInWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    int[] DaysByMonthMod7 = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
    if (month < 3)
      year -= 1;
    return daysInWeek[(year + (year / 4 - year / 100 + year / 400) + DaysByMonthMod7[month - 1] + day) % 7];
  }
}
