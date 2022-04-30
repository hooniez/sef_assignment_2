public class Manager extends Staff {
    // No consturctor required since yearlySalary variable has no relevance
    // to the use cases for the assignement.
    private double yearlySalary;

    public void lookAfterInventory(InventorySystem is) {
        boolean orderPlaced = is.placeOrders();
        if (orderPlaced) {
            System.out.println("Entire Orders successfully placed.");
        }
    }

    public void payCashiers(TimeTrackingSystem tts, PayrollSystem ps) {
        tts.generatePayslips();
        boolean processSuccessful = ps.process(tts.getPayslips());
        if (processSuccessful) {
            System.out.println("Cashiers successfully paid.");
        }
    }

    public boolean paySalary(double amount) {
        // a different way to pay a manager from cashiers (outside of scope)
        return true;
    }

    public void resolveComplaint() {
        System.out.println("Manager resolves the complaint.");
    }

    public boolean checkReport(BasicSystem bs) {
        // tts displays a report in the GUI and also returns true if an issue exists
        // false otherwise.
        boolean hasIssue = bs.displayReport();
        return hasIssue;
    }

    public boolean resolveIssues(BasicSystem bs) {
        boolean resolved = bs.resolveIssues();
        return resolved;
    }

}
