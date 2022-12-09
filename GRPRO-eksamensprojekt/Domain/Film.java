package Domain;
import java.util.HashSet;

public class Film extends Media{
    public Film (String name, int startYear, HashSet<String> genre, double rating, String imgPath){
        super(name, startYear, genre, rating, imgPath);
    }
}