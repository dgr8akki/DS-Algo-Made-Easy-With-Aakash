import java.util.*;
import java.io.*;

/**
 * MonkAndIslands
 */
public class MonkAndIslands {
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
      System.out.println(solve(adjacencyList, n));
    }
  }

  private static int solve(List<List<Integer>> adjacencyList, int n) {
    int src = 0;
    int dest = n - 1;
    int count = 0;
    Map<Integer, Integer> path = new HashMap<>();
    boolean pathFound = false;
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(src);

    while (!queue.isEmpty()) {
      int current = queue.remove();
      if (current == dest) {
        pathFound = true;
        break;
      }
      visited.add(current);

      for (int neighbor : adjacencyList.get(current)) {
        if (!visited.contains(neighbor)) {
          if (!path.containsKey(neighbor))
            path.put(neighbor, current);
          queue.add(neighbor);
        }
      }
    }
    if (pathFound) {
      count = printPath(path, src, dest);
    } else {
      count = 0;
    }
    return count;
  }

  private static int printPath(Map<Integer, Integer> path, int startNode, int endNode) {
    int count = 0;
    int currentNode = endNode;
    while (currentNode != startNode) {
      count++;
      currentNode = path.get(currentNode);
    }
    return count;
  }
}
