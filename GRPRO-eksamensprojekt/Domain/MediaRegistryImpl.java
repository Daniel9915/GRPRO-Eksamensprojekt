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

    
    private ArrayList<Media> getSortingType(String sortingType){
        ArrayList<Media> typeSortedList = new ArrayList<>();
        switch(sortingType){
            case "film":
                typeSortedList = new ArrayList<Media>(getFilm());
            break;
            case "series":
                typeSortedList = new ArrayList<Media>(getSeries());
            break;
            case "favorite film":
                typeSortedList = new ArrayList<Media>(getFavFilm());
            break;
            case "favorite series":
                typeSortedList = new ArrayList<Media>(getFavSeries());
            break;
        }
        return typeSortedList;
    }
    public ArrayList<Media> sortMedia(String sortingType, ArrayList<String> genre, boolean releaseDate, boolean alphabetically){
        //Exceptions
        if(sortingType != "film" && sortingType != "series" && sortingType != "favorite film" && sortingType != "favorite series"){
            throw new NotASortingTypeException(sortingType);
        }
        if(genre.size() != 0){
            for(String g: genre){
                if(g != "Drama" && g != "Romance"&& g != "Crime"&& g != "History"&& g != "Fantasy"&& g != "Family"&& 
                   g != "Adventure"&& g != "Mystery"&& g != "Thriller"&& g != "Horror"&& g != "Sci-fi"&& g != "Musical"&& 
                   g != "Comedy"&& g != "Biography"&& g != "War"&& g != "Action"&& g != "Western"&& g != "Film-Noir"&& 
                   g != "Talk-show"&& g != "Documentary"&& g != "Sport"&& g != "Animation"
                   ){
                    throw new NotAGenreException(g);
                }
            }
        }
        
        if(releaseDate && alphabetically){
            throw new TwoFiltersException();
        }
        
        //Sorting
        ArrayList<Media> finalList = new ArrayList<>();
        ArrayList<Media> typeSortedList = getSortingType(sortingType);
        
        //Sort genres
        HashSet<Media> genreSet = new HashSet<>();
        if(genre.size() != 0){
            for(String g: genre){
                for(Media m: typeSortedList){
                    mediaGenreLoop:
                    for(String mg: m.genre){
                        if(mg.equals(g)){
                            genreSet.add(m);
                            break mediaGenreLoop;
                        }
                    }
                }
            }
            finalList = new ArrayList(genreSet);
        }else{
            finalList = new ArrayList(typeSortedList);
        }
        
        //sort release / alphabetically
        if(!releaseDate && !alphabetically){
            return finalList; //if both false, return without more sorting
        }
        if(releaseDate){
            finalList = sortByReleaseDate(finalList);
        }
        if(alphabetically){
            finalList = sortAlphabetically(finalList);
        }
        return finalList;
    }
    
    private ArrayList<Media> sortByReleaseDate(ArrayList<Media> inputList){
        int lowestStartYear;
        ArrayList<Media> newList = new ArrayList<>();
        while(inputList.size() > 0){
            lowestStartYear = inputList.get(0).startYear;
            for(Media m: inputList){
                if(m.startYear < lowestStartYear){
                    lowestStartYear = m.startYear;
                }
            }
            addToList:
            for(Media m: inputList){
                if(m.startYear == lowestStartYear){
                    newList.add(m);
                    inputList.remove(m);
                    break addToList;
                }
            }
        }
        
        return newList;
    }
    
    private ArrayList<Media> sortAlphabetically(ArrayList<Media> inputList){
        ArrayList<Media> letterList = new ArrayList<Media>();
        ArrayList<Media> numberList = new ArrayList<Media>();
        ArrayList<Media> finalList = new ArrayList<Media>();
        
        for(Media m: inputList){
            char firstChar = m.name.charAt(0);
            System.out.println(firstChar);
            if(Character.isLetter(firstChar)){
                letterList.add(m);
            }else if(Character.isDigit(firstChar)){
                numberList.add(m);
            }else{
                System.out.println("It's none of them: " + m.name);  
            }
        }
        
        //Sort the numbers
        System.out.println(numberList.size());
        int lowestNumber;
        while(numberList.size() > 0){
            lowestNumber = Integer.parseInt(Character.toString(numberList.get(0).name.charAt(0)));
            for(Media m: numberList){
                int mNumber = Integer.parseInt(Character.toString(m.name.charAt(0)));
                if(mNumber < lowestNumber){
                    lowestNumber = mNumber;
                }
            }
            addToList:
            for(Media m: numberList){
                int mNumber = Integer.parseInt(Character.toString(m.name.charAt(0)));
                if(mNumber == lowestNumber){
                    finalList.add(m);
                    numberList.remove(m);
                    break addToList;
                }
            }
        }
        
        //Sort alphabetically
        ArrayList<String> strList = new ArrayList<String>();
        for(Media m: letterList){
            strList.add(m.name);
            
        }
        strList.sort(String::compareToIgnoreCase);
        for(String s: strList){
            mediaLoop:
            for(Media m: letterList){
                if(s.equals(m.name)){
                    finalList.add(m);
                    break mediaLoop;
                }
            }
        }
        
        return finalList;
    }

    public ArrayList<Media> searchMedia(String sortingType, String searchString){
        if(sortingType != "film" && sortingType != "series" && sortingType != "favorite film" && sortingType != "favorite series"){
            throw new NotASortingTypeException(sortingType);
        }
        ArrayList<Media> typeSortedList = getSortingType(sortingType);
        ArrayList<Media> finalList = new ArrayList<>();
        mediaLoop:
        for(Media m: typeSortedList){
            if(m.name.equals("The Good, The Bad And The Ugly")){
                System.out.println();
            }
            int charCounter = -1;
            charLoop:
            for(char c: m.name.toCharArray()){
                
                charCounter++;
                if(Character.toLowerCase(c) == Character.toLowerCase(searchString.charAt(0))){
                    int searchStringIndex = 0;
                    for(int i = charCounter; i<searchString.length()+charCounter; i++){
                        try{
                            if(Character.toLowerCase(m.name.charAt(i)) == Character.toLowerCase(searchString.charAt(searchStringIndex))){
                            if(searchStringIndex == searchString.length()-1){
                                finalList.add(m);
                                continue mediaLoop;
                            }
                            searchStringIndex++;
                            }else{
                                continue charLoop;
                            }
                        }catch(StringIndexOutOfBoundsException e){
                            continue mediaLoop;
                        }
                    }
                }else{
                    continue charLoop;
                }
            }
        }
        return finalList;
    }

    private List<Film> initFilm(List<String> data){
        List<Film> returnFilm = new ArrayList<Film>();
        for(String d : data){
            String[] contents = d.split(";");

            String name = contents[0];

            int startYear = Integer.parseInt(contents[1].replace(" ", ""));

            String[] genres = contents[2].replace(" ", "").split(",");
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

            String[] genres = contents[2].replace(" ", "").split(",");
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


}