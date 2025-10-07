import java.util.ArrayList;


public class Malteada {
    public int id;
    public String nombre;
    private ArrayList<String> saboresBase;
    private float precio;
    private ArrayList<String> toppings;
    private String lecheTipo;

    public Malteada(int id, String nombre, ArrayList<String> saboresBase, float precio, String lecheTipo) {
        this.id = id;
        this.nombre = nombre;
        this.saboresBase = new ArrayList<>(saboresBase);
        this.precio = precio;
        this.lecheTipo = lecheTipo;
        this.toppings = new ArrayList<>();
    }

    public float calcularPrecio() {
        float precioPorTopping = 500f;
        return precio + (precioPorTopping * toppings.size());
    }

    public void addTopping(String top) {
        if (top != null && !top.isBlank()) toppings.add(top);
    }

    public void setPrecio(float precio) { this.precio = precio; }
    public float getPrecio() { return precio; }
    public ArrayList<String> getSaboresBase() { return new ArrayList<>(saboresBase); }
    public ArrayList<String> getToppings() { return new ArrayList<>(toppings); }
    public void setLecheTipo(String lecheTipo) { this.lecheTipo = lecheTipo; }

    @Override
    public String toString() {
        return String.format(
            "Malteada[ID:%d, Nombre:%s, Base:%.2f, Sabores:%s, Leche:%s, Toppings:%s, PrecioFinal:%.2f]",
            id, nombre, precio, saboresBase.toString(), lecheTipo, toppings.toString(), calcularPrecio()
        );
    }
}