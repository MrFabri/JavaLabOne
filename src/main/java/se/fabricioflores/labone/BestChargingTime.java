package se.fabricioflores.labone;

import java.util.List;

public class BestChargingTime {
    public static void init(List<Price> priceList) {
        System.out.println(
                """
                🔋 Bästa Laddningstid (4h)
                ==========================
                """
        );

        if (priceList.isEmpty()) {
            System.out.println("❌ Inga elpriser har lagts till ännu.\n");
            return;
        }
    }
}
