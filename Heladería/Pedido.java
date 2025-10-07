import java.util.ArrayList;


public class Pedido {
    private int mesa; 
    private ArrayList<Helado> helados;
    private ArrayList<Malteada> malteadas;
    private float propina;

    public Pedido(int mesa) {
        this.mesa = mesa;
        this.helados = new ArrayList<>();
        this.malteadas = new ArrayList<>();
        this.propina = 0f;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public float getPropina() {
        return propina;
    }

    public void setPropina(float propina) {
        if (propina >= 0) this.propina = propina; 
    }

    public void addHelado(Helado h) {
        if (h != null) helados.add(h);
    }

    public void addMalteada(Malteada m) {
        if (m != null) malteadas.add(m);
    }

    public float calcularCuenta() {
        float total = 0f;
        for (Helado h : helados) total += h.calcularPrecio();
        for (Malteada m : malteadas) total += m.calcularPrecio();
        return total + propina;
    }

    @Override
    public String toString() {
        return String.format(
            "Pedido [Mesa: %d, Helados: %s, Malteadas: %s, Propina: %.2f, Total: %.2f]",
            mesa, helados, malteadas, propina, calcularCuenta()
        );
    }
}