package Veterinaria_pak;
import javax.swing.JButton;
import javax.swing.JFrame;


public class VentanaAgregar_Modificar extends JFrame {
    public VentanaAgregar_Modificar(){
        this.setSize(500,500);
        this.setVisible(true);
        botones();
    }

    public void botones(){
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(100, 10, 20, 50);
        this.add(btnAceptar);
        JButton btnCancelar = new JButton("Cancelar");        
        btnCancelar.setBounds(10, 100, 20, 50);
        this.add(btnCancelar);
    }
}
