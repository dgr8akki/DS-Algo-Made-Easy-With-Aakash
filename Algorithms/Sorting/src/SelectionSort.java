package Algorithms.Sorting.src;

public class SelectionSort extends Sorter {
  SelectionSort(int[] arr) {
    super(arr);
  }

  @Override
  public void sort() {
    for(int i = 0; i < this.getArr().length; i++) {
      int currentIndex = getMinimumElementIndex(this.getArr(), i);
      if(i != currentIndex) swap(this.getArr(), i, currentIndex);
    }

    printResult();
  }

  private int getMinimumElementIndex(int[] arr, int startingIndex) {
    int currentIndex = startingIndex;
    for (int j = startingIndex + 1; j < this.getArr().length; j++)
      if (arr[j] < arr[currentIndex])
        currentIndex = j;
    return currentIndex;
  }
}
