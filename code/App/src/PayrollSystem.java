import java.util.*;

public class PayrollSystem {
    public boolean process(List<Payslip> payslips) {
        boolean processed = true;
        // try and catch would be necessary in real-life application
        // to catch a failed process opeartion on a payslip
        for (Payslip payslip : payslips) {
            Cashier currCashier = payslip.getCashier();
            boolean paySuccess = currCashier.paySalary(payslip.getAmount());
            if (!paySuccess) {
                processed = false;
            }
        }

        return processed;
    }
}
