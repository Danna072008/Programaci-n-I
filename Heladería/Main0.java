import java.util.ArrayList;
import java.util.Arrays;


public class Main0 {
    public static void main(String[] args) {
        ArrayList<Heladeria> listaHeladerias = new ArrayList<>();
        ArrayList<Helado> listaHelados = new ArrayList<>();
        ArrayList<Malteada> listaMalteadas = new ArrayList<>();
        ArrayList<Toppings> listaToppings = new ArrayList<>();

        ArrayList<String> inicialSabores = new ArrayList<>(Arrays.asList(
                "Cielo de Vainilla",
                "Chocolate Tentación",
                "Fresa Mágica",
                "Dulce de Caramelo",
                "Mango Tropical",
                "Noche de Oreo",
                "Coco Encantado",
                "Café Nevado"
        ));

        Helado ejemplo1 = new Helado(1, "Cielo Vainilla Especial", 3500f,
                new ArrayList<>(Arrays.asList("Cielo de Vainilla")), "Cono clásico");
        Helado ejemplo2 = new Helado(2, "Chocolate Tentación Deluxe", 4200f,
                new ArrayList<>(Arrays.asList("Chocolate Tentación")), "Copa mediana");
        listaHelados.add(ejemplo1);
        listaHelados.add(ejemplo2);

        Malteada mal1 = new Malteada(1, "Malteada Vainilla Especial",
                new ArrayList<>(Arrays.asList("Cielo de Vainilla")), 4500f, "Entera");
        listaMalteadas.add(mal1);

        listaToppings.add(new Toppings(1, "Chips de Chocolate", 300f));
        listaToppings.add(new Toppings(2, "Almendras Tostadas", 400f));
        listaToppings.add(new Toppings(3, "Salsa de Caramelo", 350f));
        listaToppings.add(new Toppings(4, "Galletas Trituradas", 250f));
        listaToppings.add(new Toppings(5, "Coco Rallado", 200f));
        listaToppings.add(new Toppings(6, "Gomitas de Fruta", 300f));
        listaToppings.add(new Toppings(7, "Miel Natural", 450f));

        Heladeria s1 = new Heladeria(1, "Calle Principal #10");
        s1.getListaHeladosDisponibles().addAll(listaHelados);
        s1.getListaMalteadasDisponibles().addAll(listaMalteadas);
        s1.getListaToppings().addAll(listaToppings);
        listaHeladerias.add(s1);

        Menu0 mainMenu = new Menu0(60, '=');
        boolean salir = false;
        while (!salir) {
            ArrayList<String> opciones = new ArrayList<>();
            opciones.add("Administrar Heladerías");
            opciones.add("Administrar Helados");
            opciones.add("Administrar Malteadas");
            opciones.add("Administrar Toppings (Catálogo)");
            opciones.add("Salir");
            int opt = mainMenu.createMenu(opciones);
            switch (opt) {
                case 1 -> Crud.ejecutarCrud(listaHeladerias, "CRUD Heladerías");
                case 2 -> Crud.ejecutarCrud(listaHelados, "CRUD Helados");
                case 3 -> Crud.ejecutarCrud(listaMalteadas, "CRUD Malteadas");
                case 4 -> Crud.ejecutarCrud(listaToppings, "CRUD Toppings");
                case 5 -> {
                    System.out.println("Finalizando aplicación. ¡Hasta luego!");
                    salir = true;
                }
            }
        }
    }
}