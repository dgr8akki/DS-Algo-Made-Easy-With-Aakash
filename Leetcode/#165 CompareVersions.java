class Solution {
  public int compareVersion(String version1, String version2) {

    String[] v1 = version1.split("\\.");
    // System.out.println(Arrays.toString(v1));
    int v1l = v1.length;
    String[] v2 = version2.split("\\.");
    // System.out.println(Arrays.toString(v1));
    int v2l = v2.length;
    for (int i = 0; i < 4; i++) {
      int v1c = i < v1l ? Integer.parseInt(v1[i]) : 0;
      int v2c = i < v2l ? Integer.parseInt(v2[i]) : 0;
      // System.out.println(v1c + " , " + v2c);
      if (v1c == v2c)
        continue;
      if (v1c > v2c)
        return 1;
      if (v1c < v2c)
        return -1;
    }

    return 0;
  }
}
