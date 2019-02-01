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
    return 0;
  }

}