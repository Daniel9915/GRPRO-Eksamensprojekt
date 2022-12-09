package Domain;
import java.util.HashSet;

public abstract class Media{
    String name;
    int startYear;
    HashSet<String> genre;
    double rating;
    String imgPath;
    
    public Media(String name, int startYear, HashSet<String> genre, double rating, String imgPath){
        this.name = name;
        this.startYear = startYear;
        this.genre = genre;
        this.rating = rating;
        this.imgPath = imgPath;
    }
    
}