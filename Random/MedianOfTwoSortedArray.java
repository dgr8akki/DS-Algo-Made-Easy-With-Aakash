public class MedianOfTwoSortedArray {

  public double getMedian(int[] array1, int[] array2) {
    int arrayOneSize = array1.length;
    int arrayTwoSize = array2.length;

    if(arrayTwoSize > arrayOneSize) return getMedian(array2, array1);

    int start = 0;
    int end = arrayOneSize;

    while(start <= end) {
      int partitionOfX = (start + end) / 2;
      int partitionOfY = ((arrayOneSize + arrayTwoSize + 1) / 2)  - partitionOfX;
      int maxOfLeftSideOfPartitionOfArrayOne = (partitionOfX == 0) ? Integer.MIN_VALUE : array1[partitionOfX - 1];
      int minOfRightSideOfPartitionOfArrayOne = (partitionOfX == arrayOneSize) ? Integer.MAX_VALUE : array1[partitionOfX];
      int maxOfLeftSideOfPartitionOfArrayTwo = (partitionOfY == 0) ? Integer.MIN_VALUE : array2[partitionOfY - 1];
      int minOfRightSideOfPartitionOfArrayTwo = (partitionOfY == arrayTwoSize) ? Integer.MAX_VALUE
          : array2[partitionOfY];

      if(maxOfLeftSideOfPartitionOfArrayOne <= minOfRightSideOfPartitionOfArrayTwo && maxOfLeftSideOfPartitionOfArrayTwo <= minOfRightSideOfPartitionOfArrayOne) {
        if((arrayOneSize + arrayTwoSize) % 2 == 0) {
          return ((double)Math.max(maxOfLeftSideOfPartitionOfArrayOne, maxOfLeftSideOfPartitionOfArrayTwo) + Math.min(minOfRightSideOfPartitionOfArrayOne, minOfRightSideOfPartitionOfArrayTwo)) / 2;
        }
        return (double) Math.max(maxOfLeftSideOfPartitionOfArrayOne, maxOfLeftSideOfPartitionOfArrayTwo);
      } else if (maxOfLeftSideOfPartitionOfArrayOne > minOfRightSideOfPartitionOfArrayTwo) {
        end = partitionOfX - 1;
      } else
        start = partitionOfX + 1;
    }

    throw new IllegalArgumentException();
  }
  public static void main(String[] args) {
    int[] x = { 1, 3, 8, 9, 15 };
    int[] y = { 7, 11, 19, 21, 18, 25 };

    MedianOfTwoSortedArray mm = new MedianOfTwoSortedArray();
    System.out.print(mm.getMedian(x, y));
  }
}
