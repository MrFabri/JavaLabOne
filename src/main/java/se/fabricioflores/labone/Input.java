package se.fabricioflores.labone;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static void init(Scanner scanner, List<Price> pricesList) {
        System.out.println(
                """
                📄 Inmatning
                =============
                """
        );

        for (int hour = 0; hour < 24; hour++) {

            int nextHour = hour + 1;
            String interval;

            if (String.valueOf(nextHour).length() == 1) {
                interval = String.format("0%s-0%s", hour, nextHour);
            } else if (String.valueOf(hour).length() == 1 && String.valueOf(nextHour).length() == 2) {
                interval = String.format("0%s-%s", hour, nextHour);
            } else {
                interval = String.format("%s-%s", hour, nextHour);
            }

            System.out.printf("🪫 Ange elpris för timme %s (i öre per kWh): ", interval);

            boolean isValid = false;

            while (!isValid) {
                try {
                    int price = scanner.nextInt();
                    pricesList.add(new Price(price, interval));
                    isValid = true;
                } catch (InputMismatchException e) {
                    System.out.print("❌ Error: Ogiltigt inmatning, försök igen: ");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
        }
    }

}