package se.fabricioflores.labone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean status = true;
    private static void toggle() { status = !status; }
    private static final List<Price> prices = new ArrayList<Price>();

    public static void main(String[] args) {
        while (status) {
            String choice = Menu.choice(scanner);

            toggle();

            switch (choice) {
                case "e" -> stop();
                case "1" -> Input.init(scanner, prices);
                case "2" -> CalcMinMax.init(prices);
                case "3" -> Sort.init(prices);
                case "4" -> BestChargingTime.init(prices);
                default -> System.out.println("❌ Ogiltigt val. Försök igen!\n");
            }

            toggle();
        }
    }

    private static void stop() {
        toggle();
        scanner.close();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nProgram closed 💀\n");
    }
}