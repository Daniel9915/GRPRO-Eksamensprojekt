package Data;
import java.util.List;
import java.util.ArrayList;

public interface DataAccess{
    public List<String> load(String path);
    public void save (List<String> data, String mediaType);
    
}