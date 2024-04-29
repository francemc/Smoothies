package Presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import javax.swing.table.TableModel;

import Negocio.TransferPedido;
import Negocio.TransferProducto;

public class GUIAdministradorImp extends GUIAdministrador {
	private Controlador cntr  ; 
	private JPanel panel  ; 
	private Object datos  ;
	private int pos; 
	
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
        JButton botonPedidos = new JButton("Pedidos");
        JButton botonstock= new JButton("Stock");
        JButton Button3 = new JButton("Añadir") ; 
        mainButtonsPanel.add(botonPedidos);
        mainButtonsPanel.add(botonstock);
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

        botonPedidos.addActionListener(e -> {
            // Obtener la lista de pedidos del controlador
        	 Iterator<TransferPedido> listaPedidos = contr.obtenerIteradorLista("pedidos",false);
          	
            // Crear un arreglo de strings para almacenar la representación de los pedidos
            String[] pedidosArray = new String[100];
            int i = 0  ; 
            while(listaPedidos.hasNext()) {
                TransferPedido pedido = listaPedidos.next();
                // Formatear la representación del pedido como desees
                String pedidoStr = "ID: " + pedido.getIdPedido() + " - Batidos: " + pedido.getBatidos();
                pedidosArray[i] = pedidoStr;
                i++ ; 
            }
            
            // Crear una JList con los pedidos
            JList<String> listaPedidosJList = new JList<>(pedidosArray);
            
            // Mostrar la lista de pedidos en un JOptionPane
            JOptionPane.showMessageDialog(null, new JScrollPane(listaPedidosJList), "Lista de Pedidos", JOptionPane.PLAIN_MESSAGE);
        });
        botonstock.addActionListener(e->{
        	 List<String> columns = new ArrayList<String>();
             List<String[]> values = new ArrayList<String[]>();
             Iterator<TransferProducto> listaIngredientes = contr.obtenerIteradorLista("ingredientes",false);
         	
             columns.add("Ingrediente");
             columns.add("Estado");
           

             
             while(listaIngredientes.hasNext()) {
            	 TransferProducto ing  = listaIngredientes.next() ; 
            	 String nombre = ing.getNombre() ; 
            	 String ingdisp = "Activo"  ; 
                 if(!ing.getDisp()) {
                 	ingdisp = "Desactivado" ;
                 }
            	 values.add(new String[] {nombre,ingdisp}); 
             }
          
            
             TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

              JTable table = new JTable(tableModel);
              table.getColumn("Estado").setCellRenderer(new ButtonRenderer());
              table.getColumn("Estado").setCellEditor(new ButtonEditor(new JCheckBox()));
      
//             
            
            // Mostrar la lista de pedidos en un JOptionPane
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Lista de ingredientes", JOptionPane.PLAIN_MESSAGE);
        	//sacar lista ingredientes
            
        
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
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ButtonRenderer() {
	        setOpaque(true);
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value,
	            boolean isSelected, boolean hasFocus, int row, int column) {
	        if (isSelected) {
	            setForeground(table.getSelectionForeground());
	            setBackground(table.getSelectionBackground());
	        } else {
	            setForeground(table.getForeground());
	            setBackground(UIManager.getColor("Button.background"));
	        }
	        setText((value == null) ? "" : value.toString());
	        return this;
	    }
	}

	class ButtonEditor extends DefaultCellEditor {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected JButton button;
	    private String label;
	    private boolean isPushed;

	    public ButtonEditor(JCheckBox checkBox) {
	        super(checkBox);
	        button = new JButton();
	        button.setOpaque(true);
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                fireEditingStopped();
	                
	                
	            }

				
	        });
	    }

	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value,
	            boolean isSelected, int row, int column) {
	    	String disponibilidad ; 
	    	String ing ;
	    
	        if (isSelected) {
	            button.setForeground(table.getSelectionForeground());
	            button.setBackground(table.getSelectionBackground());
	        } else {
	            button.setForeground(table.getForeground());
	            button.setBackground(table.getBackground());
	        }
	        label = (value == null) ? "" : value.toString();
	        pos = row;
	        ing=(String) table.getValueAt(pos,0); 
	        disponibilidad  = (String ) value ; 
	        datos = ing + "," + disponibilidad ; 
	        button.setText(label);
	        isPushed = true;
	        return button;
	    }

	    @Override
	    public Object getCellEditorValue() {
	        if (isPushed) {
	        	int respuesta =JOptionPane.showConfirmDialog(button, "¿Quieres cambiar de estado?",null, JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                	cntr.accion(Eventos.CAMBIAR_DISPONIBILIDAD,datos);
   
                } 
	        }
	        isPushed = false;
	        return label;
	    }

	    @Override
	    public boolean stopCellEditing() {
	        isPushed = false;
	        return super.stopCellEditing();
	    }
	}
}
