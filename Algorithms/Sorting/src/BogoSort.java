import java.util.Random;

public class BogoSort extends Sorter {

  BogoSort(int[] arr) {
    super(arr);
  }

  @Override
  public void sort() {
    int counter = 0;
    while (!isSorted(this.getArr())) {
      counter++;
      shuffle(this.getArr());
    }

    System.out.println("No of steps: " + counter);
    printResult();
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private boolean isSorted(int[] arr) {
    int lastElement = Integer.MIN_VALUE;
    for (int element : arr)
      if (element > lastElement) {
        lastElement = element;
      } else return false;
    return true;
  }

  private static Random rand = new Random();

  private static int getRandom(int floor, int ceiling) {
    return rand.nextInt((ceiling - floor) + 1) + floor;
  }

  private void shuffle(int[] theArray) {
    if(theArray.length <= 1) return;
    for(int indexWeAreLookingFor = 0; indexWeAreLookingFor <= theArray.length - 1; indexWeAreLookingFor++) {
      int randomIndex = getRandom(indexWeAreLookingFor, theArray.length - 1);
      if(randomIndex != indexWeAreLookingFor) {
        swap(theArray, randomIndex, indexWeAreLookingFor);
      }
    }
  }
}
