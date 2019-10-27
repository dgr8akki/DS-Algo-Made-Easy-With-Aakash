package Leetcode;

class Solution_636_ExlusionTime {
  public int[] exclusiveTime(int n, List<String> logs) {
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();
    int prev = 0;
    for (String log : logs) {
      String[] strs = log.split(":");
      int id = Integer.parseInt(strs[0]);
      int curr = Integer.parseInt(strs[2]);
      if (strs[1].equals("start")) {
        if (!stack.isEmpty()) {
          res[stack.peek()] += curr - prev;
        }
        stack.push(id);
        prev = curr;
      } else {
        res[stack.pop()] += curr - prev + 1;
        prev = curr + 1;
      }
    }
    return res;
  }
}
