import java.util.ArrayList;


public class Toppings {
    public int id;
    private String nombre;
    private float precio;
    private ArrayList<String> ingredientes;

    public Toppings(int id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public float getPrecio() { return precio; }
    public ArrayList<String> getIngredientes() { return new ArrayList<>(ingredientes); }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(float precio) { this.precio = precio; }
    public void addIngrediente(String ing) {
        if (ing != null && !ing.isBlank()) ingredientes.add(ing);
    }

    @Override
    public String toString() {
        return String.format(
            "Topping[ID:%d, Nombre:%s, Precio:%.2f, Ingredientes:%s]",
            id, nombre, precio, ingredientes.toString()
        );
    }
}