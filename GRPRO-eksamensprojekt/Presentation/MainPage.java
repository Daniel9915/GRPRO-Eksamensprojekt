package Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MainPage extends JFrame {
    MainPage(){
        //Creating the frame for GUI elements to exist in
        JFrame frame = new JFrame();

        //Cosmetics
        frame.setTitle("Netflix 2.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("something.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(50,50,50)); //0xFFFFFF for hexcolor code

        //Frame size and functions
        frame.setResizable(false);
        frame.setSize(1000,1000);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes application fullscreen

        //////////////////
        //Frame contents//
        //////////////////

        //Panel creation
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        topPanel.setBackground(new Color(55,55,55));
        centerPanel.setBackground(new Color(45,45,45));
        leftPanel.setBackground(new Color(65,65,65));
        rightPanel.setBackground(new Color(40,40,40));

        topPanel.setPreferredSize(new Dimension(200,200));
        centerPanel.setPreferredSize(new Dimension(200,200));
        leftPanel.setPreferredSize(new Dimension(200,200));
        rightPanel.setPreferredSize(new Dimension(200,200));

        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(centerPanel,BorderLayout.CENTER);
        frame.add(leftPanel,BorderLayout.WEST);
        frame.add(rightPanel,BorderLayout.EAST);

        //PANELS
        JPanel topLeft = new JPanel();
        JPanel topCenter = new JPanel();
        JPanel topRight = new JPanel();

        topPanel.setLayout(new GridLayout(1,3));

        
        //TOP LEFT
        topLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 10,100));
        JLabel logoLabel = new JLabel("");
        ImageIcon logo = new ImageIcon("NETFLIX.png");
        logoLabel.setIcon(logo);
        topLeft.add(logoLabel);

        //TOP CENTER 

        JPanel topCenterTop = new JPanel();
        topCenterTop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JPanel topCenterBot = new JPanel();
        topCenterBot.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        topCenter.setLayout(new GridLayout(2,1));

        
        //TOP CENTER TOP
        JButton movieButt = new JButton("Movies");

        movieButt.setPreferredSize(new Dimension(75,50));
        movieButt.setBackground(new Color(50,50,50));
        movieButt.setForeground(Color.red);

        JButton serieButt = new JButton("Series");
        serieButt.setBackground(new Color(50,50,50));
        serieButt.setForeground(Color.red);

        JButton favoriteButt = new JButton("Favorites");
        favoriteButt.setBackground(new Color(50,50,50));
        favoriteButt.setForeground(Color.red);

        topCenterTop.add(movieButt);
        topCenterTop.add(serieButt);
        topCenterTop.add(favoriteButt);
        topCenter.add(topCenterTop);

        //TOP CENTER BOTTOM
        String[] genres = {"Sort by", "Drama", "Romance", "Crime", "History", "Fantasy", "Family", "Adventure", "Mystery", "Thriller", "Horror", "Sci-fi", "Musical", "Comedy", "Biography", "War", "Action", "Western", "Film-Noir", "Talk-show", "Documentary", "Sport", "Animation"};
        
        //combobox
        JComboBox genreBox = new JComboBox(genres);
        genreBox.setBackground(new Color(50,50,50));
        genreBox.setForeground(Color.red);

        //checkmarks
        JCheckBox releaseCheck = new JCheckBox("Release date");
        JCheckBox alphaCheck = new JCheckBox("Alphabetical");


        topCenterBot.add(genreBox);
        topCenterBot.add(releaseCheck);
        topCenterBot.add(alphaCheck);
        topCenter.add(topCenterBot);

        //TOP RIGHT
        
        topPanel.add(topLeft);
        topPanel.add(topCenter);
        topPanel.add(topRight);

        
        frame.setVisible(true);

        //Title and logo
        /*JLabel title = new JLabel("");
        frame.add(title); //Required to make label visible

        ImageIcon logo = new ImageIcon("NETFLIX 2.0.png");
        title.setIcon(logo);
        title.setForeground(Color.white);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.LEFT);
         */

        //Combo box/drop down list used for sorting media
        //String[][] movies = {}
        //JComboBox comboBox = new JComboBox();

        
        //JButtons used to display all the media

    }


    
    
}