package Presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIAdministradorImp extends GUIAdministrador {
	private Controlador cntr  ; 
	private JPanel panel  ; 
	
	public GUIAdministradorImp(Controlador contr ) {
		this.cntr = contr  ; 
		JFrame menuFrame = new JFrame("Menú");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(800, 400); // Tamaño del menú
        menuFrame.setLocationRelativeTo(null); // Centrar en la pantalla


        // Crear un panel para contener los botones del menú
        JPanel menuPanel = new JPanel(new BorderLayout());
     // Crear un panel para los botones principales del menú
        JPanel mainButtonsPanel = new JPanel(new GridLayout(1, 2));

        // Crear botones para las opciones principales del menú
        JButton Button1 = new JButton("Pedidos");
        JButton Button2 = new JButton("Stock");
        JButton Button3 = new JButton("Añadir") ; 
        mainButtonsPanel.add(Button1);
        mainButtonsPanel.add(Button2);
        mainButtonsPanel.add(Button3);

        // Agregar el panel de los botones principales al panel del menú en la parte central
        menuPanel.add(mainButtonsPanel, BorderLayout.CENTER);

        // Crear un panel para contener los botones adicionales
        JPanel additionalButtonsPanel = new JPanel(new GridLayout(1, 2));

        // Crear botones adicionales para salir y para el carrito
        JButton salirButton = new JButton("Salir");
        
        // Agregar oyentes de evento a los botones adicionales
        salirButton.addActionListener(e -> {
            // Lógica para cerrar el programa al presionar el botón "Salir"
            System.exit(0);
        });


        // Agregar los botones adicionales al panel de botones adicionales
        additionalButtonsPanel.add(salirButton);
      
        // Agregar el panel de botones adicionales al panel del menú en la parte inferior
        menuPanel.add(additionalButtonsPanel, BorderLayout.SOUTH);
 
        // Agregar el panel del menú al JFrame
        menuFrame.getContentPane().add(menuPanel);
        menuFrame.setVisible(true);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		// TODO Auto-generated method stub
		
	}
}
