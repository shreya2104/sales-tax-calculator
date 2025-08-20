public class ReceiptPrinter {
    private final TaxCalculator calculator = new TaxCalculator();

    public void print(Basket basket) {
        double totalTax = 0.0;
        double totalAmount = 0.0;

        for (Item item : basket.getItems()) {
            double taxPerUnit = calculator.calculateTax(item);
            double finalPerUnit = item.getBasePrice() + taxPerUnit;

            double itemTax = taxPerUnit * item.getQuantity();
            double itemTotal = finalPerUnit * item.getQuantity();

            totalTax += itemTax;
            totalAmount += itemTotal;

            System.out.println(item.getQuantity() + " " + item.getName() + ": " +
                    String.format("%.2f", itemTotal));
        }

        System.out.println("Sales Taxes: " + String.format("%.2f", totalTax));
        System.out.println("Total: " + String.format("%.2f", totalAmount));
    }
}
