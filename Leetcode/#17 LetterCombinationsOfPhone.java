class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0)
      return new ArrayList<String>();
    String[] map = new String[10];
    List<String> result = new ArrayList<String>();

    map[0] = "";
    map[1] = "";
    map[2] = "abc";
    map[3] = "def";
    map[4] = "ghi";
    map[5] = "jkl";
    map[6] = "mno";
    map[7] = "pqrs";
    map[8] = "tuv";
    map[9] = "wxyz";

    keypad(Integer.parseInt(digits), map, result);

    return result;
  }

  private static void keypad(int n, String[] map, List<String> result) {
    if (n == 0 || n == 1) {
      result.add(0, "");
      return;
    }
    keypad(n / 10, map, result);
    String currentButton = map[n % 10];
    int size = result.size();
    for (int i = 0; i < size; i++) {
      String temp = result.remove(0);
      for (int j = 0; j < currentButton.length(); j++) {
        result.add(temp + currentButton.charAt(j));
      }
    }
  }
}
