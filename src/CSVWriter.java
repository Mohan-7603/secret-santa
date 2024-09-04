import java.util.List;

public interface CSVWriter<T> {
    void write(List<T> items,String filename);
}
