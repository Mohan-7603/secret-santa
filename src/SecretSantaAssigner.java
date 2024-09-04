import java.util.*;

public class SecretSantaAssigner {

    public List<Assignment> assignSecretSanta(List<Employee> employees, Map<String, String> previousAssignments) {
        List<Assignment> assignments = new ArrayList<>();
        List<Employee> remaining = new ArrayList<>(employees);
        Collections.shuffle(remaining);

        Map<String, Employee> assignedChildren = new HashMap<>();

        for (Employee employee : employees) {
            Employee secretChild = findValidSecretChild(employee, remaining, previousAssignments, assignedChildren);
            assignments.add(new Assignment(employee, secretChild));
            remaining.remove(secretChild);
            assignedChildren.put(employee.getEmailId(), secretChild);
        }

        return assignments;
    }

    private Employee findValidSecretChild(Employee employee, List<Employee> remaining,
                                          Map<String, String> previousAssignments,
                                          Map<String, Employee> assignedChildren) {
        Collections.shuffle(remaining);

        for (Employee potentialChild : remaining) {
            if (!employee.equals(potentialChild)
                    && !previousAssignments.getOrDefault(employee.getEmailId(), "").equals(potentialChild.getEmailId())
                    && !assignedChildren.containsValue(potentialChild)) {
                return potentialChild;
            }
        }

        throw new IllegalStateException("No valid Secret Santa Assignment found for employee: " + employee.getName());
    }
}
