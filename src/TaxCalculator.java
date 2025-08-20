public class TaxCalculator {

    public double calculateTax(Item item) {
        double rate = 0.0;
        if (!item.isExempt()) {
            rate += 0.10;
        }
        if (item.isImported()) {
            rate += 0.05;
        }
        double rawTax = item.getBasePrice() * rate;
        return roundUpToNearestFiveCents(rawTax);
    }

    private double roundUpToNearestFiveCents(double value) {
        return Math.ceil(value * 20.0) / 20.0;
    }
}
