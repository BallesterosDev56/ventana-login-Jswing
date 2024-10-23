package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import controlador.Coordinador;

public class VentanaAddProduct extends JDialog implements ActionListener {

    public VentanaAddProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(705, 380);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        panelRegistro = new javax.swing.JPanel();
        tituloRegistro = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();
        labelIdProducto = new javax.swing.JLabel();
        labelStock = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        separadorInferior = new javax.swing.JSeparator();
        campoNombre = new javax.swing.JTextField();
        campoPrecio = new javax.swing.JTextField();
        campoIdProducto = new javax.swing.JTextField();
        campoStock = new javax.swing.JTextField();
        campoCategoria = new javax.swing.JTextField();
        separadorSuperior = new javax.swing.JSeparator();
        btonCancelar = new javax.swing.JButton();
        btonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelRegistro.setBackground(new java.awt.Color(204, 204, 204));
        panelRegistro.setLayout(null);

        tituloRegistro.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
        tituloRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloRegistro.setText("Registro de Producto");
        tituloRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelRegistro.add(tituloRegistro);
        tituloRegistro.setBounds(20, 10, 660, 60);

        labelTexto.setFont(new java.awt.Font("Verdana", 1, 14));
        labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTexto.setText("Complete el formulario para registrar un producto.");
        panelRegistro.add(labelTexto);
        labelTexto.setBounds(20, 90, 550, 20);

        labelNombre.setFont(new java.awt.Font("Verdana", 0, 12));
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNombre.setText("* Nombre:");
        panelRegistro.add(labelNombre);
        labelNombre.setBounds(0, 140, 90, 20);
        panelRegistro.add(campoNombre);
        campoNombre.setBounds(100, 140, 300, 20);

        labelPrecio.setFont(new java.awt.Font("Verdana", 0, 12));
        labelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPrecio.setText("Precio:");
        panelRegistro.add(labelPrecio);
        labelPrecio.setBounds(0, 170, 90, 20);
        panelRegistro.add(campoPrecio);
        campoPrecio.setBounds(100, 170, 300, 20);

        labelIdProducto.setFont(new java.awt.Font("Verdana", 0, 12));
        labelIdProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelIdProducto.setText("* ID Producto:");
        panelRegistro.add(labelIdProducto);
        labelIdProducto.setBounds(400, 140, 100, 20);
        panelRegistro.add(campoIdProducto);
        campoIdProducto.setBounds(510, 140, 170, 20);

        labelStock.setFont(new java.awt.Font("Verdana", 0, 12));
        labelStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStock.setText("Stock:");
        panelRegistro.add(labelStock);
        labelStock.setBounds(400, 170, 100, 20);
        panelRegistro.add(campoStock);
        campoStock.setBounds(510, 170, 170, 20);

        labelCategoria.setFont(new java.awt.Font("Verdana", 0, 12));
        labelCategoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCategoria.setText("Categoría:");
        panelRegistro.add(labelCategoria);
        labelCategoria.setBounds(0, 200, 90, 20);
        panelRegistro.add(campoCategoria);
        campoCategoria.setBounds(100, 200, 300, 20);

        panelRegistro.add(separadorSuperior);
        separadorSuperior.setBounds(20, 120, 660, 10);
        panelRegistro.add(separadorInferior);
        separadorInferior.setBounds(20, 250, 660, 10);

        btonCancelar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonCancelar.setText("Cancelar");
        panelRegistro.add(btonCancelar);
        btonCancelar.setBounds(570, 270, 110, 30);
        btonCancelar.addActionListener(this);

        btonAceptar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonAceptar.setText("Aceptar");
        panelRegistro.add(btonAceptar);
        btonAceptar.setBounds(450, 270, 110, 30);
        btonAceptar.addActionListener(this);

        getContentPane().add(panelRegistro);
        panelRegistro.setBounds(0, 0, 690, 330);
        pack();
    }

    // Variables declaration
    private javax.swing.JButton btonAceptar;
    private javax.swing.JButton btonCancelar;
    private javax.swing.JTextField campoIdProducto;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoStock;
    private javax.swing.JLabel tituloRegistro;
    private javax.swing.JLabel labelIdProducto;
    private javax.swing.JLabel labelStock;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JSeparator separadorInferior;
    private javax.swing.JSeparator separadorSuperior;
    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btonAceptar) {
            // Lógica para registrar producto
            JOptionPane.showMessageDialog(this, "Producto registrado exitosamente.");
        }
        if (e.getSource() == btonCancelar) {
            dispose();
        }
    }
}
