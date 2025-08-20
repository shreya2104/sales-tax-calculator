public class Item {
    private final String name;
    private final int quantity;
    private final double basePrice;
    private final boolean imported;
    private final boolean exempt;

    public Item(String name, int quantity, double basePrice, boolean imported, boolean exempt) {
        this.name = name;
        this.quantity = quantity;
        this.basePrice = basePrice;
        this.imported = imported;
        this.exempt = exempt;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getBasePrice() { return basePrice; }
    public boolean isImported() { return imported; }
    public boolean isExempt() { return exempt; }
}