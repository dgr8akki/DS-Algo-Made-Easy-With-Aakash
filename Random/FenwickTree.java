public class FenwickTree {
  public void updateTree(int BITree[], int valueToBeUpdated, int index) {
    while (index < BITree.length) {
      BITree[index] += valueToBeUpdated;
      index = getNextIndex(index);
    }
  }

  public int getSumFromZeroToIndex(int BITree[], int index) {
    index = index + 1;
    int sum = 0;

    while(index > 0) {
      sum += BITree[index];
      index = getParentIndex(index);
    }

    return sum;
  }

  public int getSumBetweenGivenRange(int BITree[], int startingIndex, int endIndex) {
    if(startingIndex == 0) return getSumFromZeroToIndex(BITree, endIndex);
    return getSumFromZeroToIndex(BITree, endIndex)
        - getSumFromZeroToIndex(BITree, startingIndex - 1);
  }

  public int[] createFenwickTree (int arr[]) {
    int BITree[] = new int[arr.length + 1];

    for(int i = 1; i <= arr.length; i++)
      updateTree(BITree, arr[i - 1], i);

    return BITree;
  }

  private int getNextIndex (int currentIndex) {
    return currentIndex + (currentIndex & -currentIndex);
  }

  private int getParentIndex (int currentIndex) {
    return currentIndex - (currentIndex & -currentIndex);
  }

  public static void main(String args[]) {
    int input[] = { 1, 2, 3, 4, 5, 6, 7 };
    FenwickTree ft = new FenwickTree();
    int binaryITree[] = ft.createFenwickTree(input);
    System.out.println(ft.getSumFromZeroToIndex(binaryITree, 2));
    System.out.println(ft.getSumFromZeroToIndex(binaryITree, 3));
    System.out.println(ft.getSumBetweenGivenRange(binaryITree, 2, 3));
  }
}
