import java.util.Arrays;

public abstract class Sorter {
  private int[] arr;

  Sorter(int[] arr) {
    this.arr = arr;
  }

  public abstract void sort();

  void printResult() {
    System.out.println(Arrays.toString(this.getArr()));
  }

  int[] getArr() {
    return arr;
  }

  public void setArr(int[] arr) {
    this.arr = arr;
  }

  void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
