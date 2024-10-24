package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelo.vo.ProductoVo;  // Asegúrate de que este paquete y clase existen
import controlador.Coordinador;

public class VentanaTablaProductos extends JDialog implements ActionListener {

    private JLabel TituloConsulta;
    private JButton btonCancelar, btonConsultarTodos;
    private JTable tablaProductos;
    private JScrollPane scrollPane;
    private JPanel panelConsulta;
    private Coordinador miCoordinador;

    public VentanaTablaProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(710, 370);
        setResizable(false);
        setLocationRelativeTo(null);

        btonCancelar.addActionListener(this);
        btonConsultarTodos.addActionListener(this);
    }

    private void initComponents() {
        panelConsulta = new JPanel();
        TituloConsulta = new JLabel();
        tablaProductos = new JTable();
        scrollPane = new JScrollPane(tablaProductos);

        btonCancelar = new JButton("Cancelar");
        btonConsultarTodos = new JButton("Consultar Todos los Productos");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelConsulta.setBackground(new java.awt.Color(204, 204, 204));
        panelConsulta.setLayout(null);

        TituloConsulta.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
        TituloConsulta.setHorizontalAlignment(SwingConstants.CENTER);
        TituloConsulta.setText("Consulta de Productos");
        TituloConsulta.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelConsulta.add(TituloConsulta);
        TituloConsulta.setBounds(20, 10, 660, 60);

        // Configurar la tabla y su scroll
        scrollPane.setBounds(20, 80, 660, 200);
        panelConsulta.add(scrollPane);

        // Botones
        btonConsultarTodos.setBounds(100, 300, 250, 30);
        panelConsulta.add(btonConsultarTodos);

        btonCancelar.setBounds(400, 300, 170, 30);
        panelConsulta.add(btonCancelar);

        getContentPane().add(panelConsulta);
        panelConsulta.setBounds(0, 0, 710, 330);
        pack();
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btonCancelar) {
            dispose();
        } else if (e.getSource() == btonConsultarTodos) {
            mostrarTodosLosProductos();
        }
    }

    private void mostrarTodosLosProductos() {
        List<ProductoVo> listaProductos = miCoordinador.consultarTodosProductos();

        String[] columnas = {"Nombre", "Precio", "Categoría", "Stock"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (ProductoVo producto : listaProductos) {
            Object[] fila = {
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getCategoria(),
                    producto.getStock()
            };

            modeloTabla.addRow(fila);
        }

        tablaProductos.setModel(modeloTabla);
    }
}
