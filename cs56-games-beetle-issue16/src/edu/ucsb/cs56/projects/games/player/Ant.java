package edu.ucsb.cs56.projects.games.beetle.player;

public class Ant extends Player {
    public Ant() {
        this.partNeed = new int[] {1, 1, 6, 2, 2, 1};
        this.partPre  = new int[] {-1, 0, 0, 1, 1, 0};
        this.partName = new String[] {"thorax", "head", "leg", "eye", "antenna", "abdomen"};
    }
    public Ant(String name) {
        this.name = name;
        this.partNeed = new int[] {1, 1, 6, 2, 2, 1};
        this.partPre  = new int[] {-1, 0, 0, 1, 1, 0};
        this.partName = new String[] {"thorax", "head", "leg", "eye", "antenna", "abdomen"};
    }
}
