package Presentation;

import Domain.*;//idk where but need

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MainPage extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

    MainPage(List<Media> startSelection){
        //Creating the frame for GUI elements to exist in
        JFrame frame = new JFrame();
        
        
        //Cosmetics
        frame.setTitle("Netflix 2.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("something.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(50,50,50)); //0xFFFFFF for hexcolor code

        //Frame size and functions
        
        frame.setPreferredSize(new Dimension(screenWidth+15, screenHeight+15));
        frame.setResizable(false);
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

        topPanel.setPreferredSize(new Dimension(200,150));
        centerPanel.setPreferredSize(new Dimension(200,200));
        leftPanel.setPreferredSize(new Dimension(200,200));
        rightPanel.setPreferredSize(new Dimension(200,200));

        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(centerPanel,BorderLayout.CENTER);
        frame.add(leftPanel,BorderLayout.WEST);
        frame.add(rightPanel,BorderLayout.EAST);

        //TOPPANELS
        JPanel topLeft = new JPanel();
        JPanel topCenter = new JPanel();
        JPanel topRight = new JPanel();

        topPanel.setLayout(new GridLayout(1,3));

        //TOP LEFT
        topLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 10,40));
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
        movieButt.setFocusable(false);

        JButton serieButt = new JButton("Series");
        serieButt.setBackground(new Color(50,50,50));
        serieButt.setForeground(Color.red);
        serieButt.setFocusable(false);

        JButton favoriteButt = new JButton("Favorites");
        favoriteButt.setBackground(new Color(50,50,50));
        favoriteButt.setForeground(Color.red);
        favoriteButt.setFocusable(false);

        topCenterTop.add(movieButt);
        topCenterTop.add(serieButt);
        topCenterTop.add(favoriteButt);
        topCenter.add(topCenterTop);

        //TOP CENTER BOTTOM
        String[] genres = {"Sort by", "Drama", "Romance", "Crime", "History", "Fantasy", "Family", "Adventure", "Mystery", "Thriller", "Horror", "Sci-fi", "Musical", "Comedy", "Biography", "War", "Action", "Western", "Film-Noir", "Talk-show", "Documentary", "Sport", "Animation"};

        //combobox
        JComboBox genreBox = new JComboBox(genres);
        genreBox.setFocusable(false);
        genreBox.setBackground(new Color(50,50,50));
        genreBox.setForeground(Color.red);

        //checkmarks
        JCheckBox releaseCheck = new JCheckBox("Release date");
        releaseCheck.setFocusable(false);
        JCheckBox alphaCheck = new JCheckBox("Alphabetical");
        alphaCheck.setFocusable(false);

        topCenterBot.add(genreBox);
        topCenterBot.add(releaseCheck);
        topCenterBot.add(alphaCheck);
        topCenter.add(topCenterBot);

        //TOP RIGHT

        JTextField searchBar = new JTextField();
        searchBar.setColumns(20);

        JLabel searchText = new JLabel("Search");

        topRight.add(searchText);
        topRight.add(searchBar);

        //Finishing touches hoho
        topPanel.add(topLeft);
        topPanel.add(topCenter);
        topPanel.add(topRight);

        
        
        //Center
        
        JPanel scrollPanel = createScrollPanel(centerPanel, 14, 8);
        
        fillDisplay(startSelection, scrollPanel);
        
        
        frame.pack();
        frame.setVisible(true);

        //Combo box/drop down list used for sorting media
        //String[][] movies = {}
        //JComboBox comboBox = new JComboBox();

        //JButtons used to display all the media
    }
    
    private void fillDisplay(List<Media> displayList, JPanel displayPanel){
        clearDisplay(displayPanel);
        for(Media m : displayList){
            JPanel display = new JPanel();
            display.setLayout(new BorderLayout());//to put text under img
            
            ImageIcon imgIcon = new ImageIcon("MovieData"+File.separator+"filmplakater"+File.separator+m.imgPath);
            JButton img = new JButton(imgIcon);
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setContentAreaFilled(false);
            img.setBorderPainted(false);
            img.addActionListener(e -> {
                clearDisplay(displayPanel);
                
                
                displayPanel.setLayout(new BorderLayout());
                
                makeMediaEntry(m, displayPanel);
                //fillDisplay(displayList, displayPanel);
                //fillDisplay(new ArrayList<Media>(){{add(displayList.get(1)); add(displayList.get(0));}},displayPanel);
            });
            
            
            display.add(img, BorderLayout.NORTH);
            
            JLabel text = new JLabel(m.name);
            text.setPreferredSize(new Dimension(10, 15));
            text.setHorizontalAlignment(JLabel.CENTER);
            
            display.add(text, BorderLayout.SOUTH);
            
            displayPanel.add(display);

        }
    }
    
    private JPanel createScrollPanel(JPanel panel, int columns, int rows){
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new GridLayout(columns, rows));//might cause problem but hey
        
        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setPreferredSize(new Dimension(screenWidth-400, screenHeight));
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        panel.add(scrollPane);
        
        return scrollPanel;
    }
    
    private void makeMediaEntry(Media media, JPanel panel){
        JPanel top = new JPanel();
        JPanel center = new JPanel();
        JPanel bot = new JPanel();
        
        top.setPreferredSize(new Dimension(200,50));
        center.setPreferredSize(new Dimension(200,200));
        bot.setPreferredSize(new Dimension(200,200));

        //add name to top
        JLabel nameLabel = new JLabel(media.name);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        
        //add fake player clickable
        ImageIcon imgIcon = new ImageIcon("MovieData"+File.separator+"netflixDisplay14.png");
        JButton img = new JButton(imgIcon);
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setContentAreaFilled(false);
        img.setBorderPainted(false);
        
        
        
        
        //add media details
        JLabel details = new JLabel("Genre: " + media.genre, SwingConstants.LEFT);//continue here
        JLabel details2 = new JLabel("Release year: " + media.startYear);
        details2.setPreferredSize(new Dimension(1000, 15));
        details2.setAlignmentX(0.0f);
        details2.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        top.add(nameLabel);
        center.add(img);
        center.add(details);
        center.add(details2);
        
        

        panel.add(top,BorderLayout.NORTH);
        panel.add(center,BorderLayout.CENTER);
        panel.add(bot, BorderLayout.SOUTH);
    }
    
    private void clearDisplay(JPanel display){
        display.removeAll();
        display.revalidate();
        display.repaint();
    }

    
}