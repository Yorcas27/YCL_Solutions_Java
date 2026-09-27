
package com.yclsolutions.app;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Main {

    public static void main(String[] args) {

        // INICIO DEL PROYECTO
        System.out.println("YCL_Solutions - Proyecto Java funcionando correctamente.");
        System.out.println("Java 21 configurado correctamente.");

        // CONSULTAR CLIENTES
        ClienteDAO.listarClientes();

        // BUSCAR CLIENTE
        System.out.println();
        System.out.println("=== BUSQUEDA DE CLIENTE ===");

        Cliente cliente = ClienteDAO.buscarPorDocumento("12345678");

        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        // ACTUALIZAR CLIENTE DE PRUEBA
        System.out.println();
        System.out.println("=== ACTUALIZACION DE CLIENTE ===");

        Cliente clienteActualizado = new Cliente(
            5,
            "CLI-JAVA-001",
            "9999999999",
            "Cliente Prueba Java Actualizado",
            "3001234567",
            "prueba@yclsolutions.com",
            "Medellin",
            "Activo"
        );

        boolean actualizado = ClienteDAO.actualizarCliente(clienteActualizado);

        if (actualizado) {
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el cliente.");
        }

        // CIERRE DEL CONNECTOR/J
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}

