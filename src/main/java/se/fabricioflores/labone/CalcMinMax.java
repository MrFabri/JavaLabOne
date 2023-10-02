package se.fabricioflores.labone;

import java.util.List;

public class CalcMinMax {
    public static void run(List<Price> priceList) {
        System.out.println(
                """
                📊 Min, Max och Medel
                ======================
                """
        );

        if (priceList.isEmpty()) {
            System.out.println("❌ Inga elpriser har lagts till ännu.\n");
            return;
        }

        // Calculation
        Price minPriceItem = priceList.get(0);
        Price maxPriceItem = priceList.get(0);
        int total = 0;

        for (Price priceItem : priceList) {
            int price = priceItem.getPrice();
            total += price;

            if (price < minPriceItem.getPrice()) {
                minPriceItem = priceItem;
            }
            if (price > maxPriceItem.getPrice()) {
                maxPriceItem = priceItem;
            }
        }

        double averagePrice = (double) total / 24;

        System.out.println("👉 Genomsnittspriset för dygnet är: " + averagePrice + " öre.");
        System.out.println("📈 Högsta priset under dygnet är mellan " + maxPriceItem.getInterval() + " med " + maxPriceItem.getPrice() + " öre.");
        System.out.println("📉 Lägsta priset under dygnet är mellan " + minPriceItem.getInterval() + " med " + minPriceItem.getPrice() + " öre.\n");
    }
}
