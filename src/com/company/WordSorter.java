package com.company;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.List;
import java.util.*;
import java.util.ArrayList;

/**
 * Created by michaelkantor on 3/2/15.
 */
public class WordSorter {

    protected TextFileInput reader;


    protected String        location;
    protected List<Player>  players;

    /*
     Basic Constructor For WordSorting Object. It basically
     fills up our Words List from the TextFile.

     */

    public WordSorter(String location){

        this.location = location;
        this.players  = new ArrayList<Player>();

        setWords();
    }


    /*
       Setter for words that iterates through the text file specified in the constructor
     */

    public void setWords(){

        System.out.println("reading words....");

        reader            = new TextFileInput(location);

        String current;

        while((current = reader.readLine()) != null) {

            String [] allWordsInLine = current.split(",");

            Player currentPlayer = new Player(allWordsInLine[3],allWordsInLine[0],allWordsInLine[1],allWordsInLine[2]);
            players.add(currentPlayer);


        }

    }

    public List<Player> getWords(){

        return players;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    /*
        This method systematically creates a shadow copy of the current list
        And follows by using compareTo sort the copy, until it returns false for all
        iterations

         Interesting enough this method really didn't need to be changed at all.
        Simply giving Player his own CompareTo implementation was good enough to get it
        running the way it should. That was easy :)

     */

    public List<Player> alphabetize(){

        List<Player> copy = new ArrayList<Player>();

        for (int i = 0; i < players.size() ; i++) {
            copy.add(i,players.get(i));
        }

        for (int i = 1; i < copy.size(); i++) {

            Player current  = copy.get(i);
            Player previous = copy.get(i - 1);

            if (current.compareTo(previous) < 1) {

                copy.set(i - 1,current);
                copy.set(i, previous);
                i = 0;
                continue;
            }
        }

        return copy;
    }

}
