package se.fabricioflores.labone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void init(List<Price> priceList) {
        System.out.println(
                """
                🔎 Sortering
                =============
                """
        );

        if (priceList.isEmpty()) {
            System.out.println("❌ Inga elpriser har lagts till ännu.\n");
            return;
        }
        
        List<Price> sortedPriceList = new ArrayList<>(priceList);

        sortedPriceList.sort(Comparator.comparingInt(Price::getPrice));

        for (Price price : sortedPriceList) {
            System.out.println("⚡ " + price.getInterval() + " " + price.getPrice() + " öre");
        }
    }
}
