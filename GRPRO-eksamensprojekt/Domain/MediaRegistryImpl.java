package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

import Data.*;

public class MediaRegistryImpl implements MediaRegistry{
    DataAccess data;

    protected List<String> filmData;
    protected List<Film> filmList = new ArrayList<Film>();

    protected List<String> favFilmData;
    protected List<Film> favFilmList = new ArrayList<Film>();

    protected List<String> seriesData;
    protected List<Series> seriesList = new ArrayList<Series>();

    protected List<String> favSeriesData;
    protected List<Series> favSeriesList = new ArrayList<Series>();

    public MediaRegistryImpl(){
        data = new DataAccessImpl();
        filmData = data.load("film.txt");
        seriesData = data.load("series.txt");
        favFilmData = data.load("favFilm.txt");
        favSeriesData = data.load("favSeries.txt");

        initialize();

    }

    public void initialize(){
        filmList = initFilm(filmData);
        favFilmList = initFilm(favFilmData);

        seriesList = initSeries(seriesData);
        favSeriesList = initSeries(favSeriesData);

        //Billeder
    }

    public ArrayList<Media> sortMedia(String sortingType, String genre, boolean releaseDate, boolean alphabetically){
        if(sortingType != "film" && sortingType != "series" && sortingType != "favorite film" && sortingType != "favorite series"){
            throw new NotASortingTypeException(sortingType);
        }
        if(genre != "Drama" && genre != "Romance"&& genre != "Crime"&& genre != "History"&& genre != "Fantasy"&& genre != "Family"&& 
        genre != "Adventure"&& genre != "Mystery"&& genre != "Thriller"&& genre != "Horror"&& genre != "Sci-fi"&& genre != "Musical"&& 
        genre != "Comedy"&& genre != "Biography"&& genre != "War"&& genre != "Action"&& genre != "Western"&& genre != "Film-Noir"&& 
        genre != "Talk-show"&& genre != "Documentary"&& genre != "Sport"&& genre != "Animation"){
            throw new NotAGenreException(genre);
        }
        if(releaseDate && alphabetically){
            throw new TwoFiltersException();
        }

        ArrayList<Media> finalList = new ArrayList<>();
        ArrayList<Media> tempList = new ArrayList<>();
        switch(genre){
            case "film":
                tempList = new ArrayList<Media>(getFilm());
            break;
            case "series":
                tempList = new ArrayList<Media>(getSeries());
            break;
            case "favorite film":
                tempList = new ArrayList<Media>(favFilmList);
            break;
            case "favorite series":
                tempList = new ArrayList<Media>(favSeriesList);
            break;
        }
        
        
        
        
        return null;
    }

    public ArrayList<Media> searchMedia(String sortingType){
        return null;
    }

    public ArrayList<Film> getFilm(){
        return new ArrayList<Film>(filmList);
    }

    public ArrayList<Series> getSeries(){
        return new ArrayList<Series>(seriesList);
    }

    public ArrayList<Film> getFavFilm(){
        return new ArrayList<Film>(favFilmList);
    }

    public ArrayList<Series> getFavSeries(){
        return new ArrayList<Series>(favSeriesList);
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

    private List<Series> initSeries(List<String> data){
        List<Series> returnSeries = new ArrayList<Series>();
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

            Series s = new Series(name, startYear, genre, rating, imgPath, sd, endYear, seasonsEp);
            returnSeries.add(s);
        }

        return returnSeries;
    }

    public void addFavorite(Media media){
        if (media instanceof Film){
            for(Film f : favFilmList){
                if (f.name.equals(media.name)){//need change
                    return;
                    //throw new AlreadyInFavoritesException(media);//idk man
                }
            }
            Film film = (Film) media;
            favFilmList.add(film);
            data.save(filmToRaw(favFilmList), "film");
        }else if (media instanceof Series){
            for(Series s : favSeriesList){
                if (s.name.equals(media.name)){
                    return;
                    //throw new AlreadyInFavoritesException(media);
                }
            }
            Series series = (Series) media;
            favSeriesList.add(series);
            data.save(seriesToRaw(favSeriesList), "series");
        }
    }

    public void removeFavorite(Media media){
        if (media instanceof Film){
            for(Film f : favFilmList){
                if (f.name.equals(media.name)){
                    favFilmList.remove(f);
                    data.save(filmToRaw(favFilmList), "film");
                    return;
                }
            }
        }else if (media instanceof Series){
            for(Series s : favSeriesList){
                if (s.name.equals(media.name)){
                    favSeriesList.remove(s);
                    data.save(seriesToRaw(favSeriesList), "series");
                    return;
                }
            }
        }
    }

    private List<String> filmToRaw(List<Film> film){//hmm
        List<String> returnString = new ArrayList<>();
        for(Film f : film){
            returnString.add(f.raw);
        }
        return returnString;
    }

    private List<String> seriesToRaw(List<Series> series){//hmm
        List<String> returnString = new ArrayList<>();
        for(Series s : series){
            returnString.add(s.raw);
        }
        return returnString;
    }

    


}