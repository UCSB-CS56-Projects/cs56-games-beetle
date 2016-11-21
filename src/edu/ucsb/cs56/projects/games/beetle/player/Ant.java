package edu.ucsb.cs56.projects.games.beetle.player;

/** 
   * This Ant class extends the Player class for the Game.
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

public class Ant extends Player {
    public Ant(String name) {
        this.name = name;
        this.partNeed = new int[] {1, 1, 6, 2, 2, 1};
        this.partPre  = new int[] {-1, 0, 0, 1, 1, 0};
        this.partName = new String[] {"thorax", "head", "leg", "eye", "antenna", "abdomen"};
    }
}
