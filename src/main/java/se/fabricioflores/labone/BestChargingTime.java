package se.fabricioflores.labone;

import java.util.List;

public class BestChargingTime {
    public static void run(List<Price> priceList) {
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

        int cheapestTotalPrice = -1;
        Price chargeStartTime = priceList.get(0);

        for (int i = 0; i <= priceList.size() - 4; i++) {
            int fourHoursTotal = priceList.get(i).getPrice() + priceList.get(i + 1).getPrice()
                    + priceList.get(i + 2).getPrice() + priceList.get(i + 3).getPrice();

            if(cheapestTotalPrice == -1 || fourHoursTotal < cheapestTotalPrice) {
                cheapestTotalPrice = fourHoursTotal;
                chargeStartTime = priceList.get(i);
            }
        }


        System.out.println("⛽ Börja ladda kl. " + chargeStartTime.getInterval().substring(0, 2)
                + " för att få lägst totalpris på " + cheapestTotalPrice + " öre.");
        System.out.println("📊 Medelpriset under dessa 4 timmar är " + (cheapestTotalPrice / 4) + " öre.\n");
    }
}
