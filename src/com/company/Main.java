package com.company;

import java.awt.*;
import java.util.List;

public class Main {

    public static GUI WordFrame;
    public static WordSorter Reader;

    public static void main(String[] args) {

        WordFrame    = new GUI("Project 2",1000,4000);
        Reader       = new WordSorter("players.txt");

        List<Player> leftColumn  =  Reader.getWords();
        List<Player> rightColumn =  Reader.alphabetize();

        WordFrame.organizeColumn(leftColumn, WordFrame.text1);
        WordFrame.organizeColumn(rightColumn,WordFrame.text2);
    }

}
