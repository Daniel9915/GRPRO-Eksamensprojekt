package Presentation; 

import Domain.*;
import java.util.ArrayList;

public class StreamingUI{
    public static void main(String[] args){
        MediaRegistry registry = new MediaRegistryImpl();
        registry.initialize();
        
        MainPage mainPage = new MainPage();
        
    }
    
    public static void testingSortMedia(){
        MediaRegistry registry = new MediaRegistryImpl();
        registry.initialize();
        ArrayList<String> testGenre = new ArrayList<>();
        
        testGenre.add("Drama");
        //testGenre.add("Drama");
        testGenre.add("Adventure");
        //testGenre.add("History");
        //testGenre.add("Biography");
        

        /*
        System.out.println("WHOLE LIST: ");
        for(Film f: registry.getFilm()){
            System.out.print("Name: " + f.name + " Genre: ");
            for(String g: f.genre){
                System.out.print(g + ", ");
            }
            System.out.println();
        }
        */
        
        System.out.println();
        System.out.println("SORTED LIST:");
        System.out.println();
        for(Media m: registry.sortMedia("series",testGenre, true, false)){
            System.out.print("Name: " + m.name);
            System.out.println(" Release Year: " + m.startYear);
            System.out.print("Genre: " );
            for(String g: m.genre){
                System.out.print(g + ", ");
            }
            System.out.println();
            System.out.println();   
        }
    }
    
    public static void testingSearch(){
        MediaRegistry registry = new MediaRegistryImpl();
        registry.initialize();
        ArrayList<Media> testList = new ArrayList<>();
        testList = registry.searchMedia("series", "sa");
        System.out.println(testList.size());        
        for(Media m: testList){
            System.out.println(m.name);
        }
    }
    
}