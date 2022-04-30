abstract class BasicSystem {
    public boolean displayReport() {
        // It is always assumed that there is no issue from the report
        boolean hasIssue = false;
        return hasIssue;
    }

    // Each system obviously has its own way of resolving issues.
    // However, the dummy code focuses on high-level behaviour.
    public boolean resolveIssues() {
        return true;
    }
}
