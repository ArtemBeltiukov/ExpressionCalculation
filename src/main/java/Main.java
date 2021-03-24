import services.Calculator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (true) {
            String string = scanner.nextLine();
            if (string.equals("exit")) {
                break;
            }
            Double res = calculator.calculateExpression(string);
            System.out.println(res);
        }
    }
}
