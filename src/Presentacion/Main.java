package presentacion;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia de Controlador
        Controlador controlador = Controlador.getInstancia(); 

        // Pasar el controlador al constructor de GUIClientesImp
        GUIClientesImp clientesImp = new GUIClientesImp(controlador);
    }
}
