import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviousAssignmentsCSVReader implements CSVReader<Map<String,String>>{

    @Override
    public Map<String, String> read(String fileName) {
            Map<String,String> previousAssignments = new HashMap<>();
            try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
                String line;
                while((line = br.readLine()) != null){
                    String[] data = line.split(",");
                    if (data.length > 3) {
                        previousAssignments.put(data[1], data[3]);
                    }                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            return previousAssignments;
    }
}
