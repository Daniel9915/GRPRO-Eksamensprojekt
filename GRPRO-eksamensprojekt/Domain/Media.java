package Domain;
import java.util.HashSet;

public abstract class Media{
    public String name;
    public int startYear;
    public HashSet<String> genre;
    public double rating;
    public String imgPath;
    public String raw;
    public boolean fav;
    
    public Media(String name, int startYear, HashSet<String> genre, double rating, String imgPath, String raw){
        this.name = name;
        this.startYear = startYear;
        this.genre = genre;
        this.rating = rating;
        this.imgPath = imgPath;
        this.raw = raw;

    }
    
}