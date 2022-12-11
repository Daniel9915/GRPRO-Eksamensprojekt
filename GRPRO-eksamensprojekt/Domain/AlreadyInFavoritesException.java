package Domain;

public class AlreadyInFavoritesException extends RuntimeException{
    
    AlreadyInFavoritesException(Media favoritedMedia){
        super("The media " + favoritedMedia.name + " is already in the favorites list");
    }
}