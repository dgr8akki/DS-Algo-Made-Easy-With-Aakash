package Algorithms.Sorting.src;

public class InsertionSort extends Sorter {
  InsertionSort(int[] arr) {
    super(arr);
  }

  @Override
  public void sort() {
    for (int i = 1; i < this.getArr().length; i++) {
      int j = i;
      while (j > 0 && this.getArr()[j - 1] > getArr()[j]) {
        swap(this.getArr(), j, j - 1);
        j--;
      }
    }
    printResult();
  }
}
