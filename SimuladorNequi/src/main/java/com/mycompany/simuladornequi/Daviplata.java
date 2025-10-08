/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladornequi;

/**
 *
 * @author USUARIO
 */
// Subclase Daviplata
public class Daviplata extends Banco {
    private double tasaInteres;

    public Daviplata(double saldo, double tasaInteres) {
        super(saldo);
        this.tasaInteres = tasaInteres;
    }

    public void aplicarInteres() {
        double interes = saldo * tasaInteres;
        saldo += interes;
        System.out.println("Interes aplicado en Daviplata: $" + interes);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
        } else if (monto > saldo) {
            System.out.println("Saldo insuficiente en Daviplata.");
        } else {
            saldo -= monto;
            DispensadorEfectivo dispensador = new DispensadorEfectivo();
            dispensador.dispensar(monto);
            System.out.println("Retiro exitoso en Daviplata: $" + monto);
        }
    }


    @Override
    public void consignar(double monto) {
        saldo += monto;
        System.out.println("Consignación en Daviplata: $" + monto);
    }

    @Override
    public void mostrarSaldo() {
        System.out.println("Saldo Daviplata: $" + saldo);
    }
}
