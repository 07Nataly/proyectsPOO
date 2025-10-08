/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simuladornequi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimuladorNequi {

    public static void main(String[] args) {
        List<Usuario> usuarios = RegistroUsuarios.registrarUsuarios(); // mover lógica a otra clase

        Scanner sc = new Scanner(System.in);
        System.out.println("\nSeleccione usuario para iniciar sesion:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
        }

        int opcionUsuario = sc.nextInt();
        Usuario seleccionado = usuarios.get(opcionUsuario - 1);

        Cajero cajero = new Cajero(seleccionado, usuarios);
        cajero.iniciar();
    }
}