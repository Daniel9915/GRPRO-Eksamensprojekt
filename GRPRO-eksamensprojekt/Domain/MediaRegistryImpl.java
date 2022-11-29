package Domain;

import java.util.ArrayList;

import Data.*;

public class MediaRegistryImpl implements MediaRegistry{
    
    public MediaRegistryImpl(){
        DataAccess data = new DataAccessImpl();
        data.load("Test");
        data.load("Test");
        
    }
    
    public void initialize(){
        //Loads stuff
        
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