package com.jpenagos.conversorMoneda;

import com.jpenagos.conversorMoneda.app.AppBuilderClass;
import com.jpenagos.conversorMoneda.mathematics.Operations;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ConverterRequestClass converter = new ConverterRequestClass();
    Operations operations = new Operations();
    Scanner scan = new Scanner(System.in);

    AppBuilderClass appBuilder = new AppBuilderClass(scan, operations, converter);

    appBuilder.runConverter();
  }
}
