import java.util.*;

public class Supplier {
    private int supplierID;

    public Supplier(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public boolean placeOrder(List<Order> orders) {
        boolean ordersPlacedPerSupplier = false;
        for (Order order : orders) {
            System.out.println(
                    "An order of quantity " + order.getNumItems() + " for itemID: " + order.getItemID()
                            + " is placed.");
        }
        ordersPlacedPerSupplier = true;
        return ordersPlacedPerSupplier;
    }
}
