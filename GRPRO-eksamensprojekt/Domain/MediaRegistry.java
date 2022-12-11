package Domain;
import java.util.ArrayList;
import java.util.List;
public interface MediaRegistry{
   void initialize();
   
   void addFavorite(Media media);
   void removeFavorite(String name);
   
   ArrayList<Media> sortMedia(String sortingType, String genre, boolean releaseDate, boolean alphabetically);
   ArrayList<Media> searchMedia(String search);
   List<Film> getFilm();
   List<Serier> getSerier();
   List<Film> getFavFilm();
   List<Serier> getFavSerier();
}
