package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import controlador.Coordinador;

public class VentanaLogin extends JDialog implements ActionListener {

    private javax.swing.JButton botonAceptar;
    private javax.swing.JPasswordField campoPass;
    private javax.swing.JTextField campoDoc;
    private javax.swing.JComboBox comboUsuarios;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelDoc;
    private javax.swing.JLabel labelUser;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JLabel tituloLogin;

    private Coordinador miCoordinador;

    public VentanaLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Login");
        setSize(275, 360);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Continuar", "Cerrar"};
                int n = JOptionPane.showOptionDialog(null,
                        "Seleccione un tipo de Usuario.\nSi sale el sistema se Cerrara", "Confirmación",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                if (n != JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void initComponents() {
        panelLogin = new javax.swing.JPanel();
        tituloLogin = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        labelDoc = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        comboUsuarios = new javax.swing.JComboBox();
        campoPass = new javax.swing.JPasswordField();
        campoDoc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        panelLogin.setBackground(new java.awt.Color(204, 204, 204));
        panelLogin.setLayout(null);

        tituloLogin.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
        tituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLogin.setText("Ventana Login");
        tituloLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLogin.add(tituloLogin);
        tituloLogin.setBounds(10, 0, 250, 60);

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/candado.png")));
        imagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelLogin.add(imagen);
        imagen.setBounds(10, 70, 250, 100);

        labelUser.setText("Usuario");
        panelLogin.add(labelUser);
        labelUser.setBounds(10, 190, 70, 20);

        labelPass.setText("Pass");
        panelLogin.add(labelPass);
        labelPass.setBounds(10, 250, 70, 20);
        labelPass.setVisible(false);

        labelDoc.setText("CC");
        panelLogin.add(labelDoc);
        labelDoc.setBounds(10, 220, 70, 20);
        labelDoc.setVisible(false);

        botonAceptar.setText("Aceptar");
        panelLogin.add(botonAceptar);
        botonAceptar.setBounds(85, 280, 110, 30);
        botonAceptar.addActionListener(this);

        comboUsuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione", "Administrador", "Usuario", "Secretaria"}));
        panelLogin.add(comboUsuarios);
        comboUsuarios.setBounds(70, 190, 190, 20);
        comboUsuarios.addActionListener(this);

        panelLogin.add(campoDoc);
        campoDoc.setBounds(70, 220, 190, 20);
        campoDoc.setVisible(false);

        panelLogin.add(campoPass);
        campoPass.setBounds(70, 250, 190, 20);
        campoPass.setVisible(false);

        getContentPane().add(panelLogin);
        panelLogin.setBounds(0, 0, 270, 400);

        pack();
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == comboUsuarios) {
            mostrarElementos();
        }

        if (evento.getSource() == botonAceptar) {
            ArrayList<String> resp = miCoordinador.validarIngreso(comboUsuarios.getSelectedIndex(), campoDoc.getText(), campoPass.getText());

            if (resp.getFirst().equals("error")) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado un usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                if (resp.getFirst().equals("invalido")) {
                    JOptionPane.showMessageDialog(null, "El pass no corresponde", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (resp.getFirst().equals("desconectado")) {
                        JOptionPane.showMessageDialog(null, "No se pudo conectar a la BD, verifique que se encuentre en línea", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                    } else {
                        miCoordinador.asignarPrivilegios(resp);
                        miCoordinador.cerrarVentanaLogin();
                    }
                }
            }
        }
    }

    public void limpiar() {
        comboUsuarios.setSelectedIndex(0);
        campoPass.setText("");
        campoDoc.setText("");
    }

    private void mostrarElementos() {
        int index = comboUsuarios.getSelectedIndex();
        boolean visible = index != 0;

        labelPass.setVisible(visible);
        labelDoc.setVisible(visible);
        campoPass.setVisible(visible);
        campoDoc.setVisible(visible);
    }
}
