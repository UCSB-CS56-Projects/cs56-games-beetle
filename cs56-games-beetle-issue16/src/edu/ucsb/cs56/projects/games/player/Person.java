package edu.ucsb.cs56.projects.games.beetle.player;

public class Person extends Player {
    public Person() {
        this.name = name;
        this.partNeed = new int[] {1, 1, 2, 2, 1, 2};
        this.partPre  = new int[] {-1, 0, 0, 1, 1, 0};
        this.partName = new String[] {"body", "head", "leg", "eye", "mouth", "arm"};
    }
	public Person(String name) {
		this.name = name;
		this.partNeed = new int[] {1, 1, 2, 2, 1, 2};
		this.partPre  = new int[] {-1, 0, 0, 1, 1, 0};
		this.partName = new String[] {"body", "head", "leg", "eye", "mouth", "arm"};
	}
}
