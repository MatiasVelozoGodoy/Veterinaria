package Veterinaria_pak;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame {
    HashSet<String> dnisRegistrados = new HashSet<>();
    private JTextField textoNombre;
    private JTextField textoApellido;
    private JTextField textoDNI;
    private JTextField textoNacionalidad;
    private JTextArea mostrar;

    public Ventana() {

        setResizable(false);
        setVisible(true);
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Veterinaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        botones();
        etiquetas();
        texto();
        mostrar();
    }

    public void botones() {
        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnDetalles = new JButton("Detalles");
        btnAgregar.setBounds(100, 500, 90, 40);
        btnAgregar.setFocusable(false);
        btnModificar.setBounds(210, 500, 90, 40);
        btnModificar.setFocusable(false);
        btnEliminar.setBounds(320, 500, 90, 40);
        btnEliminar.setFocusable(false);
        btnDetalles.setBounds(430, 500, 90, 40);
        btnDetalles.setFocusable(false);
        this.add(btnAgregar);
        this.add(btnModificar);
        this.add(btnEliminar);
        this.add(btnDetalles);
        btnAgregar.setBackground(Color.GREEN.darker());
        btnAgregar.setForeground(Color.WHITE);
        btnEliminar.setBackground(Color.RED.darker());
        btnEliminar.setForeground(Color.WHITE);
        btnDetalles.setBackground(Color.BLUE.darker());
        btnDetalles.setForeground(Color.WHITE);
        btnModificar.setBackground(Color.yellow.darker());
        btnModificar.setForeground(Color.WHITE);

        ActionListener agregarr = (ActionEvent e) -> {
            String dni = textoDNI.getText();
            if (!dnisRegistrados.contains(dni)) {
                dnisRegistrados.add(dni);
                mostrar.append("\n Nombre: " + textoNombre.getText() + "\n Apellido: " + textoApellido.getText()
                        + "\n DNI: " + dni + "\n Nacionalidad: " + textoNacionalidad.getText());
            }else{
                mostrar.append("El usuario que quieres agregar ya existe");
            }

        };
        btnAgregar.addActionListener(agregarr);

        ActionListener eliminarr = (ActionEvent e) -> {
            System.out.println("CUJAUUUUUUUUUUUU");
        };
        btnEliminar.addActionListener(eliminarr);

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
        this.add(textoDNI);
        textoNacionalidad = new JTextField();
        textoNacionalidad.setBounds(120, 140, 200, 20);
        this.add(textoNacionalidad);
    }

    public void mostrar() {
        mostrar = new JTextArea();
        mostrar.setBounds(40, 200, 500, 270);
        this.add(mostrar);
    }

}
