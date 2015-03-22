package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class GUI  extends JFrame{


    String words[];
    TextArea text1;
    TextArea text2;

    /*
       Constructor for the GUI to do basic setup.
       It creates a 1 row, 2 column layout each with their own
       Textarea
     */
    public GUI(String title, int width, int height){

        words = new String[]{};
        text1 = new TextArea();
        text2 = new TextArea();


        setTitle(title);
        setSize(width,height);
        add(text1);
        add(text2);

        setLayout(new GridLayout(1,2));
        setVisible(true);
        text1.setBackground(Color.cyan);
        text2.setBackground(Color.magenta);

    }

     /*
      Just a tiny helper method to avoid 2 for loops. It takes the GUIs
      TextArea and appends the array of strings from the particular column into
      the GUI
     */

    public void organizeColumn(List<Player> column, TextArea textArea) {

        for (int i = 0; i < column.size(); i++) {

            Player player = column.get(i);
            String currentLine   =  player.number + "," + player.firstName + "," + player.lastName + "," + player.battingAvg + "\r\n";
            textArea.append(currentLine);

        }
    }

}


