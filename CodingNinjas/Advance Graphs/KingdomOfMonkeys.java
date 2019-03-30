import java.util.*;
import java.io.*;

/**
 * KingdomOfMonkeys
 */
public class KingdomOfMonkeys {
  static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
      byte[] buf = new byte[64]; // line length
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == '\n')
          break;
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (neg)
        return -ret;
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg)
        return -ret;
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();

      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (c == '.') {
        while ((c = read()) >= '0' && c <= '9') {
          ret += (c - '0') / (div *= 10);
        }
      }

      if (neg)
        return -ret;
      return ret;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1)
        buffer[0] = -1;
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead)
        fillBuffer();
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null)
        return;
      din.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Reader in = new Reader();
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      List<List<Integer>> adjacencyList = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        adjacencyList.add(new ArrayList<>());
      }
      while (m-- > 0) {
        int x = in.nextInt();
        int y = in.nextInt();
        adjacencyList.get(x - 1).add(y - 1);
        adjacencyList.get(y - 1).add(x - 1);
      }
      int[] bananas = new int[n];
      for (int i = 0; i < n; i++)
        bananas[i] = in.nextInt();
      System.out.println(solve(adjacencyList, n, bananas));
    }
  }

  private static long solve(List<List<Integer>> adjacencyList, int n, int[] bananas) {
    Set<Set<Integer>> components = new HashSet<>();

    boolean[] isVisited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!isVisited[i]) {
        Set<Integer> component = new HashSet<>();
        // DFS
        dfs(adjacencyList, i, isVisited, component);
        components.add(component);
      }
    }
    long max = Integer.MIN_VALUE;
    long sum = 0;
    for (Set<Integer> comp : components) {
      for (int com : comp)
        sum += bananas[com];
      max = Math.max(max, sum);
      sum = 0;
    }
    return max;
  }

  public static void dfs(List<List<Integer>> adjacencyList, int start, boolean[] isVisited, Set<Integer> component) {
    if (isVisited[start])
      return;

    Stack<Integer> stack = new Stack<>();
    isVisited[start] = true;
    stack.push(start);
    while (stack.size() != 0) {
      int current = stack.pop();
      component.add(current);
      for (int neighbour : adjacencyList.get(current)) {
        if (neighbour == start)
          continue;

        if (!isVisited[neighbour]) {
          isVisited[neighbour] = true;
          stack.push(neighbour);
        }
      }
    }
  }
}
