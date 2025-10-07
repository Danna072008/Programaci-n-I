import java.util.ArrayList;


public class Heladeria {
    public int id;
    private String direccion;
    private ArrayList<Helado> listaHeladosDisponibles;
    private ArrayList<Malteada> listaMalteadasDisponibles;
    private ArrayList<Toppings> listaToppings;
    private ArrayList<Pedido> listaPedidos;

    public Heladeria(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
        this.listaHeladosDisponibles = new ArrayList<>();
        this.listaMalteadasDisponibles = new ArrayList<>();
        this.listaToppings = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public ArrayList<Helado> getListaHeladosDisponibles() { return listaHeladosDisponibles; }
    public ArrayList<Malteada> getListaMalteadasDisponibles() { return listaMalteadasDisponibles; }
    public ArrayList<Toppings> getListaToppings() { return listaToppings; }
    public ArrayList<Pedido> getListaPedidos() { return listaPedidos; }

    public void addPedido(Pedido p) {
        if (p != null) listaPedidos.add(p);
    }

    @Override
    public String toString() {
        return String.format("Heladeria[ID:%d, Dirección:%s, #Helados:%d, #Malteadas:%d, #Toppings:%d, #Pedidos:%d]",
                id, direccion, listaHeladosDisponibles.size(), listaMalteadasDisponibles.size(),
                listaToppings.size(), listaPedidos.size());
    }
}