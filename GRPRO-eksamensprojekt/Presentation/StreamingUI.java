package Presentation; 

import Domain.*;
import java.util.ArrayList;

public class StreamingUI{
    public static void main(String[] args){
        MediaRegistry registry = new MediaRegistryImpl();
        registry.initialize();
        
        MainPage mainPage = new MainPage(registry);
    }   
}