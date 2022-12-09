package Domain;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Serier extends Media{
    int endYear;
    List<Integer> seasonsEp;
    
    public Serier(String name, int startYear, HashSet<String> genre, double rating, String imgPath, int endYear, List<Integer> seasonsEp){
        super(name, startYear, genre, rating, imgPath);
        this.endYear = endYear;
        this.seasonsEp = seasonsEp;
    }
}