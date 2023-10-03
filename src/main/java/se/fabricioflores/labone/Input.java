package se.fabricioflores.labone;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static void run(Scanner scanner, List<Price> pricesList) {
        System.out.println(
                """
                📄 Inmatning
                =============
                """
        );

        if(!pricesList.isEmpty()) {
            pricesList.clear();
        }

        for (int hour = 0; hour < 24; hour++) {
            String interval = generateIntervalBasedOnNumber(hour);

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

    public static String generateIntervalBasedOnNumber (int num) {
        String number = String.valueOf(num);
        String secondNumber = String.valueOf(num + 1);

        if(number.length() == 1) {
            number = "0" + number;
        }

        if(secondNumber.length() == 1) {
            secondNumber = "0" + secondNumber;
        }

        return number + "-" + secondNumber;
    }

}