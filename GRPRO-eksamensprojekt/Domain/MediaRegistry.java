package Domain;
import java.util.ArrayList;
import java.util.List;
public interface MediaRegistry{
   void initialize();
   
   void addFavorite(Media media);
   void removeFavorite(Media media);
   
   ArrayList<Media> sortMedia(String sortingType, String genre, boolean releaseDate, boolean alphabetically);
   ArrayList<Media> searchMedia(String search);
   ArrayList<Film> getFilm();
   ArrayList<Series> getSeries();
   ArrayList<Film> getFavFilm();
   ArrayList<Series> getFavSeries();
}
