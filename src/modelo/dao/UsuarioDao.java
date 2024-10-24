package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.UsuarioVo;

import controlador.Coordinador;

public class UsuarioDao {
	
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	public String registrarUsuario(UsuarioVo miUsuarioVo) {
		String resultado="";
			
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="INSERT INTO usuario (documento, nombre, profesion, edad, direccion, telefono, tipo, password, estado)" +
				" VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miUsuarioVo.getDocumento());
			preStatement.setString(2,miUsuarioVo.getNombre());
			preStatement.setString(3,miUsuarioVo.getProfesion());
			preStatement.setInt(4, miUsuarioVo.getEdad());
			preStatement.setString(5, miUsuarioVo.getDireccion());
			preStatement.setString(6, miUsuarioVo.getTelefono());
			preStatement.setInt(7, miUsuarioVo.getTipo());
			preStatement.setString(8, miUsuarioVo.getPassword());
			preStatement.setInt(9, 1);
			preStatement.execute();
			
			resultado="ok";
			
		} catch (SQLException e) {
			System.out.println("No se pudo registrar el dato: "+e.getMessage());
			e.printStackTrace();
			resultado="error";
		}
		
		conexion.desconectar();
		   
		return resultado;
	}

	public boolean verifyMismoUsuario(String labelDocumento, String usuarioDocumento) {
		if(!Objects.equals(labelDocumento, usuarioDocumento)) {
			return false;
		}
		return true;
	}

	public UsuarioVo consultarUsuario(String doc) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		UsuarioVo miUsuario=new UsuarioVo();
		
		connection=miConexion.getConnection();

		String consulta="";
		consulta="SELECT * FROM usuario where documento = ? and estado = 1";

		ArrayList<UsuarioVo> listUser=new ArrayList<UsuarioVo>();
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setString(1, doc);

				result=statement.executeQuery();
				
				while(result.next()){
					miUsuario=new UsuarioVo();
					miUsuario.setDocumento(result.getString("documento"));
					miUsuario.setNombre(result.getString("nombre"));
					miUsuario.setProfesion(result.getString("profesion"));
					miUsuario.setEdad(result.getInt("edad"));
					miUsuario.setDireccion(result.getString("direccion"));
					miUsuario.setTelefono(result.getString("telefono"));		
					miUsuario.setTipo(result.getInt("tipo"));
					miUsuario.setPassword(result.getString("password"));
					
					listUser.add(miUsuario);
				}		
				   miConexion.desconectar();
			}else{
				miUsuario=null;
			}
			
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: "+e.getMessage());
		}
		
		return miUsuario;
	}

	public UsuarioVo consultarUsuarioAll(String doc) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;

		UsuarioVo miUsuario=new UsuarioVo();

		connection=miConexion.getConnection();

		String consulta="";
		consulta="SELECT * FROM usuario where documento = ?";

		ArrayList<UsuarioVo> listUser=new ArrayList<UsuarioVo>();
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setString(1, doc);

				result=statement.executeQuery();

				while(result.next()){
					miUsuario=new UsuarioVo();
					miUsuario.setDocumento(result.getString("documento"));
					miUsuario.setNombre(result.getString("nombre"));
					miUsuario.setProfesion(result.getString("profesion"));
					miUsuario.setEdad(result.getInt("edad"));
					miUsuario.setDireccion(result.getString("direccion"));
					miUsuario.setTelefono(result.getString("telefono"));
					miUsuario.setTipo(result.getInt("tipo"));
					miUsuario.setPassword(result.getString("password"));

					listUser.add(miUsuario);
				}
				   miConexion.desconectar();
			}else{
				miUsuario=null;
			}


		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: "+e.getMessage());
		}

		return miUsuario;
	}

	public ArrayList<UsuarioVo> consultarUsuariosActivos() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ArrayList<UsuarioVo> listUser = new ArrayList<>();

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM usuario where estado = 1";

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				result = statement.executeQuery();

				while (result.next()) {
					UsuarioVo miUsuario = new UsuarioVo();
					miUsuario.setDocumento(result.getString("documento"));
					miUsuario.setNombre(result.getString("nombre"));
					miUsuario.setProfesion(result.getString("profesion"));
					miUsuario.setEdad(result.getInt("edad"));
					miUsuario.setDireccion(result.getString("direccion"));
					miUsuario.setTelefono(result.getString("telefono"));
					miUsuario.setTipo(result.getInt("tipo"));
					miUsuario.setPassword(result.getString("password"));

					listUser.add(miUsuario);
				}
				miConexion.desconectar();
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de usuarios: " + e.getMessage());
		}

		return listUser;
	}

	public ArrayList<UsuarioVo> consultarUsuariosInactivos() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ArrayList<UsuarioVo> listUser = new ArrayList<>();

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM usuario where estado = 0";

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				result = statement.executeQuery();

				while (result.next()) {
					UsuarioVo miUsuario = new UsuarioVo();
					miUsuario.setDocumento(result.getString("documento"));
					miUsuario.setNombre(result.getString("nombre"));
					miUsuario.setProfesion(result.getString("profesion"));
					miUsuario.setEdad(result.getInt("edad"));
					miUsuario.setDireccion(result.getString("direccion"));
					miUsuario.setTelefono(result.getString("telefono"));
					miUsuario.setTipo(result.getInt("tipo"));
					miUsuario.setPassword(result.getString("password"));

					listUser.add(miUsuario);
				}
				miConexion.desconectar();
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de usuarios: " + e.getMessage());
		}

		return listUser;
	}


	public String actualizaUsuario(UsuarioVo miUsuarioVo) {
		String resultado="";
		Connection connection=null;
		Conexion miConexion=new Conexion();
		connection=miConexion.getConnection();
		try{
			String consulta="UPDATE usuario SET documento= ? ,nombre = ? , profesion=? , edad=? , direccion=? ,telefono=?, tipo =? WHERE documento= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, miUsuarioVo.getDocumento());
			preStatement.setString(2,miUsuarioVo.getNombre());
			preStatement.setString(3,miUsuarioVo.getProfesion());
			preStatement.setInt(4, miUsuarioVo.getEdad());
			preStatement.setString(5, miUsuarioVo.getDireccion());
			preStatement.setString(6, miUsuarioVo.getTelefono());
			preStatement.setInt(7, miUsuarioVo.getTipo());
			preStatement.setString(8, miUsuarioVo.getDocumento());
			preStatement.executeUpdate();
			
          resultado="ok";
          
          miConexion.desconectar();

        }catch(SQLException	 e){
            System.out.println(e);
            resultado="error";
        }
		return resultado;
	}

	public String eliminarUsuario(String documento) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		connection=miConexion.getConnection();
		
		String resp="";
		try {
			String sentencia="UPDATE usuario SET estado = 0 WHERE documento= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setString(1, documento);
			
			statement.executeUpdate();
						
			resp="Usuario eliminado correctamente";
            statement.close();
            miConexion.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			resp="error";
		}
		return resp;
	}

}
