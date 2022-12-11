package Domain;

public class NotASortingTypeException extends RuntimeException{
    
    NotASortingTypeException(String requestedSortingType){
        super("The sortingtype " + requestedSortingType + " is not accepted");
    }
    
    String acceptedSortingTypes(){
        return "Accepted sortingtypes: 'film', 'series', 'favorites'";
    }
}