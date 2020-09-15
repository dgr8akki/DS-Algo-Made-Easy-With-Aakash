package Random;

public class EggDropping {
  public int calculateAttempts(int totalEggs, int totalFloors) {
    int[][] attempts = new int[totalEggs + 1][totalFloors + 1];
    for (int i = 0; i <= totalFloors; i++)
      attempts[1][i] = i;

    for (int eggIndex = 2; eggIndex <= totalEggs; eggIndex++) {
      for (int floorIndex = 1; floorIndex <= totalFloors; floorIndex++) {
        attempts[eggIndex][floorIndex] = Integer.MAX_VALUE;
        for (int k = 1; k <= floorIndex; k++)
          attempts[eggIndex][floorIndex] = Math.min(attempts[eggIndex][floorIndex],
              1 + Math.max(attempts[eggIndex - 1][k - 1], attempts[eggIndex][floorIndex - k]));
      }
    }
    return attempts[totalEggs][totalFloors];
  }

  public static void main(String[] args) {
    EggDropping eggDropping = new EggDropping();
    System.out.println("Minimum " + eggDropping.calculateAttempts(2, 100)
        + " attempts needed, if you have 2 eggs and 100 floor building.");
  }
}
