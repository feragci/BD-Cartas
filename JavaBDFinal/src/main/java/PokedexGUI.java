import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PokedexGUI extends JFrame {

    private JTextArea textArea;

    public PokedexGUI() {
        setTitle("Pokédex - Interfaz Gráfica");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnMostrarTodas = new JButton("Mostrar todas las cartas");
        JButton btnBuscar = new JButton("Buscar por ID");

        JTextField idField = new JTextField(10);
        panelBotones.add(btnMostrarTodas);
        panelBotones.add(new JLabel("ID:"));
        panelBotones.add(idField);
        panelBotones.add(btnBuscar);

        add(panelBotones, BorderLayout.NORTH);

        btnMostrarTodas.addActionListener(e -> {
            textArea.setText(Pokedex.obtenerTodasCartas());
        });

        btnBuscar.addActionListener(e -> {
            String id = idField.getText().trim();
            if (!id.isEmpty()) {
                textArea.setText(Pokedex.obtenerCartaPorID(id));
            } else {
                JOptionPane.showMessageDialog(this, "Introduce un ID válido.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PokedexGUI().setVisible(true);
        });
    }
}
