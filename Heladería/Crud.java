import java.util.ArrayList;
import java.util.Scanner;

public class Crud {
    private static Scanner sc = new Scanner(System.in);

    // -------------------- HELADERIA --------------------
    public static void menuHeladeria(ArrayList<Heladeria> lista) {
        while (true) {
            System.out.println("\n--- CRUD HELADERÍA ---");
            System.out.println("1. Agregar heladería");
            System.out.println("2. Mostrar heladerías");
            System.out.println("3. Buscar heladería por ID");
            System.out.println("4. Editar heladería");
            System.out.println("5. Eliminar heladería");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione: ");
            int op = readInt();
            switch (op) {
                case 1 -> agregarHeladeria(lista);
                case 2 -> mostrarHeladerias(lista);
                case 3 -> buscarHeladeria(lista);
                case 4 -> editarHeladeria(lista);
                case 5 -> eliminarHeladeria(lista);
                case 6 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void agregarHeladeria(ArrayList<Heladeria> lista) {
        System.out.print("ID: ");
        int id = readInt();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        lista.add(new Heladeria(id, nombre));
        System.out.println("Heladería agregada.");
    }

    private static void mostrarHeladerias(ArrayList<Heladeria> lista) {
        if (lista.isEmpty()) System.out.println("No hay heladerías registradas.");
        else lista.forEach(System.out::println);
    }

    private static void buscarHeladeria(ArrayList<Heladeria> lista) {
        System.out.print("ID: ");
        int id = readInt();
        Heladeria h = findHeladeria(lista, id);
        System.out.println(h != null ? h : "No se encontró.");
    }

    private static void editarHeladeria(ArrayList<Heladeria> lista) {
        System.out.print("ID heladería a editar: ");
        int id = readInt();
        Heladeria h = findHeladeria(lista, id);
        if (h == null) {
            System.out.println("No encontrada.");
            return;
        }
        System.out.print("Nuevo nombre (enter para mantener): ");
        String nombre = sc.nextLine();
        if (!nombre.isEmpty()) h.setNombre(nombre);
        System.out.println("Heladería actualizada: " + h);
    }

    private static void eliminarHeladeria(ArrayList<Heladeria> lista) {
        System.out.print("ID heladería a eliminar: ");
        int id = readInt();
        boolean removed = lista.removeIf(x -> x.id == id);
        System.out.println(removed ? "Heladería eliminada." : "No encontrada.");
    }

    private static Heladeria findHeladeria(ArrayList<Heladeria> lista, int id) {
        for (Heladeria h : lista)
            if (h.id == id) return h;
        return null;
    }

    // -------------------- TOPPINGS --------------------
    public static void menuToppings(ArrayList<Toppings> lista) {
        while (true) {
            System.out.println("\n--- CRUD TOPPINGS ---");
            System.out.println("1. Agregar topping");
            System.out.println("2. Mostrar toppings");
            System.out.println("3. Buscar topping por ID");
            System.out.println("4. Editar topping");
            System.out.println("5. Eliminar topping");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione: ");
            int op = readInt();
            switch (op) {
                case 1 -> agregarTopping(lista);
                case 2 -> mostrarToppings(lista);
                case 3 -> buscarTopping(lista);
                case 4 -> editarTopping(lista);
                case 5 -> eliminarTopping(lista);
                case 6 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void agregarTopping(ArrayList<Toppings> lista) {
        System.out.print("ID: ");
        int id = readInt();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        float precio = readFloat();
        lista.add(new Toppings(id, nombre, precio));
        System.out.println("Topping agregado.");
    }

    private static void mostrarToppings(ArrayList<Toppings> lista) {
        if (lista.isEmpty()) System.out.println("No hay toppings registrados.");
        else lista.forEach(System.out::println);
    }

    private static void buscarTopping(ArrayList<Toppings> lista) {
        System.out.print("ID: ");
        int id = readInt();
        Toppings t = findTopping(lista, id);
        System.out.println(t != null ? t : "No se encontró.");
    }

    private static void editarTopping(ArrayList<Toppings> lista) {
        System.out.print("ID topping a editar: ");
        int id = readInt();
        Toppings t = findTopping(lista, id);
        if (t == null) {
            System.out.println("No encontrado.");
            return;
        }
        System.out.print("Nuevo nombre (enter para mantener): ");
        String nombre = sc.nextLine();
        if (!nombre.isEmpty()) t.setNombre(nombre);
        System.out.print("Nuevo precio (ingrese -1 para mantener " + t.getPrecio() + "): ");
        float p = readFloat();
        if (p >= 0) t.setPrecio(p);
        System.out.print("Cambiar ID? 1=Si 2=No: ");
        if (readInt() == 1) {
            System.out.print("Nuevo ID: ");
            int newId = readInt();
            if (findTopping(lista, newId) != null)
                System.out.println("ID ya existe.");
            else {
                t.id = newId;
                System.out.println("ID actualizado.");
            }
        }
        System.out.println("Topping actualizado: " + t);
    }

    private static void eliminarTopping(ArrayList<Toppings> lista) {
        System.out.print("ID topping a eliminar: ");
        int id = readInt();
        boolean removed = lista.removeIf(x -> x.id == id);
        System.out.println(removed ? "Topping eliminado." : "No se encontró topping.");
    }

    private static Toppings findTopping(ArrayList<Toppings> lista, int id) {
        for (Toppings t : lista)
            if (t.id == id) return t;
        return null;
    }

    // -------------------- Entrada segura --------------------
    private static int readInt() {
        while (true) {
            try {
                String line = sc.nextLine().trim();
                return Integer.parseInt(line);
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private static float readFloat() {
        while (true) {
            try {
                String line = sc.nextLine().trim();
                return Float.parseFloat(line);
            } catch (Exception e) {
                System.out.print("Ingrese un número decimal válido: ");
            }
        }
    }
}