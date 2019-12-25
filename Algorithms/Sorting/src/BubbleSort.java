package Algorithms.Sorting.src;

public class BubbleSort extends Sorter {
  BubbleSort(int[] arr) {
    super(arr);
  }

  @Override
  public void sort() {
    for(int i = 0; i < this.getArr().length - 1; i++)
      for(int j = 0; j < this.getArr().length - i - 1; j++)
        if(this.getArr()[j] > this.getArr()[j + 1])
          swap(this.getArr(), j, j + 1);
    printResult();
  }
}
