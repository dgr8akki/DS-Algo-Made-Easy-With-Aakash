package CodingNinjas.LanguageToolsAndTimeComplexity;

public class FindUnique {

  public static int findUnique(int[] arr) {
    int unique = arr[0];
    for (int i = 1; i < arr.length; i++) {
      unique ^= arr[i];
    }
    return unique;
  }
}
