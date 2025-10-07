import java.util.Scanner;


public final class InputScanner {
    private static final Scanner INSTANCE = new Scanner(System.in);

    private InputScanner() { /* no instanciable */ }

    public static Scanner getInstance() {
        return INSTANCE;
    }
}