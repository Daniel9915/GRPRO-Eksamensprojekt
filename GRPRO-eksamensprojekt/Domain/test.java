package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;
import Data.*;

class test{
    public static void main(){
        MediaRegistry test = new MediaRegistryImpl();
        DataAccess data = new DataAccessImpl();
        
        test.addFavorite(test.getFilm().get(2));
        test.addFavorite(test.getFilm().get(3));
        
        test.removeFavorite(test.getFilm().get(3));
        
        //Film testFilm = new Film("hej", 2, new HashSet<String>(Arrays.asList("a", "b", "c")), 0.2, "aa", "aa");
        //test.addFavorite(testFilm);
        
        List<String> testList = data.load("favFilm.txt");
        
        System.out.println(test.getFavFilm());
        
        
        //System.out.println(test.getFilm().get(2).raw);
        
        //test.data.save(test.getFavFilm(), "film");
        
    }
    
}