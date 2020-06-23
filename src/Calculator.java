import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Symbol symbol = new Symbol();
        symbol.terminate(text);
    }

}



