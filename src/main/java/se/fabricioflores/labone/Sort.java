package se.fabricioflores.labone;

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

        priceList.sort(Comparator.comparingInt(Price::getPrice));

        for (Price price : priceList) {
            System.out.println("⚡ " + price.getInterval() + " " + price.getPrice() + " öre");
        }
    }
}
