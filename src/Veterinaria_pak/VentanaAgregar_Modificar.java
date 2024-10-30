package Veterinaria_pak;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaAgregar_Modificar extends JFrame {

    HashSet<String> dnisRegistrados = new HashSet<>();
    private JTextField textoNombre;
    private JTextField textoApellido;
    private JTextField textoDNI;
    private JTextField textoNacionalidad;
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregar_Modificar(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        setSize(500, 500);
        setLayout(null);
        setVisible(true);
        setTitle("Agregar");

        botones();
        etiquetas();
        texto();
    }

    public void botones() {
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(100, 400, 90, 30);
        this.add(btnAceptar);
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 400, 90, 30);
        this.add(btnCancelar);

        ActionListener cancelar = (ActionEvent e) -> {
            dispose();
        };
        btnCancelar.addActionListener(cancelar);
        ActionListener aceptar = (ActionEvent e) -> {
            if (textoDNI.getText().isEmpty() || textoNombre.getText().isEmpty() || textoApellido.getText().isEmpty()
                    || textoNacionalidad.getText().isEmpty()) {
                if(textoNombre.getText().isEmpty())
                    textoNombre.setBackground(Color.PINK);
                if(textoApellido.getText().isEmpty())
                    textoApellido.setBackground(Color.PINK);
                if(textoDNI.getText().isEmpty())
                    textoDNI.setBackground(Color.PINK);
                if(textoNacionalidad.getText().isEmpty())
                    textoNacionalidad.setBackground(Color.PINK);
                JOptionPane.showMessageDialog(null, "Hay campos que faltan rellenar", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String dni = textoDNI.getText();
                if (!dnisRegistrados.contains(dni)) {
                    dnisRegistrados.add(dni);
                    DefaultTableModel dtm = new DefaultTableModel();
                    ventanaPrincipal.dtm.addRow(new Object[] { textoDNI.getText(), textoNombre.getText(), textoApellido.getText(),
                            textoNacionalidad.getText()
                    });
                    textoDNI.setText("");
                    textoNombre.setText("");
                    textoApellido.setText("");
                    textoNacionalidad.setText("");
                    textoNombre.requestFocusInWindow();
                }

                else {
                    JOptionPane.showMessageDialog(null, "Este persona ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        btnAceptar.addActionListener(aceptar);
    }

    public void etiquetas() {
        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(40, 10, 100, 100);
        JLabel apellido = new JLabel("Apellido:");
        apellido.setBounds(40, 40, 100, 100);
        JLabel DNI = new JLabel("DNI:");
        DNI.setBounds(40, 70, 100, 100);
        JLabel nacionalidad = new JLabel("Nacionalidad:");
        nacionalidad.setBounds(40, 100, 100, 100);
        this.add(nombre);
        this.add(apellido);
        this.add(DNI);
        this.add(nacionalidad);
    }

    public void texto() {
        textoNombre = new JTextField();
        textoNombre.setBounds(120, 50, 200, 20);
        this.add(textoNombre);
        textoApellido = new JTextField();
        textoApellido.setBounds(120, 80, 200, 20);
        this.add(textoApellido);
        textoDNI = new JTextField();
        textoDNI.setBounds(120, 110, 200, 20);
        textoDNI.setToolTipText("Solo numeros");
        this.add(textoDNI);
        textoNacionalidad = new JTextField();
        textoNacionalidad.setBounds(120, 140, 200, 20);
        this.add(textoNacionalidad);
    }
}