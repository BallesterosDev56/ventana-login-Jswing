package controlador;

import modelo.Logica;
import modelo.dao.UsuarioDao;
import vista.*;

public class Aplicacion {
	
	public void iniciarSistema(){
		
		//Instanciamos las clases unicas
		VentanaPrincipal miVentana=new VentanaPrincipal();
		VentanaLogin miLogin=new VentanaLogin(miVentana, true);
		VentanaTabla miVentanaTabla = new VentanaTabla(miVentana, true);
		Coordinador miCoordinador=new Coordinador();
		Logica miLogica=new Logica();
		VentanaRegistro miVentanaRegistro=new VentanaRegistro(miVentana, true);
		VentanaConsultaIndividual miVentanaConsultaIndividual=new VentanaConsultaIndividual(miVentana, true);
		UsuarioDao miUsuarioDao=new UsuarioDao();
		
		
		//Relacionamos las clases con el coordinador				
		miVentana.setCoordinador(miCoordinador);
		miLogin.setCoordinador(miCoordinador);
		miLogica.setCoordinador(miCoordinador);
		miVentanaRegistro.setCoordinador(miCoordinador);
		miVentanaConsultaIndividual.setCoordinador(miCoordinador);
		miVentanaTabla.setCoordinador(miCoordinador);
		miUsuarioDao.setCoordinador(miCoordinador);

		
		//Relacionamos el Coordinador con las Clases
		miCoordinador.setVentanaPrincipal(miVentana);
		miCoordinador.setVentanaLogin(miLogin);
		miCoordinador.setLogica(miLogica);
		miCoordinador.setVentanaRegistro(miVentanaRegistro);
		miCoordinador.setVentanaConsultaIndividual(miVentanaConsultaIndividual);
		miCoordinador.setUsuarioDao(miUsuarioDao);
		miCoordinador.setVentanaTabla(miVentanaTabla);

		
		miVentana.setVisible(true);
		miLogin.setVisible(true);
	}

}
