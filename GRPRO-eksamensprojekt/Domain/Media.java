package Domain;
import java.util.HashSet;

public abstract class Media{
    protected String name;
    protected int startYear;
    protected HashSet<String> genre;
    protected double rating;
    protected String imgPath;
    protected String raw;
    protected boolean fav;
    
    public Media(String name, int startYear, HashSet<String> genre, double rating, String imgPath, String raw){
        this.name = name;
        this.startYear = startYear;
        this.genre = genre;
        this.rating = rating;
        this.imgPath = imgPath;
        this.raw = raw;
    }
    
    public String getImgPath(){
        return imgPath;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean getFav(){
        return fav;
    }
    
    public int getStartYear(){
        return startYear;
    }
    
    public void changeFav(boolean change){
        fav = change;
    }
    
    public double getRating(){
        return rating;
    }
    
    public HashSet<String> getGenre(){
        return genre;
    }
}