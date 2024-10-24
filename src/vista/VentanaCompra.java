package vista;

import controlador.Coordinador;
import modelo.vo.CompraVo;
import modelo.vo.ProductoVo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaCompra extends JDialog implements ActionListener {

    private JLabel TituloCompra;
    private JButton btonCancelar, btonConfirmarCompra, btonAgregarProducto;
    private JTable tablaProductos;
    private JScrollPane scrollPane;
    private JPanel panelCompra;
    private Coordinador miCoordinador;
    private ArrayList<ProductoVo> productosSeleccionados;
    private double totalCompra;
    private String usuarioDocumento;
    private int usuarioTipo;

    public VentanaCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(710, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        productosSeleccionados = new ArrayList<>();

        btonCancelar.addActionListener(this);
        btonConfirmarCompra.addActionListener(this);
        btonAgregarProducto.addActionListener(this);
    }

    private void initComponents() {
        panelCompra = new JPanel();
        TituloCompra = new JLabel();
        tablaProductos = new JTable();
        scrollPane = new JScrollPane(tablaProductos);
        btonCancelar = new JButton("Cancelar");
        btonConfirmarCompra = new JButton("Confirmar Compra");
        btonAgregarProducto = new JButton("Agregar Producto");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelCompra.setBackground(new java.awt.Color(204, 204, 204));
        panelCompra.setLayout(null);

        TituloCompra.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
        TituloCompra.setHorizontalAlignment(SwingConstants.CENTER);
        TituloCompra.setText("Realizar Compra");
        TituloCompra.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCompra.add(TituloCompra);
        TituloCompra.setBounds(20, 10, 660, 60);

        // Configurar la tabla y su scroll
        scrollPane.setBounds(20, 80, 660, 220);
        panelCompra.add(scrollPane);

        // Botones
        btonAgregarProducto.setBounds(20, 320, 170, 30);
        panelCompra.add(btonAgregarProducto);

        btonConfirmarCompra.setBounds(200, 320, 170, 30);
        panelCompra.add(btonConfirmarCompra);

        btonCancelar.setBounds(400, 320, 170, 30);
        panelCompra.add(btonCancelar);

        getContentPane().add(panelCompra);
        panelCompra.setBounds(0, 0, 710, 370);
        pack();
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    // Método para mostrar productos en la tabla
    public void mostrarProductos() {
        ArrayList<ProductoVo> listaProductos = miCoordinador.consultarTodosProductos();

        String[] columnas = {"ID", "Nombre", "Precio", "Stock"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (ProductoVo producto : listaProductos) {
            Object[] fila = {
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getStock()
            };
            modeloTabla.addRow(fila);
        }

        tablaProductos.setModel(modeloTabla);
    }

    // Método para confirmar la compra
    private void confirmarCompra() {
        totalCompra = 0; // Reinicia el total
        for (ProductoVo producto : productosSeleccionados) {
            totalCompra += producto.getPrecio(); // Calcula el total de la compra
            CompraVo newCompra = new CompraVo(usuarioDocumento, producto.getId(), producto.getPrecio());
            miCoordinador.registrarCompra(newCompra);
        }
        JOptionPane.showMessageDialog(this, "Compra confirmada! Total: $" + totalCompra);

        // Limpia la selección de productos y la lista
        limpiarSeleccionProductos();
        productosSeleccionados.clear();
    }

    // Método para limpiar la selección de la tabla
    private void limpiarSeleccionProductos() {
        tablaProductos.clearSelection(); // Deselecciona cualquier fila seleccionada
    }

    // Método para agregar el producto seleccionado
    private void agregarProductoSeleccionado() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener el ID del producto seleccionado
            int idProducto = (int) tablaProductos.getValueAt(filaSeleccionada, 0);

            ProductoVo producto = miCoordinador.consultarProducto(idProducto);
            if (producto != null) {

                if (!productosSeleccionados.contains(producto)) {
                    productosSeleccionados.add(producto);
                    JOptionPane.showMessageDialog(this, "Producto agregado: " + producto.getNombre());
                } else {
                    JOptionPane.showMessageDialog(this, "El producto ya está en la lista.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un producto.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btonCancelar) {
            dispose();
        } else if (e.getSource() == btonConfirmarCompra) {
            confirmarCompra();
        } else if (e.getSource() == btonAgregarProducto) {
            agregarProductoSeleccionado();
        }
    }

    public void setUsuarioDocumento(String usuarioDocumento) {
        this.usuarioDocumento = usuarioDocumento;
    }

    public void setUsuarioTipo(int usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
}
