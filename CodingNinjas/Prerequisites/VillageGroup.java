import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int totalVillages = in.nextInt();
    int[] villagePopulation = new int[totalVillages];
    for (int i = 0; i < totalVillages; i++)
      villagePopulation[i] = in.nextInt();

    for (int i = 0; i < totalVillages / 2; i++) {
      int totalMembersInGroup = villagePopulation[i] + villagePopulation[(totalVillages - 1) - i];
      System.out.println(totalMembersInGroup / 10 + " " + totalMembersInGroup % 10);
    }
  }
}
