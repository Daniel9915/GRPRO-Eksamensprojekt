package Domain;

public class NotASortingTypeException extends Exception{
    
    NotASortingTypeException(String requestedSortingType){
        super("The string " + requestedSortingType + " is not accepted");
    }
    
    String acceptedSortingTypes(){
        return "'rating', 'genre', 'alphabetically', 'release'";
    }
}