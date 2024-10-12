package com.jpenagos.conversorMoneda.app;

import com.jpenagos.conversorMoneda.ConverterRequestClass;
import com.jpenagos.conversorMoneda.mathematics.Operations;

import java.util.Scanner;

public class AppBuilderClass {

  Scanner scan;
  Operations operations;
  ConverterRequestClass converterRequestClass;

  public AppBuilderClass(Scanner scan, Operations operations, ConverterRequestClass converterRequestClass) {
    this.scan = scan;
    this.operations = operations;
    this.converterRequestClass = converterRequestClass;
  }

  private int optionMenu(Scanner scan) {
    System.out.println();
    System.out.println("""
      Ingrese La Opción Que Desea Realizar:
      1. Peso Colombiano -> Dolar Estadounidense
      2. Dolar Estadounidense -> Peso Colombiano
      3. Peso Argentino -> Dolar Estadounidense
      4. Dolar Estadounidense -> Peso Argentino
      5. Real Brasileño -> Dolar Estadounidense
      6. Dolar Estadounidense -> Real Brasileño
      7. Salir""");

    return Integer.parseInt(scan.nextLine());
  }

  public void runConverter() {
    boolean exit = false;
    while (!exit) {
      try {
        int option = this.optionMenu(this.scan);
        switch (option) {
          case 1 -> {
            System.out.println("Ingrese la cantidad en pesos Colombianos (COP)");
            double amount = Double.parseDouble(this.scan.nextLine());
            double cop = Double.parseDouble(this.converterRequestClass.getRate().get("COP"));
            double total = this.operations.toUsd(cop, amount);

            System.out.println();
            System.out.printf("$%.2f COP equivalen a $%.2f USD", amount, total);
            System.out.println();
          }
          case 2 -> {
            System.out.println("Ingrese la cantidad en Dolares (USD)");
            double amount = Double.parseDouble(this.scan.nextLine());
            double cop = Double.parseDouble(this.converterRequestClass.getRate().get("COP"));
            double total = this.operations.fromUsd(cop, amount);

            System.out.println();
            System.out.printf("$%.2f USD equivalen a $%.2f COP", amount, total);
            System.out.println();
          }
          case 3 -> {
            System.out.println("Ingrese la cantidad en Pesos Argentinos (ARS)");
            double amount = Double.parseDouble(this.scan.nextLine());
            double ars = Double.parseDouble(this.converterRequestClass.getRate().get("ARS"));
            double total = this.operations.toUsd(ars, amount);

            System.out.println();
            System.out.printf("$%.2f ARS equivalen a $%.2f USD", amount, total);
            System.out.println();
          }
          case 4 -> {
            System.out.println("Ingrese la cantidad en Dolares (USD)");
            double amount = Double.parseDouble(this.scan.nextLine());
            double ars = Double.parseDouble(this.converterRequestClass.getRate().get("ARS"));
            double total = this.operations.fromUsd(ars, amount);

            System.out.println();
            System.out.printf("$%.2f USD equivalen a $%.2f ARS", amount, total);
            System.out.println();
          }
          case 5 -> {
            System.out.println("Ingrese la cantidad en Reales Brasileños (BRL)");
            double amount = Double.parseDouble(this.scan.nextLine());
            double brl = Double.parseDouble(this.converterRequestClass.getRate().get("BRL"));
            double total = this.operations.toUsd(brl, amount);

            System.out.println();
            System.out.printf("$%.2f BRL equivalen a $%.2f USD", amount, total);
            System.out.println();
          }
          case 6 -> {
            System.out.println("Ingrese la cantidad en Dolares (USD)");
            double amount = Double.parseDouble(this.scan.nextLine());
            double brl = Double.parseDouble(this.converterRequestClass.getRate().get("BRL"));
            double total = this.operations.fromUsd(brl, amount);

            System.out.println();
            System.out.printf("$%.2f USD equivalen a $%.2f BRL", amount, total);
            System.out.println();
          }
          case 7 -> {
            System.out.println("***********************************");
            System.out.println("Gracias por usar nuestros servicios");
            System.out.println("***********************************");
            exit = true;
          }
          default -> System.out.println("Opción invalida, Intente nuevamente");
        }
      } catch (NumberFormatException e) {
        System.out.println("Ingrese unicamente números " + e.getMessage());
      }
    }
  }
}
