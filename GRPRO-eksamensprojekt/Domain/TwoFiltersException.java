package Domain;

public class TwoFiltersException extends RuntimeException{
    
    TwoFiltersException(){
        super("Release Date and Alphabetically can't both be true");
    }
}