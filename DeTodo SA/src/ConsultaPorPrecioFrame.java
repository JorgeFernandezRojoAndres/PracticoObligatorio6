import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ConsultaPorPrecioFrame extends JInternalFrame {
    private final JTextField precioMinTextField;
    private final JTextField precioMaxTextField;
    private final JTable productoTable;
    private final DefaultTableModel tableModel;
    private final ArrayList<Producto> listaProductos;

    public ConsultaPorPrecioFrame(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;

        setTitle("Listado Por Precio");
        setSize(800, 600);

        // Crear el panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Crear el título
        JLabel titleLabel = new JLabel("Listado Por Precio");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Crear el panel para los campos de búsqueda por precio
        JPanel buscarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JLabel precioMinLabel = new JLabel("Entre $");
        precioMinTextField = new JTextField(20);
        
        JLabel precioMaxLabel = new JLabel("y");
        precioMaxTextField = new JTextField(20);
        
        buscarPanel.add(precioMinLabel);
        buscarPanel.add(precioMinTextField);
        buscarPanel.add(precioMaxLabel);
        buscarPanel.add(precioMaxTextField);
        
        panel.add(buscarPanel, BorderLayout.CENTER);

        // Crear la tabla de productos
        String[] columnNames = {"Código", "Descripción", "Precio", "Stock"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productoTable);
        panel.add(scrollPane, BorderLayout.SOUTH);

        // Añadir el panel al JInternalFrame
        add(panel);

        // ActionListener para los campos de búsqueda por precio
        precioMinTextField.addActionListener(e -> actualizarTabla());
        precioMaxTextField.addActionListener(e -> actualizarTabla());
    }

    private void actualizarTabla() {
        try {
            tableModel.setRowCount(0);
            double precioMin = Double.parseDouble(precioMinTextField.getText());
            double precioMax = Double.parseDouble(precioMaxTextField.getText());
            
            if (listaProductos != null) {
                for (Producto producto : listaProductos) {
                    double precioProducto = producto.getPrecio();
                    if (precioProducto >= precioMin && precioProducto <= precioMax) {
                        Object[] rowData = {producto.getCodigo(), producto.getDescripcion(), precioProducto, producto.getStock()};
                        tableModel.addRow(rowData);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "La lista de productos es nula.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos en los campos de precio.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
