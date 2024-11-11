package Veterinaria_pak;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class VentanaAgregar_Modificar extends JFrame {
    private HashSet<String> dnisRegistrados = new HashSet<>();
    private JTextField textoRaza;
    private JComboBox tipoMascota;
    private JTextField textoNombreD;
    private JTextField textoDuenio;
    private JTextField textoNombreM;
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
        comboBox();
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
            // if (textoDNI.getText().isEmpty() || textoNombreD.getText().isEmpty() || textoApellido.getText().isEmpty()
            //         || textoNacionalidad.getText().isEmpty()) {
            //     if(textoNombreD.getText().isEmpty()){
            //         textoNombreD.setBackground(Color.PINK);
            //         nombreCheck.setVisible(true);
            //         verificarTexto(textoNombreD, nombreCheck);
            //     }
            //     if(textoApellido.getText().isEmpty()){
            //         textoApellido.setBackground(Color.PINK);
            //         apellidoCheck.setVisible(true);
            //         verificarTexto(textoApellido, apellidoCheck);
            //     }
            //     if(textoDNI.getText().isEmpty()){
            //         textoDNI.setBackground(Color.PINK);
            //         DNICheck.setVisible(true);
            //         verificarTexto(textoDNI, DNICheck);
                    
            //     }
            //     if(textoNacionalidad.getText().isEmpty()){
            //         textoNacionalidad.setBackground(Color.PINK);
            //         nacionalidadCheck.setVisible(true);
            //         verificarTexto(textoNacionalidad, nacionalidadCheck);
            //     }
            //     JOptionPane.showMessageDialog(null, "Hay campos que faltan rellenar", "Error",
            //             JOptionPane.WARNING_MESSAGE);
            // } else {
                // String dni = textoDNI.getText();
                // if (!dnisRegistrados.contains(dni)) {
                //     dnisRegistrados.add(dni);
                    DefaultTableModel dtm = new DefaultTableModel();
                    ventanaPrincipal.dtm.addRow(new Object[] { textoNombreM.getText(), textoRaza.getText(), tipoMascota.getSelectedItem().toString(),
                            textoDuenio.getText()
                    });
                    // textoDNI.setText("");
                    // textoNombreD.setText("");
                    // textoApellido.setText("");
                    // textoNacionalidad.setText("");
                    // textoNombreD.requestFocusInWindow();
                // }

                // else {
                    JOptionPane.showMessageDialog(null, "Este persona ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                // }
            // }
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

        JLabel apellido = new JLabel("Raza:");
        apellido.setBounds(40, 40, 100, 100);

        JLabel DNI = new JLabel("Mascota:");
        DNI.setBounds(40, 70, 100, 100);

        JLabel nacionalidad = new JLabel("Dueño:");
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
        textoNombreM = new JTextField();
        textoNombreM.setBounds(120, 50, 200, 20);
        this.add(textoNombreM);

        textoRaza = new JTextField();
        textoRaza.setBounds(120, 80, 200, 20);
        this.add(textoRaza);

        // textoMascota = new JTextField();
        // textoMascota.setBounds(120, 110, 200, 20);
        // textoMascota.setToolTipText("Solo numeros");
        // this.add(textoMascota);

        textoDuenio = new JTextField();
        textoDuenio.setBounds(120, 140, 200, 20);
        this.add(textoDuenio);
    }
    public void verificarTexto(JTextField texto, JLabel checker){
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
                    checker.setVisible(false);
                }
            }            
        });

        
    }
    private void comboBox(){
        String[] mascotas =  {"Perro", "Gato"};
        tipoMascota = new JComboBox(mascotas);
        tipoMascota.setBounds(120, 110, 200, 20);
        this.add(tipoMascota);

    }

}