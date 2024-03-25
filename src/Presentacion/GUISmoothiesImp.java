package presentacion;

import javax.swing.*;

import negocio.TransferSmoothies;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUISmoothiesImp extends GUISmoothies {
    private Controlador controlador;
    private JFrame menuFrame;
    private List<TransferSmoothies> listaSmoothies;
    private DefaultListModel<String> smoothiesListModel;
    private JList<String> smoothiesList;

    public GUISmoothiesImp(Controlador controlador) {
        this.controlador = controlador;
        this.listaSmoothies = new ArrayList<>();
        this.listaSmoothies = controlador.devolverLista("smoothies");

        menuFrame = new JFrame("Menu Smoothies");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(800, 600);
        menuFrame.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // Panel para la lista de smoothies
        JPanel smoothiesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Crear modelo y lista de smoothies
        smoothiesListModel = new DefaultListModel<>();
        for (TransferSmoothies smoothie : listaSmoothies) {
            smoothiesListModel.addElement(smoothie.getNombre() + " ->  " + smoothie.getDescripcion());
        }
        smoothiesList = new JList<>(smoothiesListModel);
        smoothiesList.setFont(new Font("Arial", Font.BOLD, 16));
        smoothiesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        smoothiesPanel.add(new JScrollPane(smoothiesList), gbc);

        // Panel para botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton addToCartButton = new JButton("Añadir al carrito");
        addToCartButton.setPreferredSize(new Dimension(150, 40));
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSmoothie = smoothiesList.getSelectedValue();
                if (selectedSmoothie != null) {
                    // Aquí puedes añadir la lógica para agregar el batido seleccionado al carrito
                    JOptionPane.showMessageDialog(menuFrame, "Batido '" + selectedSmoothie.split(" -> ")[0] + "' añadido al carrito.");
                } else {
                    JOptionPane.showMessageDialog(menuFrame, "Por favor, selecciona un batido primero.");
                }
            }
        });

        JLabel sizeLabel = new JLabel("Tamaño:");
        JComboBox<String> sizeComboBox = new JComboBox<>(new String[]{"Pequeño", "Mediano", "Grande"});
        sizeComboBox.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(sizeLabel);
        buttonPanel.add(sizeComboBox);
        buttonPanel.add(addToCartButton);

        // Botón para volver atrás
        JButton backButton = new JButton("Volver");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	menuFrame.dispose();
            }
        });
        buttonPanel.add(backButton);

        JButton cartButton = new JButton("Ver carrito");
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  lógica para mostrar el carrito
                JOptionPane.showMessageDialog(menuFrame, "Mostrar carrito");
            }
        });
        buttonPanel.add(cartButton);

        contentPanel.add(smoothiesPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Establecer fuente para el panel principal
        Font font = new Font("Arial", Font.PLAIN, 18);
        setComponentFont(contentPanel, font);

        // Establecer color de fondo para el panel principal
        contentPanel.setBackground(Color.WHITE);

        // Agregar panel principal al frame
        menuFrame.add(contentPanel);
        menuFrame.setVisible(true);
    }

    @Override
    public void actualizar(int evento, Object datos) {
        // TODO Auto-generated method stub
    }

    // Método para establecer la fuente de los componentes de un contenedor y sus subcomponentes
    private void setComponentFont(Container container, Font font) {
        for (Component component : container.getComponents()) {
            if (component instanceof Container) {
                setComponentFont((Container) component, font);
            }
            component.setFont(font);
        }
    }
}