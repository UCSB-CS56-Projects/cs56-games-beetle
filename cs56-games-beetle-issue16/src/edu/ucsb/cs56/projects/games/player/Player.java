package edu.ucsb.cs56.projects.games.beetle.player;

import java.util.*;

abstract class Player {

    String name;
    int roll;
    int partNeed[];
    int partPre[];
    String partName[];

    private Random randGen = new Random();

    /**
     * Add a partHas to player based on the last roll.
     * @return A message indicating how's going.
     */
    private String addPart() {
        if (partPre[roll] != -1 && partNeed[roll] != 0)
            return "Needs enough " + partPre[roll] + " first";
        if (partNeed[roll] == 0)
            return "Already has enough " + partName[roll];
        partNeed[roll]--;
        return "Added a new " + partName[roll];
    }

    public void roll() {
        this.roll = randGen.nextInt(6) + 1;
    }

    /**
     * Check whether the player has all of the necessary partHas to win.
     * Should be called at the end of each turn.
     * @return True if the player win, false if not.
     */
    public boolean isWin() {
        return Arrays.stream(partNeed).allMatch(e -> e == 0);
    }

    public void reset() {
    }

    public void draw() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return this.roll;
    }

    public int getPart(int i) {
        return partNeed[i];
    }
}
