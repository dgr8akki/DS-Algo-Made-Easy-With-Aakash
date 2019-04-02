class Solution {
    public static String addBinary(String a, String b) {
        int an = Integer.parseInt(a, 2);
        int bn = Integer.parseInt(b, 2);
        return Integer.toBinaryString(an + bn);
    }

    public static void main(String[] args) {
      String a = "11";
      String b = "1";
      System.out.println(addBinary(a, b));
    }
}