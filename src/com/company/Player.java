package com.company;

/**
 * Created by michaelkantor on 3/16/15.
 */

/** This Class Is Pretty straightforward. The Constructor accepts
 *  4 arguments used to fully prepare a Player. Int and Float are created
 *  By Using the appropriate wrapper classes Integer & Float
 * **/
public class Player {


    /*Batting Avg For The Player */
    public float   battingAvg;
    /*Jersey # For The Player */
    public int     number;
    /*Last Name For The Player */
    public String  lastName;
    /*First Name For The Player */
    public String  firstName;


    public Player(String battingAvg,String number, String lastName, String firstName){

        float avg = Float.parseFloat(battingAvg);

        if(avg < 0 || avg > 100){
            throw new IllegalArgumentException("Batting Avg Is Out Of Range...");
        }

        this.battingAvg = avg;

        this.number     = Integer.parseInt(number);
        this.lastName   = lastName;
        this.firstName  = firstName;
    }

    /**
     * This Method simply implements compareTo by using the lastName of both objects,
     * self & the param otherPlayer.
     * @param otherPlayer Player
     * @return int
     */
    public int compareTo(Player otherPlayer){

        return lastName.compareTo(otherPlayer.lastName);
    }


}
