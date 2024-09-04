public class Assignment {
    private final Employee employee;
    private final Employee secretChild;

    public Assignment(Employee employee, Employee secretChild) {
        this.employee = employee;
        this.secretChild = secretChild;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Employee getSecretChild() {
        return secretChild;
    }

}
