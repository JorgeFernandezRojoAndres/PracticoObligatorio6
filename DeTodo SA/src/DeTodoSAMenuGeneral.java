import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DeTodoSAMenuGeneral extends JFrame {
    private JDesktopPane desktopPane;
    private GestionDeProductos gestionDeProductos;
    private ArrayList<Producto> listaProductos;

    public DeTodoSAMenuGeneral() {
        setTitle("Menú General");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel de escritorio
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        // Crear el menú bar
        JMenuBar menuBar = new JMenuBar();
        JMenu administracionMenu = new JMenu("Administración");
        JMenuItem productoMenuItem = new JMenuItem("Producto"); // Nuevo JMenuItem para "Producto"

        // ActionListener para el botón "Producto"
        productoMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de GestionDeProductos y agregarla al JDesktopPane
                gestionDeProductos = new GestionDeProductos(DeTodoSAMenuGeneral.this);

                desktopPane.add(gestionDeProductos);
                gestionDeProductos.setVisible(true);
            }
        });

        administracionMenu.add(productoMenuItem); // Agregar el JMenuItem a "Administración"

        JMenu consultaMenu = new JMenu("Consulta");

        // Botón "Rubro"
        JMenuItem rubroMenuItem = new JMenuItem("Rubro");
        rubroMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar si se ha creado una instancia de GestionDeProductos
                if (gestionDeProductos != null) {
                    // Crear una instancia de ConsultaPorRubroFrame y agregarla al JDesktopPane
                    ConsultaPorRubroFrame rubroFrame = new ConsultaPorRubroFrame(gestionDeProductos.getListaProductos());
                    desktopPane.add(rubroFrame);
                    rubroFrame.setVisible(true);
                } else {
                    // Notificar al usuario que no se pueden realizar consultas sin gestionar productos
                    JOptionPane.showMessageDialog(DeTodoSAMenuGeneral.this, "Primero debe gestionar productos.");
                }
            }
        });
        consultaMenu.add(rubroMenuItem);

        // Botón "Nombre"
        JMenuItem nombreMenuItem = new JMenuItem("Nombre");
        nombreMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar si se ha creado una instancia de GestionDeProductos
                if (gestionDeProductos != null) {
                    // Crear una instancia de ConsultaPorNombreFrame y agregarla al JDesktopPane
                    ConsultaPorNombreFrame nombreFrame = new ConsultaPorNombreFrame(gestionDeProductos.getListaProductos());
                    desktopPane.add(nombreFrame);
                    nombreFrame.setVisible(true);
                } else {
                    // Notificar al usuario que no se pueden realizar consultas sin gestionar productos
                    JOptionPane.showMessageDialog(DeTodoSAMenuGeneral.this, "Primero debe gestionar productos.");
                }
            }
        });
        consultaMenu.add(nombreMenuItem);

        // Botón "Precio"
        JMenuItem precioMenuItem = new JMenuItem("Precio");
        precioMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar si se ha creado una instancia de GestionDeProductos
                if (gestionDeProductos != null) {
                    // Crear una instancia de ConsultaPorPrecioFrame y agregarla al JDesktopPane
                    ConsultaPorPrecioFrame precioFrame = new ConsultaPorPrecioFrame(gestionDeProductos.getListaProductos());
                    desktopPane.add(precioFrame);
                    precioFrame.setVisible(true);
                } else {
                    // Notificar al usuario que no se pueden realizar consultas sin gestionar productos
                    JOptionPane.showMessageDialog(DeTodoSAMenuGeneral.this, "Primero debe gestionar productos.");
                }
            }
        });
        consultaMenu.add(precioMenuItem);

        // Agregar los menús al menú bar
        menuBar.add(administracionMenu);
        menuBar.add(consultaMenu);

        // Configurar el menú bar en el frame
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DeTodoSAMenuGeneral frame = new DeTodoSAMenuGeneral();
                frame.setVisible(true);
            }
        });
    }
}
