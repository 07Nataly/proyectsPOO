/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladornequi;

//Herencia Banco
public abstract class Banco {

    protected double saldo;

    public double getSaldo() {
        return saldo;
    }
    
    public Banco(double saldo) {
        this.saldo = saldo;
    }

    public abstract void retirar(double monto);
    public abstract void consignar(double monto);
    public abstract void mostrarSaldo();

    public String getNombre() {
        return this.getClass().getSimpleName();
    }
    
    public void setSaldo(double valor) {
        if (this.saldo + valor < 0) {
            System.out.println("Operacion invalida. No puede quedar saldo negativo.");
        } else {
            this.saldo += valor;
        }
    }
}