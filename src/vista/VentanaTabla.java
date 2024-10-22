package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelo.vo.UsuarioVo;
import controlador.Coordinador;

public class VentanaTabla extends JDialog implements ActionListener {

    private JLabel TituloConsulta;
    private JButton btonCancelar, btonConsultarActivos, btonConsultarDesactivados;
    private JTable tablaUsuarios;
    private JScrollPane scrollPane;
    private JPanel panelConsulta;
    private Coordinador miCoordinador;
    private  int usuarioTipo;
    private String usuarioDocumento;

    public VentanaTabla(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(710, 370);
        setResizable(false);
        setLocationRelativeTo(null);

        btonCancelar.addActionListener(this);
        btonConsultarActivos.addActionListener(this);
        btonConsultarDesactivados.addActionListener(this);
    }

    private void initComponents() {
        panelConsulta = new JPanel();
        TituloConsulta = new JLabel();
        tablaUsuarios = new JTable();
        scrollPane = new JScrollPane(tablaUsuarios);

        btonCancelar = new JButton("Cancelar");
        btonConsultarActivos = new JButton("Usuarios Activos");
        btonConsultarDesactivados = new JButton("Usuarios Inactivos");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelConsulta.setBackground(new java.awt.Color(204, 204, 204));
        panelConsulta.setLayout(null);

        TituloConsulta.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
        TituloConsulta.setHorizontalAlignment(SwingConstants.CENTER);
        TituloConsulta.setText("Consulta de Usuarios");
        TituloConsulta.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelConsulta.add(TituloConsulta);
        TituloConsulta.setBounds(20, 10, 660, 60);

        // Configurar la tabla y su scroll
        scrollPane.setBounds(20, 80, 660, 200);
        panelConsulta.add(scrollPane);

        // Botones
        btonConsultarActivos.setBounds(100, 300, 170, 30);
        panelConsulta.add(btonConsultarActivos);

        btonConsultarDesactivados.setBounds(300, 300, 170, 30);
        panelConsulta.add(btonConsultarDesactivados);

        btonCancelar.setBounds(500, 300, 170, 30);
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
        } else if (e.getSource() == btonConsultarActivos) {
            mostrarUsuariosActivos();
        } else if (e.getSource() == btonConsultarDesactivados) {
            mostrarUsuariosInactivos();
        }
    }

    private void mostrarUsuariosActivos() {
        List<UsuarioVo> listaUsuarios = miCoordinador.consultarUsuariosActivos();

        String[] columnas = {"Documento", "Nombre", "Profesión", "Dirección", "Teléfono", "Edad", "Tipo Usuario"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (UsuarioVo usuario : listaUsuarios) {
            String tipoUsuario = switch (usuario.getTipo()) {
                case 1 -> "Admin";
                case 2 -> "Usuario";
                case 3 -> "Secretaria";
                default -> "Desconocido";
            };

            Object[] fila = {
                    usuario.getDocumento(),
                    usuario.getNombre(),
                    usuario.getProfesion(),
                    usuario.getDireccion(),
                    usuario.getTelefono(),
                    usuario.getEdad(),
                    tipoUsuario
            };

            modeloTabla.addRow(fila);
        }

        tablaUsuarios.setModel(modeloTabla);
    }
    private void mostrarUsuariosInactivos() {
        List<UsuarioVo> listaUsuarios = miCoordinador.consultarUsuariosInactivos();

        String[] columnas = {"Documento", "Nombre", "Profesión", "Dirección", "Teléfono", "Edad", "Tipo Usuario"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (UsuarioVo usuario : listaUsuarios) {
            String tipoUsuario = switch (usuario.getTipo()) {
                case 1 -> "Admin";
                case 2 -> "Usuario";
                case 3 -> "Secretaria";
                default -> "Desconocido";
            };

            Object[] fila = {
                    usuario.getDocumento(),
                    usuario.getNombre(),
                    usuario.getProfesion(),
                    usuario.getDireccion(),
                    usuario.getTelefono(),
                    usuario.getEdad(),
                    tipoUsuario
            };

            modeloTabla.addRow(fila);
        }

        tablaUsuarios.setModel(modeloTabla);
    }

    public void setUsuarioDocumento(String documento) {
        this.usuarioDocumento = documento;
    }

    public void setUsuarioTipo(int usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    public void setPermissions() {
        if (usuarioTipo == 2 || usuarioTipo == 3) {
            btonConsultarDesactivados.setVisible(false);
        }
    }
}
