import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
  private int[] calculateZ(char input[]) {
    int Z[] = new int[input.length];
    int left = 0;
    int right = 0;
    for (int k = 1; k < input.length; k++) {
      if (k > right) {
        left = right = k;
        while (right < input.length && input[right] == input[right - left]) {
          right++;
        }
        Z[k] = right - left;
        right--;
      } else {
        int k1 = k - left;
        if (Z[k1] < right - k + 1) {
          Z[k] = Z[k1];
        } else {
          left = k;
          while (right < input.length && input[right] == input[right - left]) {
            right++;
          }
          Z[k] = right - left;
          right--;
        }
      }
    }
    return Z;
  }

  public List<Integer> matchPattern(char text[], char pattern[]) {
    char newString[] = new char[text.length + pattern.length + 1];
    int i = 0;
    for (char ch : pattern) {
      newString[i] = ch;
      i++;
    }
    newString[i] = '$';
    i++;
    for (char ch : text) {
      newString[i] = ch;
      i++;
    }
    List<Integer> result = new ArrayList<>();
    int Z[] = calculateZ(newString);

    for (i = 0; i < Z.length; i++) {
      if (Z[i] == pattern.length) {
        result.add(i - pattern.length - 1);
      }
    }
    return result;
  }

  public static void main(String args[]) {
    String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
    String pattern = "aaabc";
    ZAlgorithm zAlgorithm = new ZAlgorithm();
    List<Integer> result = zAlgorithm.matchPattern(text.toCharArray(), pattern.toCharArray());
    result.forEach(System.out::println);
  }
}
