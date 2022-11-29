package Presentation; 

import Domain.*;

public class StreamingUI{
    public static void main(String[] args){
        MediaRegistry registry = new MediaRegistryImpl();
        registry.initialize();
        
    }
    
}