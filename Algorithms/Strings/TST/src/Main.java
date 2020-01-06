package Algorithms.Strings.TST.src;

public class Main {
  public static void main(String[] args) {
    TST tst = new TST();
    tst.put("Aakash", 5);
    tst.put("cj", 6);
    tst.put("Aakriti", 9);
    System.out.println(tst.get("cj"));
    System.out.println(tst.get("Aakriti"));
    System.out.println(tst.get("cj2"));
  }
}
