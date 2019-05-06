class Solution {
  public static String mostCommonWord(String paragraph, String[] banned) {
    // Reconstruct paragraph
    paragraph = paragraph.toLowerCase();
    StringBuffer removePunctuation = new StringBuffer();
    for (int i = 0; i < paragraph.length(); i++) {
      if (!Character.isAlphabetic(paragraph.charAt(i))) {
        removePunctuation.append(" ");
      }
      if (Character.isAlphabetic(paragraph.charAt(i))) {
        removePunctuation.append(paragraph.charAt(i));
      }
    }

    // Make a set for banned words
    Set<String> bans = new HashSet<String>();
    for (String s : banned) {
      bans.add(s);
    }

    Map<String, Integer> map = new HashMap<String, Integer>();
    List<String> tst = splitString(removePunctuation.toString());
    for (String s : tst) {
      if (!bans.contains(s)) {
        if (map.containsKey(s)) {
          map.put(s, map.get(s) + 1);
        } else {
          map.put(s, 1);
        }
      }
    }

    Set<String> keys = map.keySet();
    int maxCount = Integer.MIN_VALUE;
    String maxVal = "";
    for (String key : keys) {
      int freq = map.get(key);
      if (freq > maxCount) {
        maxCount = freq;
        maxVal = key;
      }
    }
    return maxVal;
  }

  public static List<String> splitString(String paragraph) {
    String[] arr = paragraph.split(" ");
    List<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < arr.length; i++) {
      if (!arr[i].trim().isEmpty()) {
        arrayList.add(arr[i].trim());
      }
    }
    return arrayList;
  }
}
