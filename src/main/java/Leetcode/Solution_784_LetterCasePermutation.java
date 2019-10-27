package Leetcode;

class Solution_784_LetterCasePermutation {
  public List<String> letterCasePermutation(String S) {
    List<String> result = new ArrayList<>();
    letterCaseBacktrack(S.toCharArray(), result, 0);
    return result;
  }

  private void letterCaseBacktrack(char[] arr, List<String> result, int index) {
    result.add(String.valueOf(arr));
    for (int i = index; i < arr.length; i++) {
      char current = arr[index];
      if (Character.isDigit(current))
        continue;
      if (Character.isUpperCase(current))
        arr[index] = Character.toLowerCase(current);
      if (Character.isLowerCase(current))
        arr[index] = Character.toUpperCase(current);
      letterCaseBacktrack(arr, result, index + 1);
      arr[index] = current;
    }
  }
}
