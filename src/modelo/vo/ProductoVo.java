package modelo.vo;

import modelo.conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoVo {
    private int id;
    private String nombre;
    private double precio;
    private String categoria;
    private int stock;


    public ProductoVo(String nombre, double precio, String categoria, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId() {
        Connection connection=null;
        Conexion miConexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet result=null;

        UsuarioVo miUsuario=new UsuarioVo();

        connection=miConexion.getConnection();

        String consulta="";
        consulta="SELECT * FROM producto where nombre = ?";

        ArrayList<UsuarioVo> listUser=new ArrayList<UsuarioVo>();
        try {
            if (connection!=null) {
                statement=connection.prepareStatement(consulta);
                statement.setString(1, this.nombre);

                result=statement.executeQuery();

                while(result.next()){
                    setId(result.getInt("id"));
                }
                miConexion.desconectar();
            }else{
                setId(0);
            }


        } catch (SQLException e) {
            System.out.println("Error en la consulta del id del producto: "+e.getMessage());
        }

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductoVO {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", stock=" + stock +
                '}';
    }
}
