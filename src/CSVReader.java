import java.util.List;

public interface CSVReader<T>{
    T read(String fileName);
}
