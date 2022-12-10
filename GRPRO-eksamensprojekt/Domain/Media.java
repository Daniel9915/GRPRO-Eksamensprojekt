package Domain;
import java.util.HashSet;

public abstract class Media{
    String name;
    int startYear;
    HashSet<String> genre;
    double rating;
    String imgPath;
    String raw;
    
    public Media(String name, int startYear, HashSet<String> genre, double rating, String imgPath, String raw){
        this.name = name;
        this.startYear = startYear;
        this.genre = genre;
        this.rating = rating;
        this.imgPath = imgPath;
        this.raw = raw;
    }
    
}