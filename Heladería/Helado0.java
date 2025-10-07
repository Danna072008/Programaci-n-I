import java.util.ArrayList;


public class Helado0 {
    public int id;
    public String nombre;
    public float precio;
    private float precioPorTopping;
    private ArrayList<String> sabores;
    private ArrayList<String> toppings;
    private String envase;

    public Helado0(int id, String nombre, float precio, ArrayList<String> sabores, String envase) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.sabores = new ArrayList<>(sabores);
        this.envase = envase;
        this.toppings = new ArrayList<>();
        this.precioPorTopping = 500f; // valor por defecto para toppings
    }

    public float calcularPrecio() {
        return this.precio + (this.precioPorTopping * this.toppings.size());
    }

    public void addTopping(String toppingName) {
        if (toppingName != null && !toppingName.isBlank()) {
            this.toppings.add(toppingName);
        }
    }

    public void setPrecio(float precio) { this.precio = precio; }
    public void setEnvase(String envase) { this.envase = envase; }
    public void setPrecioPorTopping(float precioPorTopping) { this.precioPorTopping = precioPorTopping; }

    public ArrayList<String> getSabores() { return new ArrayList<>(sabores); }
    public ArrayList<String> getToppings() { return new ArrayList<>(toppings); }
    public String getEnvase() { return envase; }
    public float getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format(
            "Helado[ID:%d, Nombre:%s, Base:%.2f, Envase:%s, Sabores:%s, Toppings:%s, PrecioFinal:%.2f]",
            id, nombre, precio, envase, sabores.toString(), toppings.toString(), calcularPrecio()
        );
    }
}