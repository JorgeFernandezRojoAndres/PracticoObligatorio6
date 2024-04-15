import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ConsultaPorNombreFrame extends JInternalFrame {
    private final JTextField buscarTextField;
    private final JTable productoTable;
    private final DefaultTableModel tableModel;
    private final ArrayList<Producto> listaProductos;

    public ConsultaPorNombreFrame(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;

        setTitle("Listado por Nombre");
        setSize(800, 600);

        // Crear el panel principal
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Listado por Nombre");        
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Crear el panel para el campo de búsqueda
        
        
        JLabel buscarLabel = new JLabel("Escriba los primeros caracteres:");
        JPanel buscarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buscarTextField = new JTextField(20);
        buscarPanel.add(buscarLabel);
        buscarPanel.add(buscarTextField);
        panel.add(buscarPanel, BorderLayout.CENTER);
        
        
        

        // Crear la tabla de productos
        String[] columnNames = {"Código", "Descripción", "Precio", "Stock"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productoTable);
        panel.add(scrollPane, BorderLayout.SOUTH);

        // Añadir el panel al JInternalFrame
        add(panel);

        // ActionListener para el campo de búsqueda
        buscarTextField.addActionListener(e -> actualizarTabla());
    }

    private void actualizarTabla() {
        try {
            tableModel.setRowCount(0);
            String textoBusqueda = buscarTextField.getText().toLowerCase();
            if (listaProductos != null) {
                for (Producto producto : listaProductos) {
                    if (producto.getDescripcion().toLowerCase().startsWith(textoBusqueda)) {
                        Object[] rowData = {producto.getCodigo(), producto.getDescripcion(), producto.getPrecio(), producto.getStock()};
                        tableModel.addRow(rowData);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "La lista de productos es nula.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
