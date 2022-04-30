public class Cashier extends Staff {
    private double hourlyWage;

    public Cashier(int id, double hourlyWage) {
        this.id = id;
        this.hourlyWage = hourlyWage;
        // Dummy bank account number
        this.bankAccountInfo = "xxx-xxx-xxx-xxx";
    }

    public int getId() {
        return id;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public String getBankAccountInfo() {
        return bankAccountInfo;
    }

    public void unloadItem(int itemID) {
    }

    public void itemPrice(int itemID) {
    }

    // Deposit cash paid by the customer and return change in cash
    public double payCash(double money) {
        return 0;
    }

    // It makes more sense for CardProcessor to exist separately from Cashier
    // as there are cases where cashiers need to swap card processors etc.
    public boolean payCredit(CardProcessor cp, String ID) {
        return cp.processCard(ID);
    }

    public boolean paySalary(double amount) {
        // Mimic the real-life deposit
        System.out.println(amount + " has been deposited in Cashier: "
                + id + "'s bank account: " + bankAccountInfo);
        // Always return true (successful) in the dummy code
        return true;
    }
}
