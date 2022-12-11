package Domain;

public class NotAGenreException extends RuntimeException{
    
    NotAGenreException(String requestedSortingType){
        super("The genre " + requestedSortingType + " is not accepted");
    }
    
    String acceptedGenres(){
        return "Accepted genres: 'Drama', 'Romance', 'Crime', 'History', 'Fantasy', 'Family', 'Adventure', 'Mystery', 'Thriller', 'Horror', 'Sci-fi', 'Musical', 'Comedy', 'Biography', 'War', 'Action', 'Western', 'Film-Noir', 'Talk-show', 'Documentary', 'Sport', 'Animation'";
    }
}