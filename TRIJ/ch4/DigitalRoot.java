package com.trijs.ch4;

public class DigitalRoot {
  private DigitSum digitSum = new DigitSum();

  public int digitalRoot(int number) {
    int sum = digitSum.solve(number);
    if(sum > 10)
      return digitalRoot(sum);
    return sum;
  }

  public static void main(String[] args) {
    DigitalRoot digitSum = new DigitalRoot();
    System.out.println(digitSum.digitalRoot(49998));
  }
}
