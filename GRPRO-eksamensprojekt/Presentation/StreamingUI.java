package Presentation; 

import Domain.*;
import java.util.ArrayList;

public class StreamingUI{
    public static void main(String[] args){
        MediaRegistry registry = new MediaRegistryImpl();
        registry.initialize();
        
        //TESTING SORT MEDIA \/
        
        ArrayList<String> testGenre = new ArrayList<>();
        testGenre.add("Sci-fi");
        testGenre.add("Drama");
        //testGenre.add("Adventure");
        //testGenre.add("History");
        //testGenre.add("Biography");
        
        /*System.out.println("WHOLE LIST: ");
        for(Film f: registry.getFilm()){
            System.out.print("Name: " + f.name + " Genre: ");
            for(String g: f.genre){
                System.out.print(g + ", ");
            }
            System.out.println();
        }*/
        
        
        System.out.println();
        System.out.println("SORTED LIST:");
        System.out.println();
        for(Media m: registry.sortMedia("film",testGenre, false, false)){
            System.out.print("Name: " + m.name + " Genre: ");
            for(String g: m.genre){
                System.out.print(g + ", ");
            }
            System.out.println();
        }
        
        
        //TESTING SORT MEDIA /\
    }
    
}