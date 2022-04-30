public class Payslip {
    private Cashier cashier;
    private double amount;

    public Payslip(Cashier cashier, double amount) {
        this.cashier = cashier;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Cashier getCashier() {
        return cashier;
    }
}
