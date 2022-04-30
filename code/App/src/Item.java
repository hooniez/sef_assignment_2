public class Item {
    public Item(int itemID, int quantity, Supplier supplier) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    private int itemID;
    private int quantity;
    private Supplier supplier;

    public int getItemID() {
        return itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
