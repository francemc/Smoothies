package Presentacion;
import javax.swing.*;
import java.awt.*;

public class GUICarritoImp extends GUICarrito {
    private Controlador controlador;
    private JFrame carritoFrame;
    private JPanel panel;
    private JTextField totalField;

    public GUICarritoImp(Controlador controlador, Object datos) {
        this.controlador = controlador;

        // Crear un nuevo JFrame para la GUI del carrito
        carritoFrame = new JFrame("Carrito");
        carritoFrame.setSize(600, 400);
        carritoFrame.setLocationRelativeTo(null);

        // Crear un nuevo JPanel para el contenido del carrito
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear un botón para volver atrás
        JButton volverAtrasButton = new JButton("Volver Atrás");
        volverAtrasButton.addActionListener(e -> {
            // Cerrar la ventana del carrito
            carritoFrame.dispose();
        });

        // Crear una caja de texto para mostrar los productos del carrito
        JTextArea productosArea = new JTextArea();
        productosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(productosArea);

        // Crear un botón para eliminar un producto del carrito
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(e -> {
            // Lógica para eliminar un producto del carrito
            // Implementa la lógica según sea necesario
        });

        // Crear un JPanel para contener el botón de eliminar
        JPanel eliminarPanel = new JPanel();
        eliminarPanel.add(eliminarButton);

        // Crear un JPanel para la parte inferior del carrito
        JPanel bottomPanel = new JPanel(new GridLayout(2, 2));

        // Crear un JLabel para mostrar el total del pedido
        JLabel totalLabel = new JLabel("Total:");
        totalField = new JTextField("0");
        totalField.setEditable(false);

        // Crear un botón para tramitar el pedido
        JButton tramitarButton = new JButton("Tramitar");
        tramitarButton.addActionListener(e -> {
            // Lógica para tramitar el pedido
            // Implementa la lógica según sea necesario
        });

        // Agregar componentes al panel del carrito
        panel.add(volverAtrasButton, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(eliminarPanel, BorderLayout.EAST);
        bottomPanel.add(totalLabel);
        bottomPanel.add(totalField);
        bottomPanel.add(new JLabel()); // Espacio en blanco
        bottomPanel.add(tramitarButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Agregar el panel al JFrame y hacerlo visible
        carritoFrame.add(panel);
        carritoFrame.setVisible(true);
    }

    @Override
    public void actualizar(int evento, Object datos) {
        
    	
    	
    }
}
