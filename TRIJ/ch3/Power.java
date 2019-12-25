package com.trijs.ch3;

public class Power {
  long pow(int base, int power) {
    if(power == 0) return 1;
    if(base == 0) return 0;
    return base * pow(base, power - 1);
  }

  public static void main(String[] args) {
    Power power = new Power();
    System.out.println(power.pow(2,3));
  }
}