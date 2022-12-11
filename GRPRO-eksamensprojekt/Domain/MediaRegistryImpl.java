package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

import Data.*;

public class MediaRegistryImpl implements MediaRegistry{
    DataAccess data;

    protected List<String> filmData;
    protected List<Film> film = new ArrayList<Film>();

    protected List<String> favFilmData;
    protected List<Film> favFilm = new ArrayList<Film>();

    protected List<String> serierData;
    protected List<Serier> serier = new ArrayList<Serier>();

    protected List<String> favSerierData;
    protected List<Serier> favSerier = new ArrayList<Serier>();

    public MediaRegistryImpl(){
        data = new DataAccessImpl();
        filmData = data.load("film.txt");
        serierData = data.load("serier.txt");
        favFilmData = data.load("favFilm.txt");
        favSerierData = data.load("favSerier.txt");

        initialize();

    }

    public void initialize(){
        film = initFilm(filmData);
        favFilm = initFilm(favFilmData);

        serier = initSerier(serierData);
        favSerier = initSerier(favSerierData);

        //Billeder
    }

    private List<Film> initFilm(List<String> data){
        List<Film> returnFilm = new ArrayList<Film>();
        for(String d : data){
            String[] contents = d.split(";");

            String name = contents[0];

            int startYear = Integer.parseInt(contents[1].replace(" ", ""));

            String[] genres = contents[2].replace(" ", "").split(", ");
            HashSet<String> genre = new HashSet<String>();
            for (String g : genres){
                genre.add(g);
            }

            double rating = Double.parseDouble(contents[3].replace(",", ".").replace(" ", ""));

            String imgPath = name + ".jpg";

            Film f = new Film(name, startYear, genre, rating, imgPath, d);

            returnFilm.add(f);
        }

        return returnFilm;
    }

    private List<Serier> initSerier(List<String> data){
        List<Serier> returnSerier = new ArrayList<Serier>();
        for(String sd : data){
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

            Serier s = new Serier(name, startYear, genre, rating, imgPath, sd, endYear, seasonsEp);
            returnSerier.add(s);
        }

        return returnSerier;
    }

    public void addFavorite(Media media){
        if (media instanceof Film){
            for(Film f : favFilm){
                if (f.name.equals(media.name)){//need change
                    return;
                    //throw new AlreadyInFavoritesException(media);//idk man
                }
            }
            Film film = (Film) media;
            favFilm.add(film);
            data.save(filmToRaw(favFilm), "film");
        }else if (media instanceof Serier){
            for(Serier s : favSerier){
                if (s.name.equals(media.name)){
                    return;
                }
            }
            Serier serier = (Serier) media;
            favSerier.add(serier);
            data.save(serierToRaw(favSerier), "film");
        }
    }

    private List<String> filmToRaw(List<Film> film){//hmm
        List<String> returnString = new ArrayList<>();
        for(Film f : film){
            returnString.add(f.raw);
        }
        return returnString;
    }
    
    private List<String> serierToRaw(List<Serier> serier){//hmm
        List<String> returnString = new ArrayList<>();
        for(Serier s : serier){
            returnString.add(s.raw);
        }
        return returnString;
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

    public List<Film> getFilm(){
        return film;
    }

    public List<Serier> getSerier(){
        return serier;
    }

    public List<Film> getFavFilm(){
        return favFilm;
    }

    public List<Serier> getFavSerier(){
        return favSerier;
    }
}