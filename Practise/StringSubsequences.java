import java.util.ArrayList;
import java.util.List;

/**
 * StringSubsequences
 */
public class StringSubsequences {
  public static void subseq(String string) {
    if(string.length() == 0)
      return;
    List<String> list = new ArrayList<>();
    printSubseq(string, list);

    for(String st: list)
      System.out.println(st);
  }
  
  private static void printSubseq(String string, List<String> list) {
    if(string.length() == 0) {
      list.add(0, "");
      return;
    }

    printSubseq(string.substring(1), list);

    int size = list.size();
    for(int i = 0; i < size; i++)
      list.add(string.charAt(0) + list.get(i));
  }

  public static void main(String[] args) {
    subseq("sd");
  }
}