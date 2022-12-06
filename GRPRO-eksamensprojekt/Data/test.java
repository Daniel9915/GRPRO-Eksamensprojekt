package Data;

import java.util.ArrayList;
import java.util.List;

class test{
    
    public static void main(){
        DataAccessImpl test = new DataAccessImpl();
        
        List<String> testList = test.load("film.txt");
        
        System.out.println(testList);
        
        test.save(testList);
        
    }
    
}