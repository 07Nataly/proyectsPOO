/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladornequi;
import java.util.Scanner;

//partes del cajero
class Teclado {
    private Scanner scanner = new Scanner(System.in);

    public int leerOpcion() {
        return scanner.nextInt();
    }

    public double leerMonto() {
        return scanner.nextDouble();
    }
}



