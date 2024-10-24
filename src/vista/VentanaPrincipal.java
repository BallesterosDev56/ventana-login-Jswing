package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import controlador.Coordinador;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JButton botonConsultaIndividual, botonAgregarProductos, botonRegistrar,
            botonConsultaTabla, botonConsultaCompras, botonTablaProductos, botonCompra;
    private JLabel labelTitulo, labelInferior;
    private JPanel miPanelPrincipal, panelTitulo, panelInferior, panelUsuarios,
            panelProductos, panelCompras;
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemOpciones;
    private Coordinador miCoordinador;
    private int tipoUsuario = 0;
    private String usuarioDocumento;

    public VentanaPrincipal() {
        initComponents();
        setTitle("Ventana Principal");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // Configuración general
        miPanelPrincipal = new JPanel(new GridLayout(1, 3, 10, 0)); // Tres secciones horizontales
        panelTitulo = new JPanel(new BorderLayout());
        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        labelTitulo = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        labelInferior = new JLabel("http://codejavu.blogspot.com", SwingConstants.CENTER);

        // Estilo del título e inferior
        labelTitulo.setFont(new Font("Chiller", Font.PLAIN, 60));
        labelTitulo.setForeground(Color.WHITE);
        panelTitulo.setBackground(Color.BLACK);
        panelTitulo.add(labelTitulo, BorderLayout.CENTER);

        labelInferior.setFont(new Font("Chiller", Font.PLAIN, 30));
        labelInferior.setForeground(Color.WHITE);
        panelInferior.setBackground(Color.BLACK);
        panelInferior.add(labelInferior);

        // Inicialización de botones
        botonConsultaIndividual = crearBoton("Consulta Usuario Individual");
        botonRegistrar = crearBoton("Registrar Usuario");
        botonConsultaTabla = crearBoton("Tabla de Usuarios");

        botonAgregarProductos = crearBoton("Agregar Productos");
        botonTablaProductos = crearBoton("Tabla de Productos");

        botonCompra = crearBoton("Realizar Compras");
        botonConsultaCompras = crearBoton("Consultar Compras");

        // Inicialización de paneles
        panelUsuarios = crearPanelSeccion("Gestión de Usuarios", botonRegistrar, botonConsultaIndividual, botonConsultaTabla);
        panelProductos = crearPanelSeccion("Gestión de Productos", botonAgregarProductos, botonTablaProductos);
        panelCompras = crearPanelSeccion("Compras", botonCompra, botonConsultaCompras);

        // Añadir los paneles de gestión al panel principal
        miPanelPrincipal.add(panelUsuarios);
        miPanelPrincipal.add(panelProductos);
        miPanelPrincipal.add(panelCompras);

        // Menú
        barraMenu = new JMenuBar();
        menu = new JMenu("Opciones");
        itemOpciones = new JMenuItem("Cambiar de Usuario");
        menu.add(itemOpciones);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        // Layout general
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelTitulo, BorderLayout.NORTH);
        getContentPane().add(miPanelPrincipal, BorderLayout.CENTER);
        getContentPane().add(panelInferior, BorderLayout.SOUTH);

        // Listeners
        agregarListeners();

        pack();
        setLocationRelativeTo(null);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        return boton;
    }

    private JPanel crearPanelSeccion(String titulo, JButton... botones) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < botones.length; i++) {
            gbc.gridy = i;
            panel.add(botones[i], gbc);
        }
        return panel;
    }

    private void agregarListeners() {
        botonConsultaIndividual.addActionListener(this);
        botonRegistrar.addActionListener(this);
        botonConsultaTabla.addActionListener(this);
        botonAgregarProductos.addActionListener(this);
        botonTablaProductos.addActionListener(this);
        botonCompra.addActionListener(this);
        botonConsultaCompras.addActionListener(this);
        itemOpciones.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemOpciones) {
            miCoordinador.mostrarLogin();
        } else if (source == botonRegistrar) {
            miCoordinador.mostrarVentanaRegistro();
        } else if (source == botonConsultaIndividual) {
            miCoordinador.setUsuarioDocumento(usuarioDocumento);
            miCoordinador.setUsuarioTipo(tipoUsuario);
            miCoordinador.mostrarVentanaConsulta();
        } else if (source == botonConsultaTabla) {
            miCoordinador.mostrarVentanaTabla();
        } else if (source == botonAgregarProductos) {
            miCoordinador.mostrarVentanaAddProduct();
        } else if (source == botonTablaProductos) {
            miCoordinador.mostrarTablaProductos();
        } else if (source == botonCompra) {
            miCoordinador.mostrarVentanaCompra();
        } else if (source == botonConsultaCompras) {
            miCoordinador.mostrarVentanaConsultaCompra();
        }
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public void asignarPrivilegios(ArrayList<String> usuario) {
        this.usuarioDocumento = usuario.get(usuario.size() - 1);
        labelTitulo.setText("Bienvenido : " + usuario.get(0));

        if (usuario.get(0).equals("Administrador")) {
            botonRegistrar.setVisible(true);
            botonAgregarProductos.setVisible(true);
            botonConsultaCompras.setVisible(true);
            botonConsultaCompras.setVisible(true);
            tipoUsuario = 1;
        } else if (usuario.get(0).equals("Usuario")) {
            tipoUsuario = 2;
            botonRegistrar.setVisible(false);
            botonAgregarProductos.setVisible(false);
            botonConsultaCompras.setVisible(false);
        } else if (usuario.get(0).equals("Secretaria")) {
            botonRegistrar.setVisible(true);
            botonAgregarProductos.setVisible(true);
            tipoUsuario = 3;
        }
    }
}
