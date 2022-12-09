package Domain;

import java.util.ArrayList;
import java.util.List;

import Data.*;

public class MediaRegistryImpl implements MediaRegistry{
    DataAccess data;
    protected List<String> film;
    protected List<String> serier;
    protected List<String> favorit;
    
    public MediaRegistryImpl(){
        data = new DataAccessImpl();
        initialize();

    }

    public void initialize(){
        film = data.load("./MovieData/serier.txt");
        serier = data.load("./MovieData/serier.txt");
        favorit = data.load("./MovieData/favorit.txt");
        //Billeder
    }

    public void addFavorite(String name){
    }

    public void removeFavorite(String name){
    }

    public ArrayList<Media> sortMedia(String sortingType){
        if(sortingType == "rating"){
            
        }
        if(sortingType == "genre"){
            
        }
        if(sortingType == "alphabetically"){
            
        }
        if(sortingType == "release"){
            
        }
        
        return null;
    }

    public ArrayList<Media> searchMedia(String search){
        return null;
    }

    public ArrayList<Media> getMedia(String type){
        return null;
    }
}