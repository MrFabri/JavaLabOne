package se.fabricioflores.labone;

import java.util.List;

public class CalcMinMax {
    public static void init(List<Integer> prices) {
        System.out.println(
                """
                🪄 Min, Max och Medel
                ======================
                """
        );

        if (prices.isEmpty()) {
            System.out.println("❌ Inga elpriser har lagts till ännu.\n");
            return;
        }

        // Calculation
        int minPrice = prices.get(0);
        int maxPrice = prices.get(0);
        int total = 0;

        for (int price : prices) {
            total += price;

            if (price > maxPrice) {
                minPrice = price;
            }

            if (price < minPrice) {
                minPrice = price;
            }
        }

        double averagePrice = (double) total / 24;

        System.out.println("Genomsnittspriset för dygnet är: " + averagePrice + " öre per kWh");
        System.out.println("Högsta priset under dygnet är: " + maxPrice + " öre per kWh");
        System.out.println("Lägsta priset under dygnet är: " + minPrice + " öre per kWh\n");
    }
}
