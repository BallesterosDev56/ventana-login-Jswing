package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import controlador.Coordinador;
import modelo.vo.ProductoVo;

public class VentanaAddProduct extends JDialog implements ActionListener {
    private JComboBox<String> comboCategoria;  // Combo de categorías
    private Coordinador miCoordinador;
    private String usuarioDocumento;
    private int usuarioTipo;

    public VentanaAddProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(720, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    }


    private void initComponents() {
        panelRegistro = new JPanel();
        tituloRegistro = new JLabel();
        labelPrecio = new JLabel();
        labelTexto = new JLabel();
        labelStock = new JLabel();
        labelNombre = new JLabel();
        labelCategoria = new JLabel();
        separadorInferior = new JSeparator();
        campoNombre = new JTextField();
        campoPrecio = new JTextField();
        campoStock = new JTextField();
        comboCategoria = new JComboBox<>(new String[] {
                "Bebidas", "Lácteos", "Aseo", "Carnes"
        }); // Opciones del ComboBox
        separadorSuperior = new JSeparator();
        btonCancelar = new JButton();
        btonAceptar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Configuración del panel principal
        panelRegistro.setBackground(new java.awt.Color(204, 204, 204));
        GroupLayout layout = new GroupLayout(panelRegistro);
        panelRegistro.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Configuración de componentes
        tituloRegistro.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
        tituloRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        tituloRegistro.setText("Registro de Producto");
        tituloRegistro.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTexto.setFont(new java.awt.Font("Verdana", 1, 14));
        labelTexto.setText("Complete el formulario para registrar un producto.");

        labelNombre.setFont(new java.awt.Font("Verdana", 0, 12));
        labelNombre.setText("* Nombre:");

        labelPrecio.setFont(new java.awt.Font("Verdana", 0, 12));
        labelPrecio.setText("Precio:");

        labelStock.setFont(new java.awt.Font("Verdana", 0, 12));
        labelStock.setText("Stock:");

        labelCategoria.setFont(new java.awt.Font("Verdana", 0, 12));
        labelCategoria.setText("Categoría:");

        comboCategoria.setFont(new java.awt.Font("Verdana", 0, 12));
        comboCategoria.setSelectedIndex(0);  // Opción por defecto

        btonCancelar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonCancelar.setText("Cancelar");
        btonCancelar.addActionListener(this);

        btonAceptar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonAceptar.setText("Registrar");
        btonAceptar.addActionListener(this);

        // Layout - Distribución en grupos
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(tituloRegistro, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE)
                .addComponent(labelTexto)
                .addComponent(separadorSuperior)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelNombre)
                                .addComponent(labelPrecio)
                                .addComponent(labelCategoria))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(campoNombre, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoPrecio, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboCategoria, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelStock))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(campoStock, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                .addComponent(separadorInferior)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(btonAceptar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btonCancelar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(tituloRegistro, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addComponent(labelTexto)
                .addComponent(separadorSuperior, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNombre)
                        .addComponent(campoNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelStock)
                        .addComponent(campoStock, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPrecio)
                        .addComponent(campoPrecio, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCategoria)
                        .addComponent(comboCategoria, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addComponent(separadorInferior, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btonAceptar)
                        .addComponent(btonCancelar))
        );

        getContentPane().add(panelRegistro);
        pack();
    }


    // Variables declaration
    private JButton btonAceptar;
    private JButton btonCancelar;
    private JTextField campoNombre;
    private JTextField campoPrecio;
    private JTextField campoStock;
    private JLabel tituloRegistro;
    private JLabel labelStock;
    private JLabel labelNombre;
    private JLabel labelPrecio;
    private JLabel labelCategoria;
    private JLabel labelTexto;
    private JPanel panelRegistro;
    private JSeparator separadorInferior;
    private JSeparator separadorSuperior;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btonAceptar) {
            try {
                String name = campoNombre.getText();
                double precio = Double.parseDouble(campoPrecio.getText());
                String categoria = comboCategoria.getSelectedItem().toString();
                int stock = Integer.parseInt(campoStock.getText());

                ProductoVo producto = new ProductoVo(name, precio, categoria, stock);
                if(!(miCoordinador.validarProducto(producto).equals("ok"))) {
                    JOptionPane.showMessageDialog(this,
                            miCoordinador.validarProducto(producto),
                            "Error de Formato",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    miCoordinador.registrarProducto(producto);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Formato incorrecto en precio o stock.");
            }

            JOptionPane.showMessageDialog(this, "Producto registrado exitosamente.");
        }
        if (e.getSource() == btonCancelar) {
            dispose();
        }
    }

    public void setUsuarioDocumento(String usuarioDocumento) {
        this.usuarioDocumento = usuarioDocumento;
    }

    public void setUsuarioTipo(int usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    public void setPermissions() {
        if (usuarioTipo == 1) {
            //validaciones futuras
            System.out.println("tipo usuario");
        }
    }
}
