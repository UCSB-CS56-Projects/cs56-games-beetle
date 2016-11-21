package edu.ucsb.cs56.projects.games.beetle.player;

import java.util.Random;

/** This class provides the base for the "types" of players you are trying to make.
   * Ant, Beetle, Ladybug, Person (and potentially future classes) will extend Person
   * @version Fall 2016, CS56, UCSB
   * @author Yuanqi Li
   * @author Samarth Goyal  
   *
   * @version Previous quarters
   * @author Dennis
   * @author Kevin Jih
   * @author Justin Nguyen
   * @author Alex Kang
*/

public abstract class Player {

    public String name;
    public int roll;
    public int partNeed[];
    public int partPre[];
    public String partName[];

    private Random randGen = new Random();

    /**
     * Add a body part to the player based on the last roll.
     * @return A message indicating what happened.
     */
    public String addPart() {

        String message = "";
        this.roll = randGen.nextInt(6);
        message += name + " rolled " + Integer.toString(roll + 1) + ", ";

        if (partPre[roll] != -1 && partNeed[partPre[roll]] != 0)
            return message + "needs enough " + partName[partPre[roll]] + " first.";
        if (partNeed[roll] == 0)
            return message + "already has enough " + partName[roll] + ".";

        partNeed[roll]--;
        return message + "adds a new " + partName[roll] + ".";
    }

    /**
     * Checks whether the player has all of the necessary body parts to win.
     * Should be called at the end of each turn.
     * @return True if the player wins, false if not.
     */
    public boolean isWin() {
        for (int i = 0; i < 6; i++)
            if (partNeed[i] != 0)
                return false;
        return true;
    }

    /**
    * Returns the name of the player.
    * @return player name
    */
    
    public String getName() {
        return name;
    }

    /**
    * Returns the roll of the die.
    * @return number the die rolled
    */
    
    public int getRoll() {
        return roll;
    }

    /**
    * Returns the number of the part needed.
    * @return number of the part needed
    */
    
    public int getPartNeed(int i) {
        return partNeed[i];
    }

    /**
    * Returns the name of the body part.
    * @return name of the body part
    */
    
    public String getPartName(int i) {
        return partName[i];
    }
}
