package se.fabricioflores.labone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CSVFileReader {
    public static Optional<List<Price>> run(List<Price> priceList, String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder fileContent = new StringBuilder();
            String fileLine;

            // Read the entire content of the file into a StringBuilder
            while ((fileLine = reader.readLine()) != null) {
                fileContent.append(fileLine);
            }

            String fileContentString = fileContent.toString();
            String[] listOfPossibleNumbers = fileContentString.split(",");

            // CSV File must contain exactly 24 numbers
            if(listOfPossibleNumbers.length != 24) {
                System.out.println("❌ Not valid CSV file. Must contain 24 digits!\n");
                return Optional.empty();
            }

            // Updates the price list with the CSV file numbers
            for(int i = 0; i < 24; i++) {
                String interval = Input.generateIntervalBasedOnNumber(i);
                int price = Integer.parseInt(listOfPossibleNumbers[i].trim());

                priceList.add(new Price(price, interval));
            }

            return Optional.of(priceList);

        } catch (IOException e) {
            return Optional.empty();
        } catch (NumberFormatException e) {
            System.out.println("❌ Not valid CSV file, only whole numbers are accepted!\n");
            return Optional.empty();
        }
    }
}
