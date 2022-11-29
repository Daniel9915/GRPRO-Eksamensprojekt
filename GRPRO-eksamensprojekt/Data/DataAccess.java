package Data;
import java.util.List;

public interface DataAccess{
    public List<String> load();
    public List<String> save();
    
}