import java.util.*;

public class InventorySystem extends BasicSystem {
    // It is assumed for simplicity that every item shares the same minQuantity and
    // maxQuantity.
    // If the item's quantity is below minQuantity, an order for it is placed
    // so that its quantity eqauls maxQuantity. In real life, the manager also needs
    // to address
    // a situation where the item's quantity exceeds maxQuantity for an unknown
    // reason. However,
    // in this dummy code, there will be no such issues before the manager can place
    // orders with suppliers.
    private int minQuantity;
    private int maxQuantity;
    private Map<Supplier, List<Order>> ordersPerSupplier;
    private List<Supplier> suppliers;
    private List<Item> items;

    public InventorySystem() {
        // Create dummy suppliers
        int numSuppliers = 10;
        suppliers = new ArrayList<Supplier>();
        for (int i = 0; i < numSuppliers; ++i) {
            Supplier currSupplier = new Supplier(i);
            suppliers.add(currSupplier);
        }
        // Create dummy items
        minQuantity = 20;
        maxQuantity = 100;
        int numDummyItems = 1000;
        items = new ArrayList<Item>();
        for (int i = 0; i < numDummyItems; ++i) {
            int randomQuantity = (int) (Math.random() * maxQuantity);
            int randomSupplierID = (int) (Math.random() * numSuppliers);
            Supplier currSupplier = suppliers.get(randomSupplierID);
            Item currItem = new Item(i, randomQuantity, currSupplier);
            items.add(currItem);
        }
    }

    public boolean placeOrders() {
        boolean entireOrdersPlaced = false;
        ordersPerSupplier = new HashMap<Supplier, List<Order>>();
        // Find the items that need to be ordered.
        for (Item item : items) {
            int currItemQuantity = item.getQuantity();
            // If the current item's quantity is less than the minimum in the range
            if (currItemQuantity < minQuantity) {
                int numToOrder = maxQuantity - currItemQuantity;
                Order currOrder = new Order(item.getItemID(), numToOrder);
                Supplier currSupplier = item.getSupplier();
                ordersPerSupplier.computeIfAbsent(currSupplier, k -> new ArrayList<Order>()).add(currOrder);
            }
        }
        // For each supplier, place a list of orders.
        ordersPerSupplier.forEach((currSupplier, orderList) -> {
            int currSupplierID = currSupplier.getSupplierID();
            System.out.println("Placing orders with supplier: " + currSupplierID);
            boolean ordersPlacedPerSupplier = currSupplier.placeOrder(orderList);
            if (ordersPlacedPerSupplier) {
                System.out.println("All orders placed with supplier: " + currSupplierID + "\n");
            }

        });
        entireOrdersPlaced = true;

        return entireOrdersPlaced;
    }

    public boolean displayReport() {
        boolean hasIssue = false;
        System.out.println("Report Displayed");
        for (Item item : items) {
            int currItemQuantity = item.getQuantity();
            // If the current item's quantity is less than the minimum in the range
            if (currItemQuantity < minQuantity) {
                System.out.println(
                        "Item: " + item.getItemID() + " is running low with the count of " + item.getQuantity() + ".");
            }
        }
        System.out.println();
        return hasIssue;
    }

}
