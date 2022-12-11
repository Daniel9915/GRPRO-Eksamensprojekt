package Domain;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Series extends Media{
    int endYear;
    List<Integer> seasonsEp;
    
    public Series(String name, int startYear, HashSet<String> genre, double rating, String imgPath, String raw, int endYear, List<Integer> seasonsEp){
        super(name, startYear, genre, rating, imgPath, raw);
        this.endYear = endYear;
        this.seasonsEp = seasonsEp;
    }
}