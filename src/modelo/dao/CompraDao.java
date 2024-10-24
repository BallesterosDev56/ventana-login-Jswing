package modelo.dao;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.CompraVo;
import modelo.vo.ProductoVo;
import modelo.vo.UsuarioVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDao {
    private Connection connection;
    private Coordinador miCoordinador;


    public boolean registrarCompra(CompraVo compra) {
        String resultado = "";
        Connection connection = null;
        Conexion conexion = new Conexion();
        String sqlCompra = "INSERT INTO compra (documento_usuario, id_producto, precio) VALUES (?, ?, ?)";

        try {
            // Desactivar el autocommit
            connection = conexion.getConnection();
            connection.setAutoCommit(false);

            // Guardar la compra
            PreparedStatement stmtCompra = connection.prepareStatement(sqlCompra, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtCompra.setString(1, compra.getDocumentoUsuario());
            stmtCompra.setInt(2, compra.getIdProducto());
            stmtCompra.setString(3, String.valueOf(compra.getPrecio()));
            stmtCompra.executeUpdate();

            connection.commit();
            return true;

        } catch (SQLException e) {
            // Revertir transacción en caso de error
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            // Restablecer el autocommit
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public ArrayList<CompraVo> consultarCompras(String idUsuario) {
        Connection connection = null;
        Conexion miConexion = new Conexion();
        PreparedStatement statement = null;
        ResultSet result = null;

        ArrayList<CompraVo> comprasRealizadas = new ArrayList<>();

        connection = miConexion.getConnection();

        String consulta = "SELECT * FROM compra where documento_usuario = ?";

        try {
            if (connection != null) {
                statement = connection.prepareStatement(consulta);
                statement.setString(1, idUsuario);
                result = statement.executeQuery();

                while (result.next()) {
                    int idCompra = result.getInt("id");
                    String documentoUsuario = result.getString("documento_usuario");
                    int idProducto = result.getInt("id_producto");
                    String precio = result.getString("precio");
                    CompraVo compra = new CompraVo(documentoUsuario, idProducto, Double.parseDouble(precio));
                    compra.setId(idCompra);

                    comprasRealizadas.add(compra);
                }
                miConexion.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta de compras: " + e.getMessage());
        }

        return comprasRealizadas;
    }
}
