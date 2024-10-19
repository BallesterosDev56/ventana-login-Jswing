package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controlador.Coordinador;

/**
 *
 * @author User
 */

public class VentanaPrincipal extends JFrame implements ActionListener {
      int tipoUsuario = 0;

	  private javax.swing.JButton botonConsultar;
	  private javax.swing.JButton botonRegistrar;
	  private javax.swing.JLabel labelTitulo,labelInferior;
	  private javax.swing.JPanel miPanelPrincipal,panelTitulo,panelInferior;
	  
	  private JMenuBar barraMenu;
	  private JMenu menu;
	  private JMenuItem itemOpciones;
  
	  private Dimension tamPantalla;
	  private Rectangle pantalla;
	  
	  private Coordinador miCoordinador;
	
	
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        setTitle("Ventana Principal");
        setSize(650, 350);
        setLocationRelativeTo(null);
        tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        pantalla= new Rectangle(tamPantalla);
        setBounds(pantalla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miPanelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelInferior = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 //       getContentPane().setLayout(null);

        miPanelPrincipal.setBackground(Color.lightGray);
        miPanelPrincipal.setLayout(null);
        
        panelTitulo.setBackground(Color.black);
        panelInferior.setBackground(Color.black);
      
        panelTitulo.setLayout(null);
        panelInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));

        labelTitulo.setFont(new java.awt.Font("Chiller", 0, 48)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Bienvenido al Sistema");
        labelTitulo.setForeground(Color.white);
       // labelTitulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTitulo.add(labelTitulo);
       labelTitulo.setBounds(5, 5, 380, 60);
        
        labelInferior.setFont(new java.awt.Font("Chiller", 0, 30)); // NOI18N
        labelInferior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInferior.setText("http://codejavu.blogspot.com");
        labelInferior.setForeground(Color.white);
        panelInferior.add(labelInferior);

        botonConsultar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonConsultar.setText("CONSULTAR");
        miPanelPrincipal.add(botonConsultar);
        botonConsultar.setBounds(230, 80, 190, 60);
        botonConsultar.addActionListener(this);

        botonRegistrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonRegistrar.setText("REGISTRAR");
        miPanelPrincipal.add(botonRegistrar);
        botonRegistrar.setBounds(20, 80, 190, 60);
        botonRegistrar.addActionListener(this);
        
        barraMenu =new JMenuBar();
        menu=new JMenu();
        itemOpciones =new JMenuItem();
        
        menu.setText("Opciones");
        itemOpciones.setText("Cambiar de Usuario");
        itemOpciones.addActionListener(this);
        
        menu.add(itemOpciones);
        barraMenu.add(menu);       
        
        setJMenuBar(barraMenu);
  
        miPanelPrincipal.setBounds(0, 0, 670, 350);
        panelTitulo.setBounds(0, 0, 1500, 70);
        panelInferior.setBounds(0, 667, 1350,40);
        miPanelPrincipal.add(panelTitulo);
        miPanelPrincipal.add(panelInferior);
        getContentPane().add(miPanelPrincipal);
        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	public void asignarPrivilegios(String usuario) {
		labelTitulo.setText("Bienvenido : "+usuario);
		
		if (usuario.equals("Administrador")) {
			botonConsultar.setVisible(true);
			botonRegistrar.setVisible(true);
		}else if(usuario.equals("Usuario")) {
			botonConsultar.setVisible(false);
			botonRegistrar.setVisible(true);
		} else if (usuario.equals("Secretaria")) {
            tipoUsuario = 3;
            botonConsultar.setVisible(true);
            botonRegistrar.setVisible(true);
        }
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==itemOpciones) {
			miCoordinador.mostrarLogin();			
		}
		
		if (e.getSource()==botonRegistrar) {
			miCoordinador.mostrarVentanaRegistro();			
		}
		
		if (e.getSource()==botonConsultar) {
			miCoordinador.mostrarVentanaConsulta(tipoUsuario);
		}
		
	}



  

}
