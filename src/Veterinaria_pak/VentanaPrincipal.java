package Veterinaria_pak;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VentanaPrincipal extends JFrame {
    HashSet<String> dnisRegistrados = new HashSet<>();
    private JScrollPane scroll;
    private JTable table;
    public DefaultTableModel dtm;


    public VentanaPrincipal() {

        setResizable(false);
        setVisible(true);
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Veterinaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        botones();
        tabla();
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
            VentanaAgregar_Modificar ventana = new VentanaAgregar_Modificar(this);
        };
        btnAgregar.addActionListener(agregarr);

        ActionListener eliminarr = (ActionEvent e) -> {
            int fila = table.getSelectedRow();

            if (fila != -1) {
                String dni = (String)dtm.getValueAt(fila, 0);
                
                dtm.removeRow(fila);
                if (dnisRegistrados.contains(dni)) {
                    dnisRegistrados.remove(dni);
                }
            }
        };
        btnEliminar.addActionListener(eliminarr);
    
    }

    public void tabla(){
        String[] columnas = {"DNI", "NOMBRE", "APELLIDO", "NACIONALIDAD"};



        
        dtm = new DefaultTableModel(columnas,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table = new JTable(dtm);        
        scroll = new JScrollPane(table);
        table.setModel(dtm);
        scroll.setBounds(40, 200, 500, 270);
        this.add(scroll);

    }
}


