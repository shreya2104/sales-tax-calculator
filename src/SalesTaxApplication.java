import java.util.Scanner;

public class SalesTaxApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReceiptPrinter printer = new ReceiptPrinter();

        while (true) {
            Basket basket = new Basket();
            System.out.println("Enter items in a new basket (empty line = finish, 'exit' = quit):");

            while (true) {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase("exit")) {
                    return;
                }
                if (line.isEmpty()) {
                    break;
                }
                Item item = parseItem(line);
                basket.addItem(item);
            }

            if (!basket.isEmpty()) {
                printer.print(basket);
                System.out.println();
            }
        }
    }

    private static Item parseItem(String input) {
        int qtyEnd = input.indexOf(' ');
        int quantity = Integer.parseInt(input.substring(0, qtyEnd));

        String[] parts = input.substring(qtyEnd + 1).split(" at ");
        String namePart = parts[0];
        double price = Double.parseDouble(parts[1]);

        boolean imported = namePart.contains("imported");
        boolean exempt = isExempt(namePart);

        return new Item(namePart, quantity, price, imported, exempt);
    }

    private static boolean isExempt(String name) {
        return name.contains("book") ||
               name.contains("chocolate") ||
               name.contains("chocolates") ||
               name.contains("pill");
    }
}
