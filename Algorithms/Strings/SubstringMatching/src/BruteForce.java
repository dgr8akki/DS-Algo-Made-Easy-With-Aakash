public class BruteForce {
  public int contains(String actual, String pattern) {
    int actualStringSize = actual.length();
    int patternStringSize = pattern.length();
    if(patternStringSize > actualStringSize) return -1;
    for(int i = 0; i < actualStringSize - patternStringSize; i++){
      int j;
      for (j = 0; j < patternStringSize; j++)
        if(actual.charAt(i + j) != pattern.charAt(j))
          break;
      if(j == patternStringSize) return i;
    }
    return -1;
  }
}
