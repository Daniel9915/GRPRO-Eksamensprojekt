package Data;
import java.util.List;

public interface DataAccess{
    public List<String> load(String path);
    public void save (List<String> data);
    
}