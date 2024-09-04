import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCSVReader implements CSVReader<List<Employee>>{

    @Override
    public List<Employee> read(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(" ");
                if (data.length >= 2) {
                    employees.add(new Employee(data[0], data[1]));
                }            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

}
