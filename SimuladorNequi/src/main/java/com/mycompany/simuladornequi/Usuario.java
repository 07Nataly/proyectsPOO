/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladornequi;

// Asociación: Usuario tiene una cuenta

public class Usuario {
    private String nombre;
    private Banco banco; // Asociación: cada usuario tiene un banco

    // Constructor
    public Usuario(String nombre, Banco banco) {
        this.nombre = nombre;
        this.banco = banco;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Banco getBanco() {
        return banco;
    }
}