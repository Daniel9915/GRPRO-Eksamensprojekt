package Domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DomainTesting{
    MediaRegistry registry;
    
    @BeforeEach
    public void setUp(){
        registry = new MediaRegistryImpl();
        registry.initialize();
    }
    
    @Test
    public void testSortMediaGenres(){
        String genreToTest = "";
        String movieType = "";
        for(int i = 0; i<10; i++){
            switch(i){
                case 0:
                    genreToTest = "Sci-fi";
                    movieType = "film";
                break;
                case 1:
                    genreToTest = "Sci-fi";
                    movieType = "series";
                break;
                case 2:
                    genreToTest = "Adventure";
                    movieType = "film";
                break;
                case 3:
                    genreToTest = "Adventure";
                    movieType = "series";
                break;
                case 4:
                    genreToTest = "Drama";
                    movieType = "film";
                break;
                case 5:
                    genreToTest = "Drama";
                    movieType = "series";
                break;
                case 6:
                    genreToTest = "Romance";
                    movieType = "film";
                break;
                case 7:
                    genreToTest = "Romance";
                    movieType = "series";
                break;
                case 8:
                    genreToTest = "Biography";
                    movieType = "film";
                break;
                case 9:
                    genreToTest = "Biography";
                    movieType = "series";
                break;
            }
            ArrayList<String> genres = new ArrayList<>();
            genres.add(genreToTest);
            ArrayList<Media> sortedMedia = registry.sortMedia(movieType, genres, true, false);
            for(Media m: sortedMedia){
                boolean foundGenre = false;
                for(String s: m.genre){
                    if(s.equals(genreToTest)){
                        foundGenre = true;
                    }
                }
                if(foundGenre){
                    assertEquals(true,foundGenre);
                }else{
                    fail("The searched genre was not found");
                }
            } 
        }
    }
    
    @Test
    public void testSortMediaNotSortType(){
        ArrayList<String> genres = new ArrayList<>();
        genres.add("Drama");
        try{
            ArrayList<Media> sortedMedia = registry.sortMedia("filmm", genres, false, true);
        }catch(NotASortingTypeException e){
            assertNotNull(e);
        }catch(Exception e){
            fail("Wrong exception: '" + e + "', expected NotASortingTypeException.");
        }
        
    }
    
    @Test
    public void testSortMediaNotGenre(){
        ArrayList<String> genres = new ArrayList<>();
        genres.add("romannnnce");
        try{
            ArrayList<Media> sortedMedia = registry.sortMedia("film", genres, false, true);
            fail("No exception, expected NotAGenreException");
        }catch(NotAGenreException e){
            assertNotNull(e);
        }catch(Exception e){
            fail("Wrong exception: '" + e + "', expected NotAGenreException.");
        }
    }
    
    @AfterEach
    public void tearDown(){
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
