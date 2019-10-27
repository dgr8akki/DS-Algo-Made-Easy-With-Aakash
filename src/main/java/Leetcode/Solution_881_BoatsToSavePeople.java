package Leetcode;

class Solution_881_BoatsToSavePeople {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int i, j;
    for (i = 0, j = people.length - 1; i <= j; --j)
      if (people[i] + people[j] <= limit)
        ++i;
    return people.length - 1 - j;
  }
}
