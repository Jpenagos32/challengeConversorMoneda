package com.jpenagos.conversorMoneda.mathematics;

public class Operations {

  public double toUsd(double rate, double amount) {
    return amount / rate;
  }

  public double fromUsd (double rate, double amount) {
    return amount * rate;
  }
}
