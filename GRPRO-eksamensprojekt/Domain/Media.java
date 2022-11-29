package Domain;
import java.util.HashSet;

public abstract class Media{
    String name;
    int startYear;
    HashSet<String> genre;
    double rating;
    String imgPath;
}