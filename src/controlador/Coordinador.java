package controlador;

import modelo.Logica;
import modelo.dao.CompraDao;
import modelo.dao.ProductoDao;
import modelo.dao.UsuarioDao;
import modelo.vo.CompraVo;
import modelo.vo.ProductoVo;
import modelo.vo.UsuarioVo;
import vista.*;

import java.util.ArrayList;

public class Coordinador {

	private VentanaPrincipal miVentana;
	private VentanaLogin miLogin;
	private Logica miLogica;
	private VentanaRegistro miVentanaRegistro;
	private VentanaTabla miVentanaTabla;
	private VentanaAddProduct miVentanaAddProduct;
	private VentanaConsultaIndividual miVentanaConsultaIndividual;
	private UsuarioDao miUsuarioDao;
	private ProductoDao miProductoDao;
	private VentanaTablaProductos miVentanaTablaProductos;
	private VentanaCompra miVentanaCompra;
	private CompraDao miCompraDao;
	private VentanaConsultaCompras miVentanaConsultaCompras;

	public void setVentanaPrincipal(VentanaPrincipal miVentana) {
		this.miVentana=miVentana;
	}

	public void setVentanaLogin(VentanaLogin miLogin) {
		this.miLogin=miLogin;
	}

	public void setLogica(Logica miLogica) {
		this.miLogica=miLogica;
	}

	public ArrayList validarIngreso(int index, String doc, String pass) {
		return miLogica.validarIngreso(index, doc, pass);
	}

	public void cerrarVentanaLogin() {
		miLogin.dispose();
	}

	public void asignarPrivilegios(ArrayList<String> usuario) {
		miVentana.asignarPrivilegios(usuario);
	}

	public void mostrarLogin() {
		miLogin.limpiar();
		miLogin.setVisible(true);
	}

	public void setVentanaRegistro(VentanaRegistro miVentanaRegistro) {
		this.miVentanaRegistro=miVentanaRegistro;
	}

	public void setVentanaTabla(VentanaTabla miVentanaTabla) {
		this.miVentanaTabla=miVentanaTabla;
	}

	public void setVentanaConsultaIndividual(	VentanaConsultaIndividual miVentanaConsultaIndividual) {
		this.miVentanaConsultaIndividual=miVentanaConsultaIndividual;
	}

	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaConsultaIndividual.setVisible(true);
	}

	public void setUsuarioDocumento(String usuarioDocumento) {
		miVentanaConsultaIndividual.setUsuarioDocumento(usuarioDocumento);
		miVentanaTabla.setUsuarioDocumento(usuarioDocumento);
		miVentanaAddProduct.setUsuarioDocumento(usuarioDocumento);
		miVentanaCompra.setUsuarioDocumento(usuarioDocumento);
		miVentanaConsultaCompras.setUsuarioDocumento(usuarioDocumento);
	}

	public void setUsuarioTipo(int usuarioTipo) {
		miVentanaConsultaIndividual.setUsuarioTipo(usuarioTipo);
		miVentanaTabla.setUsuarioTipo(usuarioTipo);
		miVentanaAddProduct.setUsuarioTipo(usuarioTipo);
		miVentanaCompra.setUsuarioTipo(usuarioTipo);
		miVentanaConsultaCompras.setUsuarioTipo(usuarioTipo);
	}

	public void setUsuarioDao(UsuarioDao miUsuarioDao) {
		this.miUsuarioDao=miUsuarioDao;
	}

	public String registrarUsuario(UsuarioVo miUsuarioVo) {
		return miUsuarioDao.registrarUsuario(miUsuarioVo);
	}

	public boolean validarCampos(UsuarioVo miUsuarioVo) {
		return miLogica.validarCampos(miUsuarioVo);
	}

	public Integer validarEdad(String edadIngresada) {
		// TODO Auto-generated method stub
		return miLogica.validarEdad(edadIngresada);
	}

	public UsuarioVo consultarUsuario(String doc, String pass) {
		
		return miUsuarioDao.consultarUsuario(doc);
	}

	public ArrayList<UsuarioVo> consultarUsuariosActivos() {

		return miUsuarioDao.consultarUsuariosActivos();
	}

	public ArrayList<UsuarioVo> consultarUsuariosInactivos() {

		return miUsuarioDao.consultarUsuariosInactivos();
	}

	public UsuarioVo consultarUsuarioAll(String doc, String pass) {

		return miUsuarioDao.consultarUsuarioAll(doc);
	}

	public String actualizaUsuario(UsuarioVo miUsuarioVo) {
		return miUsuarioDao.actualizaUsuario(miUsuarioVo);
	}

	public String eliminarUsuario(String documento) {
		return miUsuarioDao.eliminarUsuario(documento);
	}

	public void mostrarVentanaTabla() {
		miVentanaTabla.setPermissions();
		miVentanaTabla.setVisible(true);
	}

	public void mostrarVentanaAddProduct() {
		miVentanaAddProduct.setPermissions();
		miVentanaAddProduct.setVisible(true);
	}

	public void setVentanaAddProduct(VentanaAddProduct miVentanaAddProduct) {
		this.miVentanaAddProduct = miVentanaAddProduct;
	}

	// Crear un nuevo producto
	public String registrarProducto(ProductoVo productoVo) {
		return miProductoDao.registrarProducto(productoVo);
	}

	// Obtener la lista de productos
	public ArrayList<ProductoVo> consultarTodosProductos() {
		return miProductoDao.consultarTodosProductos();
	}

	// Obtener producto por id
	public ProductoVo consultarProducto(int id) {
		return miProductoDao.consultarProducto(id);
	}

	// Actualizar los datos de un producto
	public String actualizarProducto(ProductoVo productoVo) {
		return miProductoDao.actualizarProducto(productoVo);
	}

	// Eliminar un producto por ID
	public String eliminarProducto(int id) {
		return miProductoDao.eliminarProducto(id);
	}

	public String validarProducto(ProductoVo producto) {
		return miLogica.validarProducto(producto);
	}

	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao = miProductoDao;
	}

	public void setVentanaTablaProductos(VentanaTablaProductos miVentanaTablaProductos) {
		this.miVentanaTablaProductos = miVentanaTablaProductos;
	}

	public void mostrarTablaProductos() {
		miVentanaTablaProductos.setVisible(true);
	}

	public void setVentanaCompra(VentanaCompra miVentanaCompra) {
		this.miVentanaCompra = miVentanaCompra;
	}

	public void mostrarVentanaCompra() {
		miVentanaCompra.mostrarProductos();
		miVentanaCompra.setVisible(true);
	}

	public boolean registrarCompra(CompraVo compra) {
		return miCompraDao.registrarCompra(compra);
	}

	public void setCompraDao(CompraDao miCompraDao) {
		this.miCompraDao = miCompraDao;
	}

	public void setVentanaConsultaCompras(VentanaConsultaCompras miVentanaConsultaCompras) {
		this.miVentanaConsultaCompras = miVentanaConsultaCompras;
	}

	public void mostrarVentanaConsultaCompra() {
		miVentanaConsultaCompras.mostrarComprasUsuario();
		miVentanaConsultaCompras.setVisible(true);
	}

	public ArrayList<CompraVo> consultarCompras(String idUsuario) {
		return miCompraDao.consultarCompras(idUsuario);
	}
}
