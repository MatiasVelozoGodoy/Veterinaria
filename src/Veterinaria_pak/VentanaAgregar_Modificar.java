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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class VentanaAgregar_Modificar extends JFrame {

    HashSet<String> dnisRegistrados = new HashSet<>();
    private JTextField textoNombre;
    private JTextField textoApellido;
    private JTextField textoDNI;
    private JTextField textoNacionalidad;
    private VentanaPrincipal ventanaPrincipal;
    private JLabel nombreCheck;
    private JLabel apellidoCheck;
    private JLabel DNICheck;
    private JLabel nacionalidadCheck;

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
                if(textoNombre.getText().isEmpty()){
                    textoNombre.setBackground(Color.PINK);
                    nombreCheck.setVisible(true);
                    verificarTexto(textoNombre, nombreCheck);
                }
                if(textoApellido.getText().isEmpty()){
                    textoApellido.setBackground(Color.PINK);
                    apellidoCheck.setVisible(true);
                    verificarTexto(textoApellido, apellidoCheck);
                }
                if(textoDNI.getText().isEmpty()){
                    textoDNI.setBackground(Color.PINK);
                    DNICheck.setVisible(true);
                    verificarTexto(textoDNI, DNICheck);
                    
                }
                if(textoNacionalidad.getText().isEmpty()){
                    textoNacionalidad.setBackground(Color.PINK);
                    nacionalidadCheck.setVisible(true);
                    verificarTexto(textoNacionalidad, nacionalidadCheck);
                }
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
        nombreCheck = new JLabel("*");
        nombreCheck.setBounds(330, 10, 100, 100);
        nombreCheck.setVisible(false);
        nombreCheck.setForeground(Color.RED);

        apellidoCheck = new JLabel("*");
        apellidoCheck.setBounds(330, 40, 100, 100);
        apellidoCheck.setVisible(false);
        apellidoCheck.setForeground(Color.RED);

        DNICheck = new JLabel("*");
        DNICheck.setBounds(330, 70, 100, 100);
        DNICheck.setVisible(false);
        DNICheck.setForeground(Color.RED);

        nacionalidadCheck = new JLabel("*");
        nacionalidadCheck.setBounds(330, 100, 100, 100);
        nacionalidadCheck.setVisible(false);
        nacionalidadCheck.setForeground(Color.RED);



        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(40, 10, 100, 100);

        JLabel apellido = new JLabel("Apellido:");
        apellido.setBounds(40, 40, 100, 100);

        JLabel DNI = new JLabel("DNI:");
        DNI.setBounds(40, 70, 100, 100);

        JLabel nacionalidad = new JLabel("Nacionalidad:");
        nacionalidad.setBounds(40, 100, 100, 100);

        this.add(nombre);
        this.add(nombreCheck);
        this.add(apellido);
        this.add(apellidoCheck);
        this.add(DNI);
        this.add(DNICheck);
        this.add(nacionalidad);
        this.add(nacionalidadCheck);
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
    public void verificarTexto(JTextField texto, JLabel check){
        texto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificar();
            }


            private void verificar() {
                if (!texto.getText().isEmpty()) {
                    texto.setBackground(Color.WHITE);
                    check.setVisible(false);
                }
            }
            
        });

    }

}