import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AssignmentCSVWriter implements CSVWriter<Assignment> {

    @Override
    public void write(List<Assignment> assignments, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write header
            writer.write("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID");
            writer.newLine();

            // Write each assignment
            for (Assignment assignment : assignments) {
                writer.write(String.format("%s,%s,%s,%s",
                        assignment.getEmployee().getName(),
                        assignment.getEmployee().getEmailId(),
                        assignment.getSecretChild().getName(),
                        assignment.getSecretChild().getEmailId()));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
