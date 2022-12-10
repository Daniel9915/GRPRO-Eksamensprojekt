package Domain;
import java.util.HashSet;

public class Film extends Media{
    public Film (String name, int startYear, HashSet<String> genre, double rating, String imgPath, String raw){
        super(name, startYear, genre, rating, imgPath, raw);
    }
}