package Presentacion;

import javax.swing.*;

import Negocio.TransferProducto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIProductosImp extends GUIProductos {

    private Controlador controlador;
    private JFrame menuFrame;
    private List<TransferProducto> listaIngredientes;
    private JLabel totalUnidadesLabel;
    private int totalUnidades;

    public GUIProductosImp(Controlador controlador) {
        this.controlador = controlador;
        this.listaIngredientes = new ArrayList<>();
        this.totalUnidades = 0;

        // Obtener la lista de ingredientes desde el controlador
        this.listaIngredientes = controlador.devolverLista("ingredientes",true);

        // Crear el JFrame principal
        menuFrame = new JFrame("Smoothie Personalizado");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(800, 400);
        menuFrame.setLocationRelativeTo(null);

        // Crear un JPanel para contener todo el contenido
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Crear un JPanel para la lista de ingredientes
        JPanel listaPanel = new JPanel(new GridBagLayout());

        // Crear un JPanel para mostrar las unidades totales añadidas
        JPanel unidadesPanel = new JPanel(new BorderLayout());
        totalUnidadesLabel = new JLabel("Ingredientes añadidos: " + totalUnidades);
        unidadesPanel.add(totalUnidadesLabel, BorderLayout.CENTER);

        // Calcular el ancho máximo de los nombres de los productos
        int maxWidth = 0;
        for (TransferProducto producto : listaIngredientes) {
        	
            JLabel tempLabel = new JLabel(producto.getNombre());
            maxWidth = Math.max(maxWidth, tempLabel.getPreferredSize().width);
        	
        }

        // Agregar la lista de ingredientes al JPanel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;

        for (TransferProducto producto : listaIngredientes) {
        	
            JPanel productoPanel = new JPanel(new BorderLayout());
            JLabel nombreLabel = new JLabel(producto.getNombre());
            // Establecer el mismo ancho mínimo para todos los nombres de productos
            nombreLabel.setPreferredSize(new Dimension(maxWidth, nombreLabel.getPreferredSize().height));
            JTextField contadorTextField = new JTextField("0", 3); // Campo de texto para el contador individual
            JButton addButton = new JButton("+");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para añadir una unidad del producto
                    int contador = Integer.parseInt(contadorTextField.getText());
                    if(totalUnidades < 5) {
                        contador++;
                        contadorTextField.setText(Integer.toString(contador));

                        totalUnidades++;
                        totalUnidadesLabel.setText("Total ingredientes: " + totalUnidades);
                    }
                    else {
                        JOptionPane.showMessageDialog(menuFrame, "No se pueden agregar más de 5 ingredientes", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                }
                
            
            });
            JButton removeButton = new JButton("-");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para quitar una unidad del producto si el contador es mayor que 0
                    int contador = Integer.parseInt(contadorTextField.getText());
                    if (contador > 0) {
                        contador--;
                        contadorTextField.setText(Integer.toString(contador));

                        totalUnidades--;
                        totalUnidadesLabel.setText("Total ingredientes: " + totalUnidades);
                    }
                }
            });
            // Agregar componentes al panel de producto
            JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
            buttonsPanel.add(removeButton);
            buttonsPanel.add(addButton);
            productoPanel.add(nombreLabel, BorderLayout.WEST);
            productoPanel.add(buttonsPanel, BorderLayout.EAST);
            productoPanel.add(contadorTextField, BorderLayout.CENTER);
            gbc.gridy++;
            listaPanel.add(productoPanel, gbc);
        }

        // Agregar la lista de ingredientes al JScrollPane
        JScrollPane scrollPane = new JScrollPane(listaPanel);

        // Agregar el JScrollPane al JPanel de contenido
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Agregar el JPanel de unidades al JPanel de contenido
        contentPanel.add(unidadesPanel, BorderLayout.NORTH);

        // Crear un botón para volver atrás
        JButton backButton = new JButton("Volver");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                menuFrame.dispose();
                // Volver a la pantalla anterior
                // Implementa la lógica para volver a la pantalla anterior aquí
            }
        });

        // Crear un botón para añadir
        JButton addButton = new JButton("Añadir");

        // Crear un panel para contener los botones
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(addButton);
        buttonsPanel.add(backButton);

        // Agregar el panel de botones al JPanel de contenido
        contentPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Agregar el JPanel de contenido al JFrame principal
        menuFrame.add(contentPanel);
        menuFrame.setVisible(true);
    
}

    @Override
    public void actualizar(int evento, Object datos) {
        // Implementa la lógica para actualizar la interfaz gráfica cuando sea necesario
    }
}
