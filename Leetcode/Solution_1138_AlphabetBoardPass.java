class Solution_1138_AlphabetBoardPass {
  public String alphabetBoardPath(String target) {
    StringBuilder sb = new StringBuilder();
    int prevX = 0, prevY = 0;
    for (int j = 0; j < target.length(); j++) {
      int curx = (target.charAt(j) - 'a') / 5, cury = (target.charAt(j) - 'a') % 5;
      while (prevX > curx) {
        prevX--;
        sb.append('U');
      }
      while (prevY < cury) {
        prevY++;
        sb.append('R');
      }
      while (prevY > cury) {
        prevY--;
        sb.append('L');
      }
      while (prevX < curx) {
        prevX++;
        sb.append('D');
      }
      sb.append('!');
    }
    return sb.toString();
  }
}
