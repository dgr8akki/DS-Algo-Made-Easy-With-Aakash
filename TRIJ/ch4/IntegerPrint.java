package com.trijs.ch4;

public class IntegerPrint {
  public void printInteger(int number) {
    if (number < 0)
      number = Math.abs(number);
    for (int i = 1; i <= nDigits(number); i++)
      print(ithDigit(number, i));
  }

  private int nDigits(int number) {
    int temp = number;
    int count = 0;
    while (temp > 0) {
      temp /= 10;
      count++;
    }
    return count;
  }

  private void print(int digit) {
    System.out.println('0' + digit);
  }

  private int ithDigit(int number, int i) {
    return (int) ((number / Math.pow(10, nDigits(number) - i)) % 10);
  }

  public static void main(String[] args) {
    IntegerPrint print = new IntegerPrint();
    print.printInteger(-4018);
  }
}
