package Algorithms.DataCompression.LZW.src;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    LZW lzw = new LZW();
    List<Integer> compressedString = lzw.compress("DARRARDARDAR");
    System.out.println(compressedString);
    String decompressedString = lzw.decompress(compressedString);
    System.out.println(decompressedString);
  }
}
