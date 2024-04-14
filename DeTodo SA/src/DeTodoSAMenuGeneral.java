import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class DeTodoSAMenuGeneral extends JFrame {
    private JDesktopPane desktopPane;

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
        JMenu consultaMenu = new JMenu("Consulta");

        // Opción de administración
        JMenuItem opcionAdministrar = new JMenuItem("Administrar");
        opcionAdministrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir un JInternalFrame para la administración
                JInternalFrame internalFrame = new JInternalFrame("Administración", true, true, true, true);
                internalFrame.setSize(300, 200);
                internalFrame.setVisible(true);
                desktopPane.add(internalFrame);
            }
        });
        administracionMenu.add(opcionAdministrar);

        // Opción de consulta
        JMenuItem opcionConsultar = new JMenuItem("Consultar");
        opcionConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir un JInternalFrame para la consulta
                JInternalFrame internalFrame = new JInternalFrame("Consulta", true, true, true, true);
                internalFrame.setSize(300, 200);
                internalFrame.setVisible(true);
                desktopPane.add(internalFrame);
            }
        });
        consultaMenu.add(opcionConsultar);

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
