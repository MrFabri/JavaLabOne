package se.fabricioflores.labone;

public class Price {
    private final int price;
    private final String interval;

    public Price(int price, String interval) {
        this.price = price;
        this.interval = interval;
    }

    public int getPrice() {
        return price;
    }

    public String getInterval() {
        return interval;
    }
}