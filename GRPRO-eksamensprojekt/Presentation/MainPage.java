package Presentation;

import javax.swing.*;
import java.awt.*;


public class MainPage extends JFrame {

    MainPage() {
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
        frame.setVisible(true);

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
        
        
        //BUTTONS
        JPanel topLeft = new JPanel();
        JPanel topCenter = new JPanel();
        JPanel topRight = new JPanel();
        
        topPanel.setLayout(new GridLayout(1,3));
        
        
        //TOP LEFT
        JLabel icon = new JLabel("");
        ImageIcon logo = new ImageIcon("NETFLIX.png");
        icon.setIcon(logo);
        topLeft.add(icon);
        
        //TOP CENTER 
        topCenter.setLayout(new FlowLayout(FlowLayout.CENTER,10,100));
        JButton movieButt = new JButton("movie");
        JButton serieButt = new JButton("movie");
        JButton favoriteButt = new JButton("movie");        
        movieButt.setBounds(100,100,100,100);
        
        topCenter.add(movieButt);
        topCenter.add(serieButt);
        topCenter.add(favoriteButt);
        
        
        
        
        topPanel.add(topLeft);
        topPanel.add(topCenter);
        topPanel.add(topRight);
        
        
        
        
        
        
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