package Algorithms.DataCompression.RunLengthEncoding.src;

public class Main {
  public static void main(String[] args) {
    String text = "AAAAAAAAABBBBBBCCCCCCCDDDDDDDdaaaaaaaa";
    RLE rle = new RLE(text);
    System.out.println("Actual String:");
    System.out.println(rle.getText());
    System.out.println("Encoded String:");
    System.out.println(rle.encode());
    System.out.println("Decoded String:");
    String decodedString = rle.decode();
    System.out.println(decodedString);
    System.out.println("Is there any loss after decoded?");
    System.out.println(decodedString.equals(text) ? "No" : "Yes");
  }
}
