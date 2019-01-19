public class DuplicateInArray {

  public static int duplicate(int[] arr) {
    int n = arr.length;
    int sum = 0;
    int sumOfFirstNNaturalNumbers = ((n - 2) * (n - 1)) / 2;
    for (int el : arr)
      sum += el;

    return sum - sumOfFirstNNaturalNumbers;
  }
}
