package se.fabricioflores.labone;

import java.util.Scanner;

public class Menu {
    public static String choice(Scanner scanner) {
        displayMenu();
        String choice = scanner.nextLine().toLowerCase();

        if (choice.isEmpty()) {
            choice = scanner.nextLine().toLowerCase();
        }

        System.out.println("\n");

        return choice;
    }

    public static void displayMenu() {
        System.out.println(
                """
                \n💡Elpriser
                ============
                1. Inmatning
                2. Min, Max och Medel
                3. Sortera
                4. Bästa Laddningstid (4h)
                e. Avsluta
                """
        );
        System.out.print("Välj alternativ: ");
    }
}
