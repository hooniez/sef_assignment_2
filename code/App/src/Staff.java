abstract class Staff {
    protected String name;
    protected int id;
    protected String contactNumber;
    protected String bankAccountInfo;

    public abstract boolean paySalary(double amount);
}
