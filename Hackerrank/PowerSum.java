/*
int totnum(int X,int N,int num){
    if(pow(num,N)<X)
        return totnum(X,N,num+1)+totnum(X-pow(num,N),N,num+1);
    else if(pow(num,N)==X)
        return 1;
    else
        return 0;
}

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {
    static int totalNumber(int X, int N, int num) {
      if(Math.pow(num,N) < X)
          return totalNumber(X,N,num+1)+totalNumber(X - (int)Math.pow(num,N),N,num+1);
      else if(Math.pow(num,N)==X)
          return 1;
      else
          return 0;
    }

    static int powerSum(int X, int N) {
      return totalNumber(X, N, 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("random.txt"));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
