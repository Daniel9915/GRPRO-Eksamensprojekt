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

    }

    public void initialize(){
        film = data.load("film.txt");
        serier = data.load("serier.txt");
        favorit = data.load("favorit.txt");
        //Billeder
    }

    public void addFavorite(String name){
    }

    public void removeFavorite(String name){
    }

    public ArrayList<Media> sortMedia(String sortingType){
        return null;
    }

    public ArrayList<Media> searchMedia(String search){
        return null;
    }

    public ArrayList<Media> getMedia(String type){
        return null;
    }
}