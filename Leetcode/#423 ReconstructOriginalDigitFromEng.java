public class Solution {
  public String originalDigits(String s) {
    if (s == null || s.length() == 0)
      return "";
    int[] count = new int[128];
    for (int i = 0; i < s.length(); i++)
      count[s.charAt(i)]++;
    int[] num = new int[10];
    num[0] = count['z'];
    num[2] = count['w'];
    num[4] = count['u'];
    num[6] = count['x'];
    num[8] = count['g'];
    num[1] = count['o'] - count['z'] - count['w'] - count['u'];
    num[3] = count['h'] - count['g'];
    num[5] = count['v'] - count['s'] + count['x'];
    num[7] = count['s'] - count['x'];
    num[9] = count['i'] - count['x'] - count['g'] - count['v'] + count['s'] - count['x'];
    String ret = new String();
    for (int i = 0; i < 10; i++)
      for (int j = num[i]; j > 0; j--)
        ret += String.valueOf(i);
    return ret;
  }
}
