package Leetcode;

class Solution_1169_InvalidTransactions {
  public List<String> invalidTransactions(String[] transactions) {
    List<String> res = new ArrayList<>();
    String inval = "XXXXXXXXXXXX";
    Map<String, Map<Integer, String>> map = new HashMap<>();
    for (String s : transactions) {
      String[] array = s.split(",");
      String key = array[0];
      if (!map.containsKey(key))
        map.put(key, new HashMap<Integer, String>());
      Map<Integer, String> city = map.get(key);
      int temp = Integer.parseInt(array[1]);
      if (city.containsKey(temp))
        city.put(temp, inval);
      else
        city.put(temp, array[3]);

    }

    for (String s : transactions) {
      String[] array = s.split(",");
      if (Integer.parseInt(s.split(",")[2]) > 1000)
        res.add(s);
      else {
        String key = array[0];
        Map<Integer, String> city = map.get(key);
        int temp = Integer.parseInt(array[1]);
        boolean flag = true;
        for (int i = (temp - 60); i < (temp + 61) && flag; i++) {
          if (i != temp && city.containsKey(i)) {
            if (!city.get(i).equals(array[3])) {
              res.add(s);
              flag = false;
            }
          }
          if (i == temp && city.get(i).equals(inval)) {
            res.add(s);
            flag = false;
          }
        }
      }
    }
    return res;
  }
}
