public class App {
    public static void main(String[] args) throws Exception {
        // Use case 1: the customer makes a complaint
        Customer cust = new Customer();
        Manager mngr = new Manager();
        cust.complain(mngr);
        System.out.println();

        // Use Case 2: the manager pays salary to cashier
        // Assuming there are 19 cashiers on the roster, create 19 cashiers
        // with the same hourlyWage of 20 dollars.
        Cashier[] cashiers = createDummyCashiers(19, 20);
        // Create a time tracking system that tracks the clock-ins and outs of the
        // cashiers
        TimeTrackingSystem tts = new TimeTrackingSystem(cashiers);
        PayrollSystem ps = new PayrollSystem();
        // Assume tts.run() runs and stores data necessary to pay salary to the cashier
        // in real life applications
        // However, here in this code run() assigns a random number within a reasonable
        // range of bi-weekly work hours to each cashier's workedHours.
        tts.run();
        // Now that the cashiers have their workedHours, the series of actions depicted
        // in the sequence diagram can be codified.
        boolean ttsHasIssue = mngr.checkReport(tts);
        // The loop will never be entered in this dummy code.
        if (ttsHasIssue) {
            boolean resolved = mngr.resolveIssues(tts);
            if (resolved) {
                ttsHasIssue = false;
            }
        }
        // The loop will always be entered in this dummy code.
        if (!ttsHasIssue) {
            mngr.payCashiers(tts, ps);
        }
        System.out.println();

        // Use Case 3: the manager looks after the inventory of the store.
        // Generate a dummy inventory with 1000 items in it.
        InventorySystem is = new InventorySystem();
        boolean isHasIssue = mngr.checkReport(is);
        // The loop will never be entered in this dummy code.
        if (isHasIssue) {
            boolean resolved = mngr.resolveIssues(tts);
            if (resolved) {
                isHasIssue = false;
            }
        }
        // The loop will always be entered in this dummy code.
        if (!isHasIssue) {
            mngr.lookAfterInventory(is);
        }
        System.out.println();

    }

    public static Cashier[] createDummyCashiers(int numCashiers, double hourlyWage) {
        Cashier[] cashiers = new Cashier[numCashiers];
        for (int i = 0; i < numCashiers; ++i) {
            cashiers[i] = new Cashier(i, hourlyWage);
        }
        return cashiers;
    }
}
