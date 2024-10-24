package modelo.vo;

import java.util.ArrayList;
import java.util.List;

public class CompraVo {
    private int id;
    private int idProducto;
    private String documentoUsuario;
    private double precio;

    public CompraVo(String documentoUsuario, int idProducto, double precio) {
        this.documentoUsuario = documentoUsuario;
        this.idProducto = idProducto;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

}
