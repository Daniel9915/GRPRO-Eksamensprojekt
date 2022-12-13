package Data;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class DataAccessImpl implements DataAccess{

    File currentDir = new File(".");
    File parentDir = currentDir.getParentFile();

    public DataAccessImpl(){

    }

    @Override
    public List<String> load(String path){
        List<String> result = new ArrayList<>();

        try{

            File loadFile = new File(parentDir,"MovieData"+File.separator+path);
            Scanner s = new Scanner(loadFile);
            while(s.hasNextLine())
            {
                result.add(s.nextLine());
            }
            s.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Nothing found. Returning empty result.");
        }

        return result;
    }

    public void save (List<String> data, String mediaType){
        if(mediaType.equals("film")){
            try {
                File f = new File(parentDir,"MovieData"+File.separator+"favFilm.txt");
                PrintWriter pw = new PrintWriter(f);
                for(String d : data)
                {
                    pw.println(d);
                }
                pw.close();
            } catch (FileNotFoundException ex) {
                System.out.println("No file. Saving nothing.");
            }
        }else if(mediaType.equals("series")){
            try {
                File f = new File(parentDir,"MovieData"+File.separator+"favSeries.txt");
                PrintWriter pw = new PrintWriter(f);
                for(String d : data)
                {
                    pw.println(d);
                }
                pw.close();
            } catch (FileNotFoundException ex) {
                System.out.println("No file. Saving nothing.");
            }
        }
    }
}