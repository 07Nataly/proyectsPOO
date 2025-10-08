/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.simuladornequi;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FacturaPDF {

    public static void generarFactura(String usuario, String banco, String operacion, double monto, double saldoFinal) {
        try {
            // Nombre dinámico del archivo
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String nombreArchivo = "Factura_" + usuario + "_" + fechaHora + ".pdf";

            // Crear el PDF
            PdfWriter writer = new PdfWriter(new File(nombreArchivo));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Encabezado
            document.add(new Paragraph("==================================="));
            document.add(new Paragraph("       FACTURA DE TRANSACCIÓN      ").setBold().setFontSize(14));
            document.add(new Paragraph("===================================\n"));

            // Datos
            document.add(new Paragraph("Cliente: " + usuario));
            document.add(new Paragraph("Banco: " + banco));
            document.add(new Paragraph("Operación: " + operacion));
            document.add(new Paragraph("Monto: $" + String.format("%.2f", monto)));
            document.add(new Paragraph("Saldo final: $" + String.format("%.2f", saldoFinal)));

            // Fecha
            document.add(new Paragraph("\nFecha: " + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))));

            // Mensaje final
            document.add(new Paragraph("\nGracias por usar el Cajero Virtual").setItalic());

            // Cerrar documento
            document.close();
            System.out.println("Factura generada: " + nombreArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
