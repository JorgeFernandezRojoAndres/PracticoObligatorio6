import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ConsultaPorRubroFrame extends JInternalFrame {
    private JComboBox<String> rubroComboBox;
    private JTable productoTable;
    private DefaultTableModel tableModel;
    private ArrayList<Producto> listaProductos;

    public ConsultaPorRubroFrame(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;

        setTitle("Listado de Productos por Rubro");
        setSize(600, 400);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Listado de Productos por Rubro");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        rubroComboBox = new JComboBox<>(new String[]{"Comestible", "Limpieza", "Perfumería"});
        panel.add(rubroComboBox, BorderLayout.NORTH);

        String[] columnNames = {"Código", "Descripción", "Precio", "Stock"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productoTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        rubroComboBox.addActionListener(e -> actualizarTabla());
    }

    private void actualizarTabla() {
        try {
            tableModel.setRowCount(0);
            String rubroSeleccionado = (String) rubroComboBox.getSelectedItem();
            if (listaProductos != null) {
                for (Producto producto : listaProductos) {
                    if (rubroSeleccionado.equals(producto.getRubro())) {
                        Object[] rowData = {producto.getCodigo(), producto.getDescripcion(), producto.getPrecio(), producto.getStock()};
                        tableModel.addRow(rowData);
                    }
                }
            } else {
                System.out.println("La lista de productos es nula.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
