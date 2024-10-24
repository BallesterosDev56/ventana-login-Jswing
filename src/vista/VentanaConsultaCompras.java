package vista;

import controlador.Coordinador;
import modelo.vo.CompraVo;
import modelo.vo.UsuarioVo;
import modelo.vo.ProductoVo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaConsultaCompras extends JDialog implements ActionListener {

    private JLabel tituloCompras;
    private JButton botonCancelar;
    private JTable tablaCompras;
    private JScrollPane scrollPane;
    private JPanel panelCompras;
    private Coordinador miCoordinador;
    private String usuarioDocumento;
    private int usuarioTipo;

    public VentanaConsultaCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(710, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        panelCompras = new JPanel();
        tituloCompras = new JLabel();
        tablaCompras = new JTable();
        scrollPane = new JScrollPane(tablaCompras);
        botonCancelar = new JButton("Cancelar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelCompras.setBackground(new java.awt.Color(204, 204, 204));
        panelCompras.setLayout(null);

        tituloCompras.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
        tituloCompras.setHorizontalAlignment(SwingConstants.CENTER);
        tituloCompras.setText("Compras Realizadas");
        tituloCompras.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCompras.add(tituloCompras);
        tituloCompras.setBounds(20, 10, 660, 60);

        // Configurar la tabla y su scroll
        scrollPane.setBounds(20, 80, 660, 220);
        panelCompras.add(scrollPane);

        // Botón
        botonCancelar.setBounds(400, 320, 170, 30);
        panelCompras.add(botonCancelar);

        getContentPane().add(panelCompras);
        panelCompras.setBounds(0, 0, 710, 370);
        pack();

        botonCancelar.addActionListener(this);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    // Método para mostrar las compras realizadas por un usuario específico
    public void mostrarComprasUsuario() {
        if (usuarioDocumento == null || usuarioDocumento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El documento del usuario no está definido.");
            return;
        }

        ArrayList<CompraVo> listaCompras = miCoordinador.consultarCompras(usuarioDocumento);
        String[] columnas = {"Usuario", "Producto", "Precio"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (CompraVo compra : listaCompras) {
            ProductoVo producto = miCoordinador.consultarProducto(compra.getIdProducto());
            UsuarioVo usuario = miCoordinador.consultarUsuario(compra.getDocumentoUsuario(), null);

            Object[] fila = {
                    usuario != null ? usuario.getNombre() : "Usuario desconocido",
                    producto != null ? producto.getNombre() : "Producto desconocido",
                    compra.getPrecio()
            };
            modeloTabla.addRow(fila);
        }

        tablaCompras.setModel(modeloTabla);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCancelar) {
            dispose();
        }
    }

    public void setUsuarioDocumento(String usuarioDocumento) {
        this.usuarioDocumento = usuarioDocumento;
    }

    public void setUsuarioTipo(int usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
}
