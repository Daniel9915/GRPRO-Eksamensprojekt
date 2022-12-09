package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

import Data.*;

public class MediaRegistryImpl implements MediaRegistry{
    DataAccess data;
    
    protected List<String> filmData;
    protected List<Film> film = new ArrayList<Film>();
    
    protected List<String> serierData;
    protected List<Serier> serier = new ArrayList<Serier>();
    
    protected List<String> favorit;
    
    public MediaRegistryImpl(){
        data = new DataAccessImpl();
        initialize();
        filmData = data.load("film.txt");
        serierData = data.load("serier.txt");
        favorit = data.load("favorit.txt");

    }

    public void initialize(){
        for(String fd : filmData){
            String[] contents = fd.split(";");
            String name = contents[0];
            int startYear = Integer.parseInt(contents[1].replace(" ", ""));
            
            String[] genres = contents[2].replace(" ", "").split(", ");
            HashSet<String> genre = new HashSet<String>();
            for (String g : genres){
                genre.add(g);
            }
            
            double rating = Double.parseDouble(contents[3].replace(",", ".").replace(" ", ""));
            String imgPath = name + ".jpg";
            
            Film f = new Film(name, startYear, genre, rating, imgPath);
            
            film.add(f);
        }
        
        for(String sd : serierData){
            String[] contents = sd.split(";");
            String name = contents[0];
            
            String years[] = contents[1].replace(" ", "").split("-");
            int startYear = Integer.parseInt(years[0]);
            int endYear = 0;
            try{
                endYear = Integer.parseInt(years[1]);
            }catch(Exception e){
                e.getMessage();
            }
            
            
            String[] genres = contents[2].replace(" ", "").split(", ");
            HashSet<String> genre = new HashSet<String>();
            for (String g : genres){
                genre.add(g);
            }
            
            double rating = Double.parseDouble(contents[3].replace(",", ".").replace(" ", ""));
            String imgPath = name + ".jpg";
            
            String[] seasons = contents[4].replace(" ", "").split(",");
            List<Integer> seasonsEp = new ArrayList<Integer>();
            for (String s : seasons){
                String[] episodes = s.split("-");
                seasonsEp.add(Integer.parseInt(episodes[1]));
            }
            
            
            Serier s = new Serier(name, startYear, genre, rating, imgPath, endYear, seasonsEp);
            serier.add(s);
        }
        
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