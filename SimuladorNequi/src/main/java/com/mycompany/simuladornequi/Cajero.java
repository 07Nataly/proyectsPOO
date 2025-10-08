/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladornequi;

import java.util.List;

class Cajero {
    private Pantalla pantalla;
    private Teclado teclado;
    private DispensadorEfectivo dispensador;
    private Usuario usuario;
    private List<Usuario> listaUsuarios;

    public Cajero(Usuario usuario, List<Usuario> listaUsuarios) {
        this.usuario = usuario;
        this.listaUsuarios = listaUsuarios;
        this.pantalla = new Pantalla();
        this.teclado = new Teclado();
        this.dispensador = new DispensadorEfectivo();
    }

    public void iniciar() {
        int opcion = -1;
        while (opcion != 0) {
            pantalla.mostrarMensaje("\n--- Cajero " + usuario.getBanco().getNombre() + " ---");
            pantalla.mostrarMensaje("1. Consultar saldo");
            pantalla.mostrarMensaje("2. Consignar");
            pantalla.mostrarMensaje("3. Retirar");
            pantalla.mostrarMensaje("4. Aplicar intereses");
            pantalla.mostrarMensaje("5. Transferencia");
            pantalla.mostrarMensaje("0. Salir");
            pantalla.mostrarMensaje("Seleccione una opcion: ");
            opcion = teclado.leerOpcion();

            switch (opcion) {
                case 1 -> usuario.getBanco().mostrarSaldo();

                case 2 -> {
                    pantalla.mostrarMensaje("Ingrese monto a consignar: ");
                    double montoConsignar = teclado.leerMonto();
                    usuario.getBanco().consignar(montoConsignar);

                    // Generar factura PDF
                    FacturaPDF.generarFactura(
                        usuario.getNombre(),
                        usuario.getBanco().getNombre(),
                        "Consignación",
                        montoConsignar,
                        usuario.getBanco().getSaldo()
                    );
                }

                case 3 -> {
                    pantalla.mostrarMensaje("Ingrese monto a retirar: ");
                    double montoRetirar = teclado.leerMonto();
                    usuario.getBanco().retirar(montoRetirar);
                   

                    // Generar factura PDF
                    FacturaPDF.generarFactura(
                        usuario.getNombre(),
                        usuario.getBanco().getNombre(),
                        "Retiro",
                        montoRetirar,
                        usuario.getBanco().getSaldo()
                    );
                }

                case 4 -> {
                    if (usuario.getBanco() instanceof Daviplata daviplata) {
                        daviplata.aplicarInteres();
                    } else {
                        pantalla.mostrarMensaje("Este banco no ofrece intereses.");
                    }
                }
                
               case 5 -> {
                    pantalla.mostrarMensaje("¿A qué usuario desea transferir?");

                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        if (!usuario.getNombre().equals(listaUsuarios.get(i).getNombre())) {
                            pantalla.mostrarMensaje((i + 1) + ". " + listaUsuarios.get(i).getNombre());
                        }
                    }

                    int opcionUsuario = teclado.leerOpcion();
                    Usuario usuarioSeleccionado = listaUsuarios.get(opcionUsuario - 1);

                    if (usuarioSeleccionado.getNombre().equals(usuario.getNombre())) {
                        pantalla.mostrarMensaje("No puedes transferirte dinero a ti mismo.");
                        break;
                    }

                    pantalla.mostrarMensaje("Ingrese el monto a transferir:");
                    double monto = teclado.leerMonto();

                    if (monto <= 0) {
                        pantalla.mostrarMensaje("El monto debe ser positivo.");
                        break;
                    }
                    if (monto < 1000) {
                        pantalla.mostrarMensaje("El monto mínimo de transferencia es $1000.");
                        break;
                    }
                    if (monto > usuario.getBanco().getSaldo()) {
                        pantalla.mostrarMensaje("No tienes saldo suficiente para transferir $" + monto);
                        break;
                    }

                    usuario.getBanco().setSaldo(-monto);
                    usuarioSeleccionado.getBanco().setSaldo(monto);

                    pantalla.mostrarMensaje("Transferencia realizada con exito.");
                    pantalla.mostrarMensaje("Tu nuevo saldo es: $" + usuario.getBanco().getSaldo());

                    FacturaPDF.generarFactura(
                        usuario.getNombre(),
                        usuario.getBanco().getNombre(),
                        "Transferencia a " + usuarioSeleccionado.getNombre(),
                        monto,
                        usuario.getBanco().getSaldo()
                    );
                }

                case 0 -> pantalla.mostrarMensaje("Gracias por usar el cajero.");

                default -> pantalla.mostrarMensaje("Opcion invalida.");
            }
        }
    }
}