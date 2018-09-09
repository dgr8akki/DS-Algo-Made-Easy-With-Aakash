import java.util.*;

class Solution {
  static void addAtFront(int arr[], int start, int end) {
    int[] temp;
    if( start == end) {
      temp = new int[1];
      temp[0] = arr[start - 1];
    } else {
      temp = new int[end - start - 1];
      temp = Arrays.copyOfRange(arr, start - 1, end);
    }
    int i = start - 2;
    int j = end - 1;
    while(i >= 0) {
      arr[j] = arr[i];
      i--; j--;
    }
    for(int index = 0; index < temp.length; index++) {
      arr[i+1] = temp[index];
      i++;
    }
  }
  static void addAtEnd(int arr[], int start, int end) {
    int[] temp;
    if( start == end) {
      temp = new int[1];
      temp[0] = arr[start - 1];
    } else {
      temp = new int[end - start - 1];
      temp = Arrays.copyOfRange(arr,start - 1,end);
    }
  int i = start - 1;
    int j = end;
    while(j < arr.length) {
      arr[i] = arr[j];
      i++; j++;
    }
    for(int index = 0; index < temp.length; index++) {
      arr[i] = temp[index];
      i++;
    }
  }

  static void solveIt(int[] arr, int queryType, int start, int end) {
      if (queryType == 1) {
        addAtFront(arr, start, end);
      } else {
        addAtEnd(arr, start, end);
      }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int q = sc.nextInt();

    int arr[] = new int[n];

    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for(int j = 1; j <= q; j++) {
      int queryType = sc.nextInt();
      int start = sc.nextInt();
      int end = sc.nextInt();
      solveIt(arr, queryType, start, end);
    }
    System.out.println(Math.abs(arr[0] - arr[n - 1]));
    for (int el : arr) {
      System.out.print(el + " ");
    }
  }
}
