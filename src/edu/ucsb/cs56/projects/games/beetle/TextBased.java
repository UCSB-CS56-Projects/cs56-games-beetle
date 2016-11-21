package edu.ucsb.cs56.projects.games.beetle;

import edu.ucsb.cs56.projects.games.beetle.player.Ant;
import edu.ucsb.cs56.projects.games.beetle.player.Beetle;
import edu.ucsb.cs56.projects.games.beetle.player.Ladybug;
import edu.ucsb.cs56.projects.games.beetle.player.Person;

import java.util.Scanner;

/**
 * Class for the Text based version of the game.
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
public class TextBased {

    /**
     * Core class providing game data.
     */
    public BeetleGame game;

    /**
     * It is used to read user input.
     */
    private Scanner reader = new Scanner(System.in);

    /**
     * Game mode for four roles.
     */
    private char gameType;

    /**
     * The number of the current round.
     */
    private int round = 1;

    TextBased(BeetleGame game) {
        this.game = game;
    }

    /**
     * Game entry point. Print the main screen and ask for user input.
     */
    public void run() {

        System.out.println("*************************************");
        System.out.println("                                     ");
        System.out.println("           THE BEETLE GAME           ");
        System.out.println("                                     ");
        System.out.println("     Copyright (C) 2016 Sam Ricky    ");
        System.out.println("                                     ");
        System.out.println("*************************************");
        System.out.println("                                     ");
        System.out.println("              [A]NT                  ");
        System.out.println("              [B]EETLE               ");
        System.out.println("              [L]ADYBUG              ");
        System.out.println("              [P]ERSON               ");
        System.out.println("              [E]XIT                 ");
        System.out.println("                                     ");
        System.out.println("*************************************\n");


        gameType = promptForChoice("Select game mode by A/B/L/P or exit by E: ", "ABLPE");

        if (gameType == 'E')
            System.exit(0);

        char numPlayers = promptForChoice("How many players, 1 or 2? ", "12");
        game.p1Name = promptForString("What's the name of Player 1? ");
        game.p2Name = numPlayers == '2' ? promptForString("What's the name of Player 2? ") : "Computer";

        newRound();
    }

    /**
     * Print a prompt given by <code>text</code>, and ask for a single letter input ranged in <code>inputs</code>.
     * It will continuously ask until a legal input is given.
     *
     * For example, <code>promptForChoice("Input one of abcde", "abcde")</code> will print <code>"Input one of abcde"
     * </code> and wait for a user input. If user doesn't input any of a, b, c, d, or e, it will prompt again and wait
     * for a legal input. This mechanism is accomplished via a regex of the form <code>"^[abcde]"</code>.
     *
     * @param text   a string that is printed before user input
     * @param inputs defines the range of user input, which should be one of its element
     * @return a legal user input
     */
    public char promptForChoice(String text, String inputs) {
        String line = "";
        while (!line.matches("^[" + inputs + "]")) {
            System.out.print(text);
            line = reader.nextLine();
        }
        return line.charAt(0);
    }

    /**
     * Print a string and wait for a nonempty string.
     * @param text a string that is printed before user input
     * @return a nonempty string provided by user
     */
    public String promptForString(String text) {
        String line = "";
        while (line.equals("")) {
            System.out.print(text);
            line = reader.nextLine();
        }
        return line;
    }

    /**
     * Simply prints a string and wait for a user interaction. It doesn't care about what is given.
     * @param text a string that is printed before user input
     */
    public void promptForRoll(String text) {
        System.out.print(text);
        String line = reader.nextLine();
    }

    /**
     * Start a new round.
     */
    public void newRound() {

        if (round != 1)
            gameType = promptForChoice("Select game mode by A/B/L/P: ", "ABLP");

        switch (gameType) {
            case 'A': game.p1 = new Ant(game.p1Name); game.p2 = new Ant(game.p2Name); break;
            case 'B': game.p1 = new Beetle(game.p1Name); game.p2 = new Beetle(game.p2Name); break;
            case 'L': game.p1 = new Ladybug(game.p1Name); game.p2 = new Ladybug(game.p2Name); break;
            case 'P': game.p1 = new Person(game.p1Name); game.p2 = new Person(game.p2Name); break;
        }

        System.out.println("\n*************************************");
        System.out.println("              ROUND " + round);
        System.out.println(game.p1.name + ": " + game.p1Score + ", " + game.p2.name + ": " + game.p2Score);
        System.out.println("*************************************\n");

        printScore();
        System.out.println("*************************************\n");
        promptForRoll("Press Enter to roll a dice!");

        while (!isEnd()) {
            System.out.println("\n*************************************");
            System.out.println(game.p1.addPart());
            System.out.println(game.p2.addPart());
            printScore();
            if (isEnd()) break;
            System.out.println("*************************************\n");
            promptForRoll("Press Enter to roll a dice!");
        }
        System.out.println("*************************************\n");

        if (game.p1.isWin() && game.p2.isWin()) {
            System.out.println("Tie!");
            game.p1Score++;
            game.p2Score++;
        } else if (game.p1.isWin()) {
            System.out.println(game.p1.name + " Won!");
            game.p1Score++;
        } else {
            System.out.println(game.p2.name + " Won!");
            game.p2Score++;
        }

        isContinue();
    }

    /**
     * Print two player's score.
     */
    public void printScore() {

        System.out.printf("%s now has", game.p1.name);
        for (int i = 0; i < 6; i++)
            System.out.print(" " + game.p1.getPartName(i) + "[" + game.p1.getPartNeed(i) + "]");
        System.out.println();

        System.out.printf("%s now has", game.p2.name);
        for (int i = 0; i < 6; i++)
            System.out.print(" " + game.p2.getPartName(i) + "[" + game.p2.getPartNeed(i) + "]");
        System.out.println();
    }

    /**
     * Returns if the game is end, i.e., either player wins.
     * @return true if either player wins; false if no player wins
     */
    public boolean isEnd() {
        return game.p1.isWin() || game.p2.isWin();
    }

    /**
     * Asks user whether to continue or not.
     */
    public void isContinue() {
        char choice = promptForChoice("Do you want to continue, y or n? ", "yn");
        switch (choice) {
            case 'y':
                round++;
                newRound();
            case 'n':
                System.out.println();
                System.out.println(game.p1.name + ": " + game.p1Score + ", " + game.p2.name + ": " + game.p2Score);
                System.exit(0);
        }
    }
}
