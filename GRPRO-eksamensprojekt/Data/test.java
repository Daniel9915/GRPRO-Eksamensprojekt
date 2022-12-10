package Data;

import java.util.ArrayList;
import java.util.List;

class test{
    
    public static void main(){
        DataAccess test = new DataAccessImpl();
        
        List<String> testList = test.load("film.txt");
        
        //System.out.println(testList);
        
        int number = 0;
        for (String e : testList){
            
            
            number++;
            
            System.out.println(number + " " + e);
        }
        
        test.save(testList);
        
    }
    
}