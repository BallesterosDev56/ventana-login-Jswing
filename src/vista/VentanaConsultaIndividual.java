package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

import modelo.vo.UsuarioVo;
import controlador.Coordinador;

public class VentanaConsultaIndividual extends JDialog implements ActionListener {

    private JLabel LabelDireccion, TituloConsulta, labelDocumento, labelEdad, labelNombre, labelProfesion, labelTelefono, labelTexto, labelTipoUsuario;
    private JButton btonCancelar, btonConsultar, btonActualizar, btonEliminar;
    private JTextField campoTelefono, campoDireccion, campoConsultaDocumento, campoDocumento, campoEdad, campoNombre, campoProfesion, campoTipoUsuario;
    private javax.swing.JPanel panelConsulta;
    private javax.swing.JSeparator separadorInferior, separadorSuperior;
    private Coordinador miCoordinador;
    private  int usuarioTipo;
    private String usuarioDocumento;

    public VentanaConsultaIndividual(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(710, 370);
        setResizable(false);
        setLocationRelativeTo(null);

        btonCancelar.addActionListener(this);
        btonConsultar.addActionListener(this);
        btonActualizar.addActionListener(this);
        btonEliminar.addActionListener(this);
    }
    private JComboBox<String> comboTipoUsuario;

    @SuppressWarnings("unchecked")
    private void initComponents() {
        panelConsulta = new JPanel();
        TituloConsulta = new JLabel();
        labelProfesion = new JLabel();
        labelTelefono = new JLabel();
        labelTexto = new JLabel();
        labelDocumento = new JLabel();
        labelEdad = new JLabel();
        LabelDireccion = new JLabel();
        labelNombre = new JLabel();
        labelTipoUsuario = new JLabel();
        separadorInferior = new JSeparator();
        separadorSuperior = new JSeparator();

        campoNombre = new JTextField();
        campoDireccion = new JTextField();
        campoTelefono = new JTextField();
        campoProfesion = new JTextField();
        campoConsultaDocumento = new JTextField();
        campoEdad = new JTextField();
        campoDocumento = new JTextField();

        // Inicializamos el JComboBox con las opciones
        comboTipoUsuario = new JComboBox<>(new String[]{"Admin", "Usuario", "Secretaria"});

        btonCancelar = new JButton();
        btonConsultar = new JButton();
        btonActualizar = new JButton();
        btonEliminar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelConsulta.setBackground(new java.awt.Color(204, 204, 204));
        panelConsulta.setLayout(null);

        TituloConsulta.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
        TituloConsulta.setHorizontalAlignment(SwingConstants.CENTER);
        TituloConsulta.setText("Consultar Usuario");
        TituloConsulta.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelConsulta.add(TituloConsulta);
        TituloConsulta.setBounds(20, 10, 660, 60);

        labelProfesion.setFont(new java.awt.Font("Verdana", 0, 12));
        labelProfesion.setHorizontalAlignment(SwingConstants.RIGHT);
        labelProfesion.setText("Profesión:");
        panelConsulta.add(labelProfesion);
        labelProfesion.setBounds(0, 170, 90, 20);

        labelTelefono.setFont(new java.awt.Font("Verdana", 0, 12));
        labelTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTelefono.setText("Teléfono:");
        panelConsulta.add(labelTelefono);
        labelTelefono.setBounds(400, 200, 100, 20);

        labelTexto.setFont(new java.awt.Font("Verdana", 1, 14));
        labelTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTexto.setText("Ingrese el documento del usuario a consultar");
        panelConsulta.add(labelTexto);
        labelTexto.setBounds(0, 90, 380, 20);

        labelDocumento.setFont(new java.awt.Font("Verdana", 0, 12));
        labelDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
        labelDocumento.setText("*Documento:");
        panelConsulta.add(labelDocumento);
        labelDocumento.setBounds(400, 140, 100, 20);

        labelEdad.setFont(new java.awt.Font("Verdana", 0, 12));
        labelEdad.setHorizontalAlignment(SwingConstants.RIGHT);
        labelEdad.setText("Edad:");
        panelConsulta.add(labelEdad);
        labelEdad.setBounds(400, 170, 100, 20);

        LabelDireccion.setFont(new java.awt.Font("Verdana", 0, 12));
        LabelDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
        LabelDireccion.setText("Dirección:");
        panelConsulta.add(LabelDireccion);
        LabelDireccion.setBounds(0, 200, 90, 20);

        labelNombre.setFont(new java.awt.Font("Verdana", 0, 12));
        labelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNombre.setText("*Nombre:");
        panelConsulta.add(labelNombre);
        labelNombre.setBounds(0, 140, 90, 20);

        labelTipoUsuario.setFont(new java.awt.Font("Verdana", 0, 12));
        labelTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTipoUsuario.setText("Tipo Usuario:");
        panelConsulta.add(labelTipoUsuario);
        labelTipoUsuario.setBounds(0, 230, 90, 20);

        panelConsulta.add(separadorInferior);
        separadorInferior.setBounds(20, 270, 660, 10);

        panelConsulta.add(campoNombre);
        campoNombre.setBounds(100, 140, 300, 20);

        panelConsulta.add(campoDireccion);
        campoDireccion.setBounds(100, 200, 300, 20);

        panelConsulta.add(campoTelefono);
        campoTelefono.setBounds(510, 200, 170, 20);

        panelConsulta.add(campoProfesion);
        campoProfesion.setBounds(100, 170, 300, 20);

        panelConsulta.add(campoConsultaDocumento);
        campoConsultaDocumento.setBounds(390, 90, 120, 20);

        panelConsulta.add(campoEdad);
        campoEdad.setBounds(510, 170, 170, 20);

        panelConsulta.add(campoDocumento);
        campoDocumento.setBounds(510, 140, 170, 20);


        panelConsulta.add(comboTipoUsuario);
        comboTipoUsuario.setBounds(100, 230, 300, 20);

        panelConsulta.add(separadorSuperior);
        separadorSuperior.setBounds(20, 120, 660, 10);

        btonCancelar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonCancelar.setText("Cancelar");
        panelConsulta.add(btonCancelar);
        btonCancelar.setBounds(510, 290, 170, 30);

        btonConsultar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonConsultar.setText("Buscar");
        panelConsulta.add(btonConsultar);
        btonConsultar.setBounds(520, 90, 110, 20);

        btonActualizar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonActualizar.setText("Actualizar");
        panelConsulta.add(btonActualizar);
        btonActualizar.setBounds(110, 290, 170, 30);

        btonEliminar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonEliminar.setText("Eliminar");
        panelConsulta.add(btonEliminar);
        btonEliminar.setBounds(310, 290, 170, 30);

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
            limpiarVentana();
            dispose();
        } else if (e.getSource() == btonConsultar) {
            consultarUsuario();
        } else if (e.getSource() == btonActualizar) {
            actualizaUsuario();
        } else if (e.getSource() == btonEliminar) {
            eliminaUsuario();
        }
    }

    private void limpiarVentana() {
        campoConsultaDocumento.setText("");
        campoNombre.setText("");
        campoDocumento.setText("");
        campoProfesion.setText("");
        campoDireccion.setText("");
        campoTelefono.setText("");
        campoEdad.setText("");
        comboTipoUsuario.setSelectedIndex(0);
    }

    private void consultarUsuario() {
        UsuarioVo usuarioVO;

        if(usuarioTipo == 1) {
            usuarioVO = miCoordinador.consultarUsuarioAll(campoConsultaDocumento.getText().trim(), null);
        } else {
            usuarioVO = miCoordinador.consultarUsuario(campoConsultaDocumento.getText().trim(), null);
        }

        if (usuarioVO.getDocumento() != null) {
            campoNombre.setText(usuarioVO.getNombre());
            campoDocumento.setText(usuarioVO.getDocumento());
            campoProfesion.setText(usuarioVO.getProfesion());
            campoDireccion.setText(usuarioVO.getDireccion());
            campoTelefono.setText(usuarioVO.getTelefono());
            campoEdad.setText(String.valueOf(usuarioVO.getEdad()));
            switch (usuarioVO.getTipo()) {
                case 1:
                    comboTipoUsuario.setSelectedItem("Admin");
                    break;
                case 2:
                    comboTipoUsuario.setSelectedItem("Usuario");
                    break;
                case 3:
                    comboTipoUsuario.setSelectedItem("Secretaria");
                    break;
                default:
                    comboTipoUsuario.setSelectedItem("undefined");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en el sistema", "Datos Inexistentes", JOptionPane.WARNING_MESSAGE);
        }
    }


    private void actualizaUsuario() {
        String res = "";

        int tipoUsuario = 0;
        switch (comboTipoUsuario.getSelectedItem().toString()) {
            case "Admin":
                tipoUsuario = 1;
                break;
            case "Usuario":
                tipoUsuario = 2;
                break;
            case "Secretaria":
                tipoUsuario = 3;
                break;
        }

        UsuarioVo usuario = new UsuarioVo();
        usuario.setDocumento(campoDocumento.getText());
        usuario.setNombre(campoNombre.getText());
        usuario.setProfesion(campoProfesion.getText());
        usuario.setDireccion(campoDireccion.getText());
        usuario.setTelefono(campoTelefono.getText());
        usuario.setEdad(Integer.parseInt(campoEdad.getText()));
        usuario.setTipo(tipoUsuario);

        if(usuarioTipo == 2 || usuarioTipo == 3) {

            if (verifySameDocument(campoDocumento.getText(), usuarioDocumento)) {
                res = miCoordinador.actualizaUsuario(usuario);
            } else {
                JOptionPane.showMessageDialog(null, "Solo puedes moficar tu propio perfil", "Error de permisos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            res = miCoordinador.actualizaUsuario(usuario);
        }

        if (Objects.equals(res, "ok")) {
            JOptionPane.showMessageDialog(null, "Actualización realizada", "Usuario actualizado!!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private boolean verifySameDocument(String labelDoc, String userDoc) {return Objects.equals(labelDoc, userDoc);}

    private void eliminaUsuario() {
        String res = "";
        String documento = campoDocumento.getText();

        if(usuarioTipo == 2 || usuarioTipo == 3) {

            if (verifySameDocument(campoDocumento.getText(), usuarioDocumento)) {
                res = miCoordinador.eliminarUsuario(documento);
            } else {
                JOptionPane.showMessageDialog(null, "Solo puedes eliminar tu propio perfil", "Error de permisos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            res = miCoordinador.eliminarUsuario(documento);
        }
        if ((!Objects.equals(res, "error"))) {
            JOptionPane.showMessageDialog(null, "Eliminación realizada", "Usuario eliminado!!", JOptionPane.INFORMATION_MESSAGE);
        }
        limpiarVentana();
    }

    public void setUsuarioDocumento(String documento) {
        this.usuarioDocumento = documento;
    }

    public void setUsuarioTipo(int usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
}