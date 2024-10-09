package Veterinaria_pak;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
// import javax.swing.JTextArea;

public class Ventana extends JFrame{
    public Ventana(){


        this.setVisible(true);
        this.setSize(600,600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Veterinaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        botones();
        etiquetas();
        texto();
        mostrar();
    }

    public void botones(){
        JButton boton = new JButton("Agregar");
        JButton boton2 = new JButton("Modificar");
        JButton boton3 = new JButton("Eliminar");
        JButton boton4 = new JButton("Detalles");
        boton.setBounds(100,500,90,40);
        boton.setFocusable(false);
        boton2.setBounds(210,500,90,40);
        boton2.setFocusable(false);
        boton3.setBounds(320,500,90,40);
        boton3.setFocusable(false);
        boton4.setBounds(430,500,90,40);
        boton4.setFocusable(false);
        this.add(boton);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);

    }

    public void etiquetas(){
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
    public void texto(){
        JTextField textoNombre = new JTextField();
        textoNombre.setBounds(120, 50, 200, 20);
        this.add(textoNombre);
        JTextField textoApellido = new JTextField();
        textoApellido.setBounds(120, 80, 200, 20);
        this.add(textoApellido);
        JTextField textoDNI = new JTextField();
        textoDNI.setBounds(120, 110, 200, 20);
        this.add(textoDNI);
        JTextField textoNacionalidad = new JTextField();
        textoNacionalidad.setBounds(120, 140, 200, 20);
        this.add(textoNacionalidad);
    }

    public void mostrar(){
        JTextArea mostrar = new JTextArea();
        mostrar.setBounds(40, 200, 500, 270);
        this.add(mostrar);
    }

}
