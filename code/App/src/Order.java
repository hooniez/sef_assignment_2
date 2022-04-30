public class Order {
    // Other order details are deemed too low-level to be implemented in the dummy code (e.g. address)
    private int itemID;
    private int numItems;
    public Order(int itemID, int numItems) {
        this.itemID = itemID;
        this.numItems = numItems;
    }
    public int getItemID() {
        return itemID;
    }
    public int getNumItems() {
        return numItems;
    }
}
