import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestionDeProductos extends JInternalFrame {
     private ArrayList<Producto> listaProductos;
    private JTextField codigoField, descripcionField, precioField, stockField;
    private JComboBox<String> rubroComboBox;
    private DeTodoSAMenuGeneral menuGeneral;

    public GestionDeProductos(DeTodoSAMenuGeneral menuGeneral) {
        listaProductos = new ArrayList<>();
        this.menuGeneral = menuGeneral;
        setTitle("Gestión de Productos");
        setSize(700, 300);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 5)); // Ajusta espacios entre componentes

        JLabel codigoLabel = new JLabel("Código:");
        codigoField = new JTextField(10); // Tamaño más pequeño
        panel.add(codigoLabel);
        panel.add(codigoField);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionField = new JTextField(10); // Tamaño más pequeño
        panel.add(descripcionLabel);
        panel.add(descripcionField);

        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField(10); // Tamaño más pequeño
        panel.add(precioLabel);
        panel.add(precioField);

        JLabel rubroLabel = new JLabel("Rubro:");
        String[] rubros = {"Comestible", "Limpieza", "Perfumería"}; // Opciones del JComboBox
        rubroComboBox = new JComboBox<>(rubros);
        panel.add(rubroLabel);
        panel.add(rubroComboBox);

        JLabel stockLabel = new JLabel("Stock:");
        stockField = new JTextField(10); // Tamaño más pequeño
        panel.add(stockLabel);
        panel.add(stockField);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton nuevoButton = new JButton("Nuevo");
        nuevoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar producto
            }
        });

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(nuevoButton);
        buttonPanel.add(guardarButton);
        buttonPanel.add(eliminarButton);
        buttonPanel.add(salirButton);

        panel.add(buttonPanel); // Agrega el panel de botones al panel principal

        add(panel);
    }

    private void limpiarCampos() {
        codigoField.setText("");
        descripcionField.setText("");
        precioField.setText("");
        stockField.setText("");
    }

    private void guardarProducto() {
        // Obtener los valores ingresados por el usuario
    String codigo = codigoField.getText();
    String descripcion = descripcionField.getText();
    double precio = Double.parseDouble(precioField.getText()); // Convertir el texto a double
    String rubro = (String) rubroComboBox.getSelectedItem(); // Obtener el rubro seleccionado
    int stock = Integer.parseInt(stockField.getText()); // Convertir el texto a int

    // Crear una instancia de Producto con los valores obtenidos
    Producto producto = new Producto(codigo, descripcion, precio, rubro, stock);
    // Agregar el producto a la lista
        listaProductos.add(producto);

        // Notificar al usuario que el producto ha sido guardado (puedes usar una ventana emergente, un mensaje en la consola, etc.)
        JOptionPane.showMessageDialog(this, "Producto guardado con éxito.");

        // Limpiar los campos después de guardar
        limpiarCampos();
    }
}
