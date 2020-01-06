package CodingNinjas.SearchingAndSortingApplications;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MomosMarket {

  public static void main(String[] args) throws IOException {
    Reader in = new Reader();
    int n = in.nextInt();
    int[] prices = new int[n];
    prices[0] = in.nextInt();
    for (int i = 1; i < n; i++) {
      prices[i] = (prices[i - 1] + in.nextInt());
    }

    int totalDays = in.nextInt();
    while (totalDays-- > 0) {
      int money = in.nextInt();
      long[] result = MomosMarket.solve(prices, money);
      System.out.println(result[0] + " " + result[1]);
    }

    in.close();
  }

  private static long[] solve(int[] prices, int moneySheHave) {
    long[] res = new long[2];
    int temp = Arrays.binarySearch(prices, moneySheHave);
    if (temp < 0) {
      int expectedIndex = -1 * (temp + 1);
      res[0] = expectedIndex;
      if (expectedIndex <= 0) {
        res[1] = moneySheHave;
      } else {
        res[1] = moneySheHave - prices[expectedIndex - 1];
      }
    } else {
      res[0] = temp + 1;
    }
    return res;
  }

  static class Reader {
    private final int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer, bytesRead;

    Reader() {
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
        if (c == '\n') {
          break;
        }
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ') {
        c = read();
      }
      boolean neg = (c == '-');
      if (neg) {
        c = read();
      }
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (neg) {
        return -ret;
      }
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ') {
        c = read();
      }
      boolean neg = (c == '-');
      if (neg) {
        c = read();
      }
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg) {
        return -ret;
      }
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ') {
        c = read();
      }
      boolean neg = (c == '-');
      if (neg) {
        c = read();
      }

      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (c == '.') {
        while ((c = read()) >= '0' && c <= '9') {
          ret += (c - '0') / (div *= 10);
        }
      }

      if (neg) {
        return -ret;
      }
      return ret;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) {
        buffer[0] = -1;
      }
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead) {
        fillBuffer();
      }
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null) {
        return;
      }
      din.close();
    }
  }
}
