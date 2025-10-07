import java.util.ArrayList;
import java.util.Scanner;

public class Menu0 {
    private final int width;
    private final char borderChar;
    private final Scanner sc = InputScanner.getInstance();

    public Menu0(int width, char borderChar) {
        this.width = Math.max(20, width);
        this.borderChar = borderChar;
    }

    public int createMenu(ArrayList<String> options) {
        System.out.println(repeat(String.valueOf(borderChar), width));
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, options.get(i));
        }
        System.out.println(repeat(String.valueOf(borderChar), width));
        System.out.print("Seleccione una opción: ");
        return readIntRange(1, options.size());
    }

    private int readIntRange(int min, int max) {
        while (true) {
            try {
                String line = sc.nextLine().trim();
                int v = Integer.parseInt(line);
                if (v >= min && v <= max) return v;
            } catch (Exception ignored) { }
            System.out.printf("Entrada inválida. Ingrese un número entre %d y %d: ", min, max);
        }
    }

    private String repeat(String s, int n) {
        return s.repeat(Math.max(0, n));
    }
}