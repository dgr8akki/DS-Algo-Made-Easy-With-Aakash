class Solution_1282_GroupPeopleBySize {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> resList = new ArrayList<List<Integer>>();
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    for (int index = 0; index < groupSizes.length; index++) {
      int groupSize = groupSizes[index];
      if (!map.containsKey(groupSize))
        map.put(groupSize, new ArrayList<Integer>());
      map.get(groupSize).add(index);

      if (map.get(groupSize).size() == groupSize) {
        resList.add(map.get(groupSize));
        map.remove(groupSize);
      }
    }
    return resList;
  }
}
