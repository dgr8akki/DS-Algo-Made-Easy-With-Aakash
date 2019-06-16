class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] taskCount = new int[26];
    int max = 0;
    int max_count = 0;
    for (char t : tasks) {
      taskCount[t - 'A'] += 1;
      if (taskCount[t - 'A'] == max) {
        max_count++;
      }
      if (taskCount[t - 'A'] > max) {
        max = taskCount[t - 'A'];
        max_count = 1;
      }
    }
    return Math.max((max - 1) * (n + 1) + max_count, tasks.length);
  }
}
