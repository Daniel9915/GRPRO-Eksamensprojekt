package Domain;
import java.util.ArrayList;
public interface MediaRegistry{
   void initialize();
   
   void addFavorite(String name);
   void removeFavorite(String name);
   
   ArrayList<Media> sortMedia(String sortingType);
   ArrayList<Media> searchMedia(String search);
   ArrayList<Media> getMedia(String type);
   
}
