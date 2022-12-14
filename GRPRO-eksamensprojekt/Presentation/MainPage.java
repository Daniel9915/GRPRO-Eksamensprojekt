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
    Color textColor = Color.WHITE;
    Color bgColor = new Color(50,50,50);
    boolean release = false;
    boolean alpha = false;

    String currentMediaType = "film";
    ArrayList<String> selectedGenreList = new ArrayList<String>();

    MainPage(MediaRegistry registry){
        //Creating the frame for GUI elements to exist in
        JFrame frame = new JFrame();

        //Cosmetics
        frame.setTitle("Netflix 2.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("something.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(bgColor); //0xFFFFFF for hexcolor code

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

        topPanel.setBackground(bgColor);
        centerPanel.setBackground(bgColor);
        leftPanel.setBackground(bgColor);
        rightPanel.setBackground(bgColor);

        topPanel.setPreferredSize(new Dimension(200,150));
        centerPanel.setPreferredSize(new Dimension(200,200));
        leftPanel.setPreferredSize(new Dimension(200,200));
        rightPanel.setPreferredSize(new Dimension(200,200));

        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(centerPanel,BorderLayout.CENTER);
        frame.add(leftPanel,BorderLayout.WEST);
        frame.add(rightPanel,BorderLayout.EAST);

        //CENTER

        //clearDisplay(panel);
        //panel.getParent().removeAll();

        JPanel scrollPanel = new JPanel();
        scrollPanel.setBackground(bgColor);
        scrollPanel.setLayout(new GridLayout(14,8));//might cause problem but hey

        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setPreferredSize(new Dimension(screenWidth-400, screenHeight-200));
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        centerPanel.add(scrollPane);
        fillDisplay(registry.getFilm(), scrollPanel, registry);

        //

        //JPanel scrollPanel = createScrollPanel(centerPanel);

        //JPanel scrollPanelStep = new JPanel();
        //scrollPanelStep.setLayout(new GridLayout(14,8));
        //scrollPanelStep.setPreferredSize(new Dimension(screenWidth-400, screenHeight));

        //fillDisplay(registry.getFilm(), scrollPanel);

        //scrollPanel.add(scrollPanelStep);

        //TOPPANELS
        JPanel topLeft = new JPanel();
        JPanel topCenter = new JPanel();
        JPanel topRight = new JPanel();

        topPanel.setLayout(new GridLayout(1,3));

        topLeft.setBackground(bgColor);
        topCenter.setBackground(bgColor);
        topRight.setBackground(bgColor);

        //TOP LEFT
        topLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 10,40));
        JLabel logoLabel = new JLabel("");
        ImageIcon logo = new ImageIcon("NETFLIX.png");
        logoLabel.setIcon(logo);
        topLeft.add(logoLabel);

        //TOP CENTER 

        JPanel topCenterTop = new JPanel();
        topCenterTop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topCenterTop.setBackground(bgColor);

        JPanel topCenterBot = new JPanel();
        topCenterBot.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topCenterBot.setBackground(bgColor);

        topCenter.setLayout(new GridLayout(2,1));

        //TOP CENTER TOP
        JButton movieButt = new JButton("Movies");
        movieButt.setPreferredSize(new Dimension(75,50));
        movieButt.setBackground(bgColor);
        movieButt.setForeground(textColor);
        movieButt.setFocusable(false);
        

        JButton serieButt = new JButton("Series");
        serieButt.setPreferredSize(new Dimension(75,50));
        serieButt.setBackground(new Color(50,50,50));
        serieButt.setForeground(textColor);
        serieButt.setFocusable(false);
        
        JButton favoriteButt = new JButton("Favorites");
        favoriteButt.setPreferredSize(new Dimension(100,50));
        favoriteButt.setBackground(new Color(50,50,50));
        favoriteButt.setForeground(textColor);
        favoriteButt.setFocusable(false);
        

        

        //TOP CENTER BOTTOM
        String[] genres = {"Sort by", "Drama", "Romance", "Crime", "History", "Fantasy", "Family", "Adventure", "Mystery", "Thriller", "Horror", "Sci-fi", "Musical", "Comedy", "Biography", "War", "Action", "Western", "Film-Noir", "Talk-show", "Documentary", "Sport", "Animation"};
        ArrayList<String> genreList = new ArrayList<String>();
        for(String g : genres){
            genreList.add(g);
            genreList.remove(0);
        }

        //checkmarks
        JCheckBox releaseCheck = new JCheckBox("Release date");
        releaseCheck.setFocusable(false);
        releaseCheck.setSelected(release);
        releaseCheck.setBackground(bgColor);
        releaseCheck.setForeground(textColor);

        JCheckBox alphaCheck = new JCheckBox("Alphabetical");
        alphaCheck.setFocusable(false);
        alphaCheck.setSelected(alpha);        
        alphaCheck.setBackground(bgColor);
        alphaCheck.setForeground(textColor);

        //combobox
        JComboBox genreBox = new JComboBox(genres);
        genreBox.setFocusable(false);
        genreBox.setBackground(bgColor);
        genreBox.setForeground(textColor);

        //actionlisteners
        
        for(String g : genreList){
            selectedGenreList.add(g);
        }
        genreBox.addActionListener(e -> {
                String selectedGenre = (String) genreBox.getSelectedItem();

                if(!selectedGenre.equals("Sort by")){
                    selectedGenreList.clear();
                    selectedGenreList.add(selectedGenre);
                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);//curr
                }else{
                    selectedGenreList.clear();
                    for(String g : genreList){
                        selectedGenreList.add(g);
                    }

                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);//curr
                }
            });

        releaseCheck.addActionListener(e -> {
                if(releaseCheck.isSelected()){
                    alpha=false;
                    release=true;
                    alphaCheck.setSelected(false);

                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);
                    System.out.println("Release on");
                    System.out.println(selectedGenreList);
                }else{
                    release=false;

                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);
                    System.out.println("Release off");
                }
            });

        alphaCheck.addActionListener(e -> {
                if(alphaCheck.isSelected()){
                    alpha=true;
                    release=false;
                    releaseCheck.setSelected(false);

                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);
                    System.out.println("Alpha off");
                    System.out.println(selectedGenreList);
                }else{
                    alpha=false;

                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);
                    System.out.println("Alpha on");
                }
            });
            
            movieButt.addActionListener(e -> {
                if(currentMediaType!="film"){
                    currentMediaType = "film";
                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);
                }
            });
            
            serieButt.addActionListener(e -> {
                if(currentMediaType!="series"){
                    currentMediaType = "series";
                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);
                }
            });
            
            favoriteButt.addActionListener(e -> {
                if(currentMediaType=="film"){
                    currentMediaType = "favorite film";
                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);
                }else if(currentMediaType=="series"){
                    currentMediaType = "favorite series";
                    sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, scrollPanel);
                }
            });


        topCenterTop.add(movieButt);
        topCenterTop.add(serieButt);
        topCenterTop.add(favoriteButt);
        topCenter.add(topCenterTop);
            
            
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
        //JPanel test = new JPanel();
        //centerPanel.add(test);

        frame.pack();
        frame.setVisible(true);

        //Combo box/drop down list used for sorting media
        //String[][] movies = {}
        //JComboBox comboBox = new JComboBox();

        //JButtons used to display all the media
    }

    private void sortAndFill(String type, ArrayList<String> selectedGenreList, boolean release, boolean alpha, MediaRegistry registry, JPanel panel){
        //if(!selectedGenreList.get(0).equals("Sort by")){
            //ArrayList<String> selectedGenreList = new ArrayList<>();
            //selectedGenreList.add(selectedGenre);
            ArrayList<Media> sortedList = registry.sortMedia(type, selectedGenreList, release, alpha);

            int rows = 0;
            if(sortedList.size()%8 == 0){
                rows = sortedList.size()/8;
            }else if(sortedList.size()%8 != 0 && sortedList.size()/8 >= 3){
                rows = (sortedList.size()/8)+1;
            }else if(sortedList.size()%8 != 0 && sortedList.size()/8 < 3){
                rows = (sortedList.size()/8)+2;
            }

            panel.setLayout(new GridLayout(rows,8));

            fillDisplay(sortedList, panel, registry);
        /*}else{
        //ArrayList<String> selectedGenreList = new ArrayList<>();
        //selectedGenreList.add(selectedGenre);
        ArrayList<Media> sortedList = registry.sortMedia(type, selectedGenreList, release, alpha);

        int rows = 0;
        if(sortedList.size()%8 == 0){
        rows = sortedList.size()/8;
        }else if(sortedList.size()%8 != 0 && sortedList.size()/8 >= 3){
        rows = (sortedList.size()/8)+1;
        }else if(sortedList.size()%8 != 0 && sortedList.size()/8 < 3){
        rows = (sortedList.size()/8)+2;
        }

        panel.setLayout(new GridLayout(rows,8));

        fillDisplay(sortedList, panel);
        }*/
    }

    private void fillDisplay(List<Media> displayList, JPanel displayPanel, MediaRegistry registry){
        clearDisplay(displayPanel);
        //System.out.println(displayPanel.getParent());
        for(Media m : displayList){
            JPanel display = new JPanel();
            display.setBackground(bgColor);
            display.setLayout(new BorderLayout());//to put text under img
            ImageIcon imgIcon = new ImageIcon("notfound");
            if(m instanceof Film){
                imgIcon = new ImageIcon("MovieData"+File.separator+"filmplakater"+File.separator+m.imgPath);    
            }else{
                imgIcon = new ImageIcon("MovieData"+File.separator+"serieforsider"+File.separator+m.imgPath);    
            }

            JButton img = new JButton(imgIcon);
            img.setHorizontalAlignment(JLabel.CENTER);
            img.setContentAreaFilled(false);
            img.setBorderPainted(false);
            img.addActionListener(e -> {
                    clearDisplay(displayPanel);

                    displayPanel.setLayout(new BorderLayout());

                    makeMediaEntry(m, displayPanel, displayList, registry);
                    //fillDisplay(displayList, displayPanel);
                    //fillDisplay(new ArrayList<Media>(){{add(displayList.get(1)); add(displayList.get(0));}},displayPanel);
                });

            display.add(img, BorderLayout.NORTH);

            JLabel text = new JLabel(m.name);
            text.setForeground(textColor);
            text.setPreferredSize(new Dimension(10, 15));
            text.setHorizontalAlignment(JLabel.CENTER);
            text.setVerticalAlignment(JLabel.TOP);

            display.add(text, BorderLayout.CENTER);

            displayPanel.add(display);

        }
        if(displayList.size()%8 != 0){
            //System.out.println("total size: " + displayList.size());
            //System.out.println("size % 8 = " + displayList.size()%8);
            for(int i = 0; i < 8-(displayList.size()%8); i++){
                displayPanel.add(new JLabel(""));
                //System.out.println(i+1 + ". label");

            }
        }
        if(displayList.size()/8 < 3){
            for(int i = 0; i < 8; i++){
                displayPanel.add(new JLabel(""));
            }
        }
    }

    /*private JPanel createScrollPanel(JPanel panel){
    //clearDisplay(panel);
    //panel.getParent().removeAll();

    JPanel scrollPanel = new JPanel();
    scrollPanel.setBackground(bgColor);
    scrollPanel.setLayout(new GridLayout(14,8));//might cause problem but hey

    JScrollPane scrollPane = new JScrollPane(scrollPanel);
    scrollPane.setPreferredSize(new Dimension(screenWidth-400, screenHeight-200));
    scrollPane.getVerticalScrollBar().setUnitIncrement(20);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setBorder(null);

    panel.add(scrollPane);

    return scrollPanel;
    }*/

    private void makeMediaEntry(Media media, JPanel panel, List<Media> currentList, MediaRegistry registry){//might need scroll
        JPanel top = new JPanel();
        JPanel center = new JPanel();
        JPanel bot = new JPanel();

        top.setPreferredSize(new Dimension(200,50));
        center.setPreferredSize(new Dimension(200,200));
        bot.setPreferredSize(new Dimension(200,200));

        top.setBackground(bgColor);
        center.setBackground(bgColor);
        bot.setBackground(bgColor);

        top.setLayout(new GridLayout(1, 3));
        //create name label
        JLabel nameLabel = new JLabel(media.name);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        //create back button
        JButton backButt = new JButton("Back");
        backButt.setFont(new Font("Arial", Font.PLAIN, 28));
        backButt.setPreferredSize(new Dimension(100,40));
        backButt.setHorizontalAlignment(JLabel.LEFT);
        backButt.setBackground(new Color(50,50,50));
        backButt.setForeground(Color.red);
        backButt.setFocusable(false);

        backButt.addActionListener(e -> {
                //clearDisplay(panel);

                //JPanel scrollPanel = createScrollPanel(panel);//old
                panel.setLayout(new GridLayout(14,8));

                sortAndFill(currentMediaType, selectedGenreList, release, alpha, registry, panel);//maybe scroll
                
                //fillDisplay(currentList, panel);

                //fillDisplay(currentList, panel);
                //clearDisplay(panel);
                //fillDisplay(startSelection, panel);
            });

        //create flowpanel for aligning button
        JPanel flowPanel = new JPanel();
        flowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        flowPanel.add(backButt);
        flowPanel.setBackground(bgColor);

        //add fake player clickable
        ImageIcon imgIcon = new ImageIcon("MovieData"+File.separator+"netflixDisplay14.png");
        JButton img = new JButton(imgIcon);
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setContentAreaFilled(false);
        img.setBorderPainted(false);

        //add media details
        JLabel details = new JLabel("Genre: " + media.genre, SwingConstants.LEFT);//continue here
        JLabel details2 = new JLabel("Release year: " + media.startYear);
        details.setForeground(textColor);
        details2.setPreferredSize(new Dimension(500, 15));
        details2.setAlignmentX(0.0f);
        details2.setHorizontalAlignment(SwingConstants.LEFT);

        //add to panels
        top.add(flowPanel);
        top.add(nameLabel);
        top.add(new JLabel(""));

        center.add(img);
        bot.add(details);
        bot.add(details2);

        //add to origin panel
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