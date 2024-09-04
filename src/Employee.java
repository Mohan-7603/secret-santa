import java.util.Objects;

public class Employee {
    private final String name;
    private final String emailId;

    public Employee(String employee, String emailId) {
        this.name = employee;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee1 = (Employee) o;
        return Objects.equals(name, employee1.name) && Objects.equals(emailId, employee1.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emailId);
    }
}
