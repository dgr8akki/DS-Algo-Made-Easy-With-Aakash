class Solution {
  public int[] sortArray(int[] input) {
    sort(input, 0, input.length - 1);
    return input;
  }

  private void sort(int[] input, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      sort(input, start, mid);
      sort(input, mid + 1, end);
      merge(input, start, mid, end);
    }
  }

  void merge(int arr[], int start, int mid, int end) {
    int sizeOfLeftArray = mid - start + 1;
    int sizeOfRightArray = end - mid;

    int tempLeftArray[] = new int[sizeOfLeftArray];
    int tempRightArray[] = new int[sizeOfRightArray];

    for (int i = 0; i < sizeOfLeftArray; i++)
      tempLeftArray[i] = arr[start + i];
    for (int j = 0; j < sizeOfRightArray; j++)
      tempRightArray[j] = arr[mid + 1 + j];

    int leftArrayIndex = 0, rightArrayIndex = 0, mergedSubArrayIndex = start;
    while (leftArrayIndex < sizeOfLeftArray && rightArrayIndex < sizeOfRightArray) {
      if (tempLeftArray[leftArrayIndex] <= tempRightArray[rightArrayIndex])
        arr[mergedSubArrayIndex++] = tempLeftArray[leftArrayIndex++];
      else
        arr[mergedSubArrayIndex++] = tempRightArray[rightArrayIndex++];
    }

    while (leftArrayIndex < sizeOfLeftArray)
      arr[mergedSubArrayIndex++] = tempLeftArray[leftArrayIndex++];

    while (rightArrayIndex < sizeOfRightArray)
      arr[mergedSubArrayIndex++] = tempRightArray[rightArrayIndex++];
  }
}
