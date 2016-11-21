package edu.ucsb.cs56.projects.games.beetle.player;

/** The person class extends Player for the game. 
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

public class Person extends Player {
	public Person(String name) {
		this.name = name;
		this.partNeed = new int[] {1, 1, 2, 2, 1, 2};
		this.partPre  = new int[] {-1, 0, 0, 1, 1, 0};
		this.partName = new String[] {"body", "head", "leg", "eye", "mouth", "arm"};
	}
}
