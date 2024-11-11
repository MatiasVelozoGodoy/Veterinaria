package Veterinaria_pak;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
    HashSet<String> dnisRegistrados = new HashSet<>();
    private JScrollPane scroll;
    private JTable table;
    public DefaultTableModel dtm;
    private JPanel panel1;

    public VentanaPrincipal() {

        setResizable(false);
        setVisible(true);
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Veterinaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        paneles();
        botones();
        tabla();
    }

    private void botones() {
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
        panel1.add(btnAgregar);
        panel1.add(btnModificar);
        panel1.add(btnEliminar);
        panel1.add(btnDetalles);
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
                String dni = (String) dtm.getValueAt(fila, 0);

                dtm.removeRow(fila);
                if (dnisRegistrados.contains(dni)) {
                    dnisRegistrados.remove(dni);
                }
            }
        };
        btnEliminar.addActionListener(eliminarr);

    }

    private void tabla() {
        String[] columnas = { "DNI", "NOMBRE", "APELLIDO", "NACIONALIDAD" };

        dtm = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(dtm);
        table.setOpaque(false);
        table.setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);
        table.setForeground(new Color(220, 220, 220));

        scroll = new JScrollPane(table);
        table.setModel(dtm);
        scroll.setBounds(40, 40, 500, 400);
        scroll.setOpaque(false); 
        scroll.getViewport().setOpaque(false);

        panel1.add(scroll);

    }

    private void paneles() {
        panel1 = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                // Crear el degradado desde el color inicial hasta el color final
                GradientPaint gradient = new GradientPaint(0, 0, new Color(39, 70, 90), 0, height,
                        new Color(17, 25, 27));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };

        panel1.setSize(600, 600);
        this.getContentPane().add(panel1);
    }

}
