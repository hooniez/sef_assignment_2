import java.util.*;

// TimetrackingSystem is assumed to 
// keep track of clock-ins and clock-outs real time and
// updates cashierWorkedHours real time 
// by means of the function called run()
public class TimeTrackingSystem extends BasicSystem {
    private Map<Cashier, Integer> cashierWokredHours;
    private List<Payslip> payslips;

    public TimeTrackingSystem(Cashier[] cashierArr) {
        cashierWokredHours = new HashMap<Cashier, Integer>();
        // cashierWrokedHours keeps track of how many hours each cashier has worked
        for (Cashier cashier : cashierArr) {
            cashierWokredHours.put(cashier, 0);
        }
    }

    // Assign a random number within a reasonable range of bi-weekly work hours to
    // each cashier's workedHours.
    public void run() {
        int maxNumHours = 120; // including overtime
        int minNumHours = 0;
        cashierWokredHours.forEach((k, v) -> {
            v = (int) ((Math.random() * (maxNumHours - minNumHours)) + minNumHours);
            cashierWokredHours.replace(k, v);
        });
    }

    public void addCashier(Cashier cashier) {
    }

    public void generatePayslips() {
        // Create a Payslip for each cashier
        // Since Tabinda said, we are not to create databases, payslips are destructed
        // after the end of the method.
        payslips = new ArrayList<Payslip>();
        cashierWokredHours.forEach((cashier, numHoursWorked) -> {
            // If the cashier worked at least one hour
            if (numHoursWorked > 0) {
                double salary = numHoursWorked * cashier.getHourlyWage();
                payslips.add(new Payslip(cashier, salary));
            }
        });
    }

    public List<Payslip> getPayslips() {
        return payslips;
    }
}
