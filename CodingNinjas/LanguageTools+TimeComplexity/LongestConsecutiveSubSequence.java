import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class solution {

  public static ArrayList<Integer> longestSubsequence(int[] arr) {
    Map<Integer, Boolean> isVisited = new HashMap<>();
    int currentStart = arr[0], currentLength = 0, globalStartElement = Integer.MIN_VALUE, maxLength = 0;

    // Add all elements in map
    for (int el : arr)
      isVisited.put(el, false);

    for (int i = 0; i < arr.length; i++) {
      currentLength = 1;
      currentStart = arr[i];
      isVisited.put(currentStart, true);
      while (isVisited.containsKey(currentStart + 1) && !isVisited.get(currentStart + 1)) {
        isVisited.put(currentStart + 1, true);
        currentStart++;
        currentLength++;
      }
      currentStart = arr[i];
      while (isVisited.containsKey(currentStart - 1) && !isVisited.get(currentStart - 1)) {
        isVisited.put(currentStart - 1, true);
        currentStart--;
        currentLength++;
      }
      if (maxLength < currentLength) {
        globalStartElement = currentStart;
        maxLength = currentLength;
      } else if (maxLength == currentLength) {
        int globalStartElementIndex = Math.min(search(arr, globalStartElement), search(arr, currentStart));
        globalStartElement = arr[globalStartElementIndex];
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    int temp = globalStartElement;
    while (maxLength-- > 0) {
      result.add(temp);
      temp++;
    }
    return result;
  }

  private static int search(int[] arr, int key) {
    for (int i = 0; i < arr.length; i++)
      if (arr[i] == key)
        return i;
    return -1;
  }
}
