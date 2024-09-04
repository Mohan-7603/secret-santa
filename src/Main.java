import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Input CSV files
        String currentYearCSV = "input/Employee-List.csv";
        String previousYearCSV = "input/Secret-Santa-Game-Result-2023.csv";
        String outputCSV = "output/secret_santa_assignments.csv";

        // Read input data
        CSVReader<List<Employee>> employeeReader = new EmployeeCSVReader();
        List<Employee> employees = employeeReader.read(currentYearCSV);

        CSVReader<Map<String, String>> previousAssignmentsReader = new PreviousAssignmentsCSVReader();
        Map<String, String> previousAssignments = previousAssignmentsReader.read(previousYearCSV);

        // Assign Secret Santas
        SecretSantaAssigner assigner = new SecretSantaAssigner();
        List<Assignment> assignments = assigner.assignSecretSanta(employees, previousAssignments);

        // Write output data
        CSVWriter writer = new AssignmentCSVWriter();
        writer.write(assignments, outputCSV);
    }
}
