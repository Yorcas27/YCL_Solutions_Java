
package com.yclsolutions.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {

    // CONSULTAR TODOS LOS CLIENTES
    public static void listarClientes() {

        String sql = "SELECT id_cliente, codigo, documento, nombre, telefono, correo, ciudad, estado " +
                     "FROM clientes";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            System.out.println();
            System.out.println("=== CLIENTES DE YCL_SOLUTIONS ===");

            while (resultado.next()) {

                Cliente cliente = new Cliente(
                    resultado.getInt("id_cliente"),
                    resultado.getString("codigo"),
                    resultado.getString("documento"),
                    resultado.getString("nombre"),
                    resultado.getString("telefono"),
                    resultado.getString("correo"),
                    resultado.getString("ciudad"),
                    resultado.getString("estado")
                );

                System.out.println(cliente);
            }

        } catch (Exception e) {
            System.out.println("Error al consultar los clientes.");
            System.out.println("Detalle: " + e.getMessage());
        }
    }

    // BUSCAR CLIENTE POR DOCUMENTO
    public static Cliente buscarPorDocumento(String documento) {

        String sql = "SELECT id_cliente, codigo, documento, nombre, telefono, correo, ciudad, estado " +
                     "FROM clientes WHERE documento = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, documento);

            try (ResultSet resultado = sentencia.executeQuery()) {

                if (resultado.next()) {

                    return new Cliente(
                        resultado.getInt("id_cliente"),
                        resultado.getString("codigo"),
                        resultado.getString("documento"),
                        resultado.getString("nombre"),
                        resultado.getString("telefono"),
                        resultado.getString("correo"),
                        resultado.getString("ciudad"),
                        resultado.getString("estado")
                    );
                }
            }

        } catch (Exception e) {
            System.out.println("Error al buscar el cliente.");
            System.out.println("Detalle: " + e.getMessage());
        }

        return null;
    }

    // REGISTRAR CLIENTE
    public static boolean registrarCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes " +
                     "(codigo, documento, nombre, telefono, correo, ciudad, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, cliente.getCodigo());
            sentencia.setString(2, cliente.getDocumento());
            sentencia.setString(3, cliente.getNombre());
            sentencia.setString(4, cliente.getTelefono());
            sentencia.setString(5, cliente.getCorreo());
            sentencia.setString(6, cliente.getCiudad());
            sentencia.setString(7, cliente.getEstado());

            int filasAfectadas = sentencia.executeUpdate();

            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al registrar el cliente.");
            System.out.println("Detalle: " + e.getMessage());
            return false;
        }
    }

    // ACTUALIZAR CLIENTE
    public static boolean actualizarCliente(Cliente cliente) {

        String sql = "UPDATE clientes SET " +
                     "codigo = ?, documento = ?, nombre = ?, telefono = ?, " +
                     "correo = ?, ciudad = ?, estado = ? " +
                     "WHERE id_cliente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, cliente.getCodigo());
            sentencia.setString(2, cliente.getDocumento());
            sentencia.setString(3, cliente.getNombre());
            sentencia.setString(4, cliente.getTelefono());
            sentencia.setString(5, cliente.getCorreo());
            sentencia.setString(6, cliente.getCiudad());
            sentencia.setString(7, cliente.getEstado());
            sentencia.setInt(8, cliente.getIdCliente());

            int filasAfectadas = sentencia.executeUpdate();

            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente.");
            System.out.println("Detalle: " + e.getMessage());
            return false;
        }
    }
}

