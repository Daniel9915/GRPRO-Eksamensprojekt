package Data;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataAccessImpl implements DataAccess{
    
    public DataAccessImpl(){
        
    }
    
    @Override
    public List<String> load(String path){
        List<String> result = new ArrayList<>();
        
        try{
            File loadFile = new File(path);
            Scanner s = new Scanner(loadFile);
            while(s.hasNextLine())
            {
                result.add(s.nextLine());
            }
            s.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Nothing found. Returning empty result.");
        }
        
        return result;
    }

    public void save (List<String> data){
        try {
            File f = new File("favorites.txt");
            PrintWriter pw = new PrintWriter(f);
            for(String d : data)
            {
                pw.println(d);
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No file. Saving nothing.");
        }
    }
}