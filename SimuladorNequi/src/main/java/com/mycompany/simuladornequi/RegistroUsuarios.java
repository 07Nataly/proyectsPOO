/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladornequi;

/**
 *
 * @author USUARIO
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroUsuarios {

    public static List<Usuario> registrarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Cuántos usuarios desea registrar? ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nRegistro de usuario " + (i + 1));

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            // Validación del banco
            int opcionBanco;
            do {
                System.out.println("Seleccione banco:");
                System.out.println("1. Bancolombia");
                System.out.println("2. Daviplata");
                System.out.println("3. Banco Caja Social");
                System.out.print("Opción: ");
                opcionBanco = sc.nextInt();

                if (opcionBanco < 1 || opcionBanco > 3) {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } while (opcionBanco < 1 || opcionBanco > 3);

            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();
            sc.nextLine();

            Banco banco;
            switch (opcionBanco) {
                case 1 -> banco = new Bancolombia(saldo, 2000000); // límite diario ejemplo
                case 2 -> banco = new Daviplata(saldo, 0.02);     // interés ejemplo
                case 3 -> banco = new BancoCajaSocial(saldo, 1000000);
                default -> throw new IllegalStateException("Error inesperado."); 
            }

            usuarios.add(new Usuario(nombre, banco));
        }
        return usuarios;
    }
}