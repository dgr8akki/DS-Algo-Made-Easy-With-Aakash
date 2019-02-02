import java.util.Arrays;
import java.util.Scanner;

public class WeightedJobScheduling {
  static class Job implements Comparable<Job> {
    int start, end, profit;
    Job(int start, int end, int profit) {
      this.start = start;
      this.end = end;
      this.profit = profit;
    }

    @Override
    public int compareTo(Job anotherJob) {
      return Integer.compare(this.end, anotherJob.end);
    }
  }

	public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Job[] jobs = new Job[n];
    for(int i = 0; i < n; i++) {
      int s = in.nextInt();
      int e = in.nextInt();
      int p = in.nextInt();
      jobs[i] = new Job(s,e,p);
    }
    in.close();
    System.out.println(getMaxProfit(jobs, n));
	}

  private static long getMaxProfit(Job[] jobs, int n) {
    Arrays.sort(jobs);
    long[] dp = new long[n];
    dp[0] = jobs[0].profit;
    for(int i = 1; i < n; i++) {
      Job currentJob = jobs[i];
      int lastNonConflictingJobIndex = -1;
      long profitIfIncludingCurrentJob = currentJob.profit;

      int start = 0, end = i - 1;
      while(start <= end) {
        int mid = (start + end) >> 1;
        if(jobs[mid].end <= currentJob.start) {
          lastNonConflictingJobIndex = mid;
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }

      if(lastNonConflictingJobIndex != -1) {
        profitIfIncludingCurrentJob += dp[lastNonConflictingJobIndex];
      }

      dp[i] = Math.max(profitIfIncludingCurrentJob, dp[i - 1]);
    }
    return dp[n - 1];
  }
}
