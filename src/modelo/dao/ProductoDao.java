package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.vo.ProductoVo;
import controlador.Coordinador;

public class ProductoDao {

    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public String registrarProducto(ProductoVo productoVo) {
        String resultado = "";
        Connection connection = null;
        Conexion conexion = new Conexion();
        PreparedStatement preStatement = null;

        String consulta = "INSERT INTO producto (nombre, precio, categoria, stock) VALUES (?, ?, ?, ?)";

        try {
            connection = conexion.getConnection();
            preStatement = connection.prepareStatement(consulta);
            preStatement.setString(1, productoVo.getNombre());
            preStatement.setDouble(2, productoVo.getPrecio());
            preStatement.setString(3, productoVo.getCategoria());
            preStatement.setInt(4, productoVo.getStock());

            preStatement.execute();
            resultado = "ok";

        } catch (SQLException e) {
            System.out.println("Error registrando producto: " + e.getMessage());
            resultado = "error";
        } finally {
            conexion.desconectar();
        }

        return resultado;
    }

    public ProductoVo consultarProducto(int id) {
        Connection connection = null;
        Conexion conexion = new Conexion();
        PreparedStatement statement = null;
        ResultSet result = null;
        ProductoVo producto = null;

        String consulta = "SELECT * FROM producto WHERE id = ?";

        try {
            connection = conexion.getConnection();
            statement = connection.prepareStatement(consulta);
            statement.setInt(1, id);

            result = statement.executeQuery();
            if (result.next()) {
                producto = new ProductoVo(
                        result.getString("nombre"),
                        result.getDouble("precio"),
                        result.getString("categoria"),
                        result.getInt("stock")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error consultando producto: " + e.getMessage());
        } finally {
            conexion.desconectar();
        }

        return producto;
    }

    public ArrayList<ProductoVo> consultarTodosProductos() {
        ArrayList<ProductoVo> listaProductos = new ArrayList<>();
        Connection connection = null;
        Conexion conexion = new Conexion();
        PreparedStatement statement = null;
        ResultSet result = null;

        String consulta = "SELECT * FROM producto";

        try {
            connection = conexion.getConnection();
            statement = connection.prepareStatement(consulta);
            result = statement.executeQuery();

            while (result.next()) {
                ProductoVo producto = new ProductoVo(
                        result.getString("nombre"),
                        result.getDouble("precio"),
                        result.getString("categoria"),
                        result.getInt("stock")
                );
                producto.setId(result.getInt("id"));
                listaProductos.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error consultando productos: " + e.getMessage());
        } finally {
            conexion.desconectar();
        }

        return listaProductos;
    }

    public String actualizarProducto(ProductoVo productoVo) {
        String resultado = "";
        Connection connection = null;
        Conexion conexion = new Conexion();
        PreparedStatement preStatement = null;

        String consulta = "UPDATE producto SET nombre = ?, precio = ?, categoria = ?, stock = ? WHERE id = ?";

        try {
            connection = conexion.getConnection();
            preStatement = connection.prepareStatement(consulta);
            preStatement.setString(1, productoVo.getNombre());
            preStatement.setDouble(2, productoVo.getPrecio());
            preStatement.setString(3, productoVo.getCategoria());
            preStatement.setInt(4, productoVo.getStock());
            preStatement.setInt(5, productoVo.getId());

            preStatement.executeUpdate();
            resultado = "ok";

        } catch (SQLException e) {
            System.out.println("Error actualizando producto: " + e.getMessage());
            resultado = "error";
        } finally {
            conexion.desconectar();
        }

        return resultado;
    }

    public String eliminarProducto(int id) {
        String resultado = "";
        Connection connection = null;
        Conexion conexion = new Conexion();
        PreparedStatement preStatement = null;

        String consulta = "DELETE FROM producto WHERE id = ?";

        try {
            connection = conexion.getConnection();
            preStatement = connection.prepareStatement(consulta);
            preStatement.setInt(1, id);

            preStatement.executeUpdate();
            resultado = "Producto eliminado correctamente";

        } catch (SQLException e) {
            System.out.println("Error eliminando producto: " + e.getMessage());
            resultado = "error";
        } finally {
            conexion.desconectar();
        }

        return resultado;
    }
}
