package Negocio;

import integración.DAOPedidosImp;

public class TransferPedido extends DAOPedidosImp {
    protected int idPedido;
    protected String batidos;
    protected int precio;
    protected int unidades;
    protected int idUsuario;

    // Getters
    public int getIdPedido() {
        return idPedido;
    }

    public String getBatidos() {
        return batidos;
    }

    public int getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    // Setters
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setBatidos(String batidos) {
        this.batidos = batidos;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

