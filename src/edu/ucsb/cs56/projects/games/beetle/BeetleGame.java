package edu.ucsb.cs56.projects.games.beetle;
import edu.ucsb.cs56.projects.games.beetle.player.*;

/**
 * The Beetle Game - Create animals by rolling a die to get their body parts!
 * @version Fall 2016, CS56, UCSB
 * @author  Yuanqi Li
 * @author  Samarth Goyal
 * 
 * @version Previous quarters
 * @author Dennis
 * @author Kevin Jih
 * @author Justin Nguyen
 * @author Alex Kang
 */
public class BeetleGame {

    Player p1, p2;
    String p1Name = "Player1", p2Name = "Computer";
    int p1Score = 0, p2Score = 0;
    int type = 0;
    int numPlayer = 1;

    BeetleGame(int p1Score, int p2Score) {
        this.p1Score = p1Score;
        this.p2Score = p2Score;
    }

    void setGameType(int num) {
        this.type = num;
    }

    public static void main(String[] args) {

        BeetleGame game = new BeetleGame(0, 0);

        if (args.length > 0 && args[0].equals("-t"))
            new TextBased(game).run();
        else
            new GuiBased(game).run();
    }
}
