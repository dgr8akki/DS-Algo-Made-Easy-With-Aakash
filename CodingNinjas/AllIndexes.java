
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AllIndexes {
	public static int[] allIndexes(int input[], int x) {
		List<Integer> indices = new ArrayList<>();
      	allIndexes(input, indices, x, 0);
      	int[] result = new int[indices.size()];
      	for(int i = 0; i < indices.size(); i++)
          result[i] = indices.get(i);
      	return result;
	}
  private static void allIndexes(int[] input, List<Integer> indices, int x, int index) {
    if(input.length == index)
      return;
    if(input[index] == x)
      indices.add(index);
    allIndexes(input, indices, x, index+1);
  }

  public static void main(String[] args) {
    int[] a = {5, 9, 8, 10, 8, 8};
    int x = 8;

    System.out.println(Arrays.toString(allIndexes(a, x)));
  }
}
