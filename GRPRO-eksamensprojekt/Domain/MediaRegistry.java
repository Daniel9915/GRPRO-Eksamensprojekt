package Domain;
import java.util.ArrayList;
import java.util.List;
public interface MediaRegistry{
   void initialize();
   
   void addFavorite(Media media);
   void removeFavorite(Media media);
   
   ArrayList<Media> sortMedia(String sortingType, ArrayList<String> genre, boolean releaseDate, boolean alphabetically); 
   ArrayList<Media> searchMedia(String searchString, ArrayList<Media> listToSort);
   ArrayList<Media> getFilm();
   ArrayList<Media> getSeries();
   ArrayList<Media> getFavFilm();
   ArrayList<Media> getFavSeries();
}
