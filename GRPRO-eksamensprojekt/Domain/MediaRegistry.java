package Domain;
import java.util.ArrayList;
import java.util.List;
public interface MediaRegistry{
   void initialize();
   
   void addFavorite(Media media);
   void removeFavorite(Media media);
   
   // hvis "ArrayList<String> genre" er tom, så er det alle genres
   ArrayList<Media> sortMedia(String sortingType, ArrayList<String> genre, boolean releaseDate, boolean alphabetically); 
   ArrayList<Media> searchMedia(String sortingType, String searchString, ArrayList<Media> listToSort);
   ArrayList<Media> getFilm();
   ArrayList<Media> getSeries();
   ArrayList<Media> getFavFilm();
   ArrayList<Media> getFavSeries();
}
