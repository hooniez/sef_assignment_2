abstract class BasicSystem {
    public abstract boolean displayReport();

    // Each system obviously has its own way of resolving issues.
    // However, the dummy code focuses on high-level behaviour.
    public boolean resolveIssues() {
        return true;
    }
}
