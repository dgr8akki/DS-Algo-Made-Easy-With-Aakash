import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {

	public static ArrayList<Integer> longestSubsequence(int[] arr) {
		Map<Integer, Boolean> isVisited = new HashMap<>();
      	int currentStart = arr[0], currentLength = 0, currentStartIndex = 0, globalStartElement = Integer.MIN_VALUE, maxLength = 0, globalStartIndex = 0;

      	// Add all elements in map
      	for(int el: arr)
          isVisited.put(el, false);

      	for(int i = 0; i < arr.length; i++) {
          currentLength = 1;
          currentStart = arr[i];
          isVisited.put(currentStart, true);
          while(isVisited.containsKey(currentStart + 1) && !isVisited.get(currentStart + 1)) {
            isVisited.put(currentStart + 1, true);
            currentStart++;
            currentLength++;
          }
          currentStart = arr[i];
          while(isVisited.containsKey(currentStart - 1) && !isVisited.get(currentStart - 1)) {
            isVisited.put(currentStart - 1, true);
            currentStart--;
            currentLength++;
          }
          if(maxLength < currentLength) {
            globalStartElement = currentStart;
            maxLength = currentLength;
          } else if(maxLength == currentLength) {
            int globalStartElementIndex = Math.min(Arrays.binarySearch(arr, globalStartElement), Arrays.binarySearch(arr, currentStart));
            globalStartElement = arr[globalStartElementIndex];
          }
      }
      ArrayList<Integer> result = new ArrayList<>();
      int temp = globalStartElement;
      while(maxLength-- > 0) {
        result.add(temp);
        temp++;
      }
      return result;
	}

  public static void main(String[] args) {
    int[] arr = {15,17, 1, 2, 4, 7, 3, 16, 18};
    ArrayList<Integer> longestSubseq = longestSubsequence(arr);
    for(int el : longestSubseq)
      System.out.println(el);
  }
}
