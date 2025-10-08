/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladornequi;

/**
 *
 * @author USUARIO
 */
// Subclase Banco Caja Social
public class BancoCajaSocial extends Banco {
    private double limitDiario;
    private double retiHoy;

    public BancoCajaSocial(double saldo, double limiteDiario) {
        super(saldo);
        this.limitDiario = limiteDiario;
        this.retiHoy = 0;
    }

    
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("❌ El monto debe ser mayor a 0.");
        } else if (monto > saldo) {
            System.out.println("❌ Saldo insuficiente en Daviplata.");
        } else {
            saldo -= monto;
            DispensadorEfectivo dispensador = new DispensadorEfectivo();
            dispensador.dispensar(monto);
            System.out.println("✅ Retiro exitoso en Daviplata: $" + monto);
        }
    }



    @Override
    public void consignar(double monto) {
        saldo += monto;
        System.out.println("Consignación en Caja Social: $" + monto);
    }

    @Override
    public void mostrarSaldo() {
        System.out.println("Saldo Caja Social: $" + saldo);
    }
}