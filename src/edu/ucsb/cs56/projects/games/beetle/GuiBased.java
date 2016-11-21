package edu.ucsb.cs56.projects.games.beetle;

import edu.ucsb.cs56.projects.games.beetle.player.Ant;
import edu.ucsb.cs56.projects.games.beetle.player.Beetle;
import edu.ucsb.cs56.projects.games.beetle.player.Ladybug;
import edu.ucsb.cs56.projects.games.beetle.player.Person;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the GUI based game version.
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
public class GuiBased {

    public BeetleGame game;

    GuiBased(BeetleGame game) {
        this.game = game;
    }

    /**
    * Run the main window with the game options.
    */
    
    void run() {

        JFrame frame = new JFrame("The Beetle Game");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JButton ant = new JButton("Ant");
        JButton beetle = new JButton("Beetle");
        JButton ladybug = new JButton("Ladybug");
        JButton person = new JButton("Person");
        JButton exit = new JButton("Exit");

        ant.addActionListener(e -> { game.type = 0; choosePlayers(frame); });
        beetle.addActionListener(e -> { game.type = 1; choosePlayers(frame); });
        ladybug.addActionListener(e -> { game.type = 2; choosePlayers(frame); });
        person.addActionListener(e -> { game.type = 3; choosePlayers(frame); });
        exit.addActionListener(e -> System.exit(0));

        gc.gridy = 0; panel.add(new JLabel("Welcome to the Beetle Game!"), gc);
        gc.gridy = 1; panel.add(ant, gc);
        gc.gridy = 2; panel.add(beetle, gc);
        gc.gridy = 3; panel.add(person, gc);
        gc.gridy = 4; panel.add(ladybug, gc);
        gc.gridy = 5; panel.add(exit, gc);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBackground(new Color(0,155,100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Beetle Game");
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
    * Choose number of players.
    */
    public void choosePlayers(JFrame frame) {

        Object[] options = {"Single Player", "Two Players"};
        game.numPlayer = JOptionPane.showOptionDialog(
                frame, "Make your decision!", "Make your decision!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        ) + 1;

        game.p1Name = (String)JOptionPane.showInputDialog(
                frame, "Enter Player 1's name", "Player 1",
                JOptionPane.PLAIN_MESSAGE, null, null, "Player 1"
        );

        if (game.numPlayer == 2)
            game.p2Name = (String)JOptionPane.showInputDialog(
                    frame, "Enter Player 2's name", "Player 2",
                    JOptionPane.PLAIN_MESSAGE, null, null, "Player 2"
            );

        frame.setVisible(false);
        mainFrame();
    }

    
    /**
    * The main frame that handles all of the GUI game data. 
    */
    
    public void mainFrame() {

        JFrame frame = new JFrame();
        ImageIcon picture;
        JLabel picLabel = new JLabel();

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridwidth = 2;

        switch (game.type) {
            case 0:
                game.p1 = new Ant(game.p1Name);
                game.p2 = new Ant(game.p2Name);
                picture = new ImageIcon(new ImageIcon("pictures/ant.jpg").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
                picLabel.setIcon(picture); break;
            case 1:
                game.p1 = new Beetle(game.p1Name);
                game.p2 = new Beetle(game.p2Name);
                picture = new ImageIcon(new ImageIcon("pictures/beetle.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
                picLabel.setIcon(picture); break;
            case 2:
                game.p1 = new Ladybug(game.p1Name);
                game.p2 = new Ladybug(game.p2Name);
                picture = new ImageIcon(new ImageIcon("pictures/ladybug.jpg").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
                picLabel.setIcon(picture); break;
            case 3:
                game.p1 = new Person(game.p1Name);
                game.p2 = new Person(game.p2Name);
                picture = new ImageIcon(new ImageIcon("pictures/human.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
                picLabel.setIcon(picture); break;
        }

        // Set player 1 score boards
        JPanel player1Panel = new JPanel(new GridBagLayout());
        player1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel p1Score[] = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            gc.gridy = i + 1; gc.gridx = 0;
            player1Panel.add(new JLabel(game.p1.getPartName(i)), gc);
            p1Score[i] = new JLabel(Integer.toString(game.p1.getPartNeed(i)));
            gc.gridx = 6;
            player1Panel.add(p1Score[i], gc);
        }

        JPanel p1Board = new JPanel();
        p1Board.setLayout(new BoxLayout(p1Board, BoxLayout.Y_AXIS));
        p1Board.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel p1NameLable = new JLabel(game.p1.getName() + " score: " + this.game.p1Score);
        p1NameLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1Board.add(p1NameLable);
        p1Board.add(player1Panel);


        // Set player 2 score boards
        JPanel player2Panel = new JPanel(new GridBagLayout());
        player2Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel p2Score[] = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            gc.gridy = i + 1; gc.gridx = 3;
            player2Panel.add(new JLabel(game.p2.getPartName(i)), gc);
            p2Score[i] = new JLabel(Integer.toString(game.p2.getPartNeed(i)));
            gc.gridx = 0;
            player2Panel.add(p2Score[i], gc);
        }

        JPanel p2Board = new JPanel();
        p2Board.setLayout(new BoxLayout(p2Board, BoxLayout.Y_AXIS));
        p2Board.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel p2NameLable = new JLabel(game.p2.getName() + " score: " + this.game.p2Score);
        p2NameLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        p2Board.add(p2NameLable);
        p2Board.add(player2Panel);

        // Set game info board
        JPanel display = new JPanel();
        JTextArea text = new JTextArea(20, 26);
        JScrollPane scroll = new JScrollPane(text);
        text.setEditable(false);
        display.add(scroll);

        // Add control buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton roll = new JButton("Roll");
        JButton exit = new JButton("Exit");
        JLabel info = new JLabel();

        roll.addActionListener(e -> {
            text.append(game.p1.addPart() + "\n");
            text.append(game.p2.addPart() + "\n\n");

            for (int i = 0; i < 6; i++) {
                p1Score[i].setText(Integer.toString(game.p1.getPartNeed(i)));
                p2Score[i].setText(Integer.toString(game.p2.getPartNeed(i)));
            }

            if (game.p1.isWin() && !game.p2.isWin()) {
                game.p1Score++;
                chooseContinue(frame, game.p1.getName() + " won!");
            } else if (game.p2.isWin() && !game.p1.isWin()) {
                game.p2Score++;
                chooseContinue(frame, game.p2.getName() + " won!");
            } else if (game.p2.isWin() && game.p1.isWin()) {
                game.p1Score++;
                game.p2Score++;
                chooseContinue(frame, "Tie!");
            }
        });
        exit.addActionListener(e -> System.exit(0));

        roll.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);     //align the image for the game

        String infoStr = "";
        for (int i = 0; i < 6; i++)
            infoStr += Integer.toString(i + 1) + "[" + game.p1.getPartName(i) + "] ";
        info.setText(infoStr);

        controlPanel.add(roll);
        controlPanel.add(exit);
        controlPanel.add(info);
        controlPanel.add(picLabel);         //add the image for the game

        // Create the main window
        frame.getContentPane().add(p1Board, BorderLayout.WEST);
        frame.getContentPane().add(p2Board, BorderLayout.EAST);
        frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(display, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Beetle Game");
        frame.setSize(750, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    
    /**
    * Does the player want to play again or not?
    */
    
    public void chooseContinue(JFrame frame, String msg) {

        Object[] options = {"Continue", "Exit"};
        int isContinue = JOptionPane.showOptionDialog(
                frame, msg, "Do you want to continue?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        );

        frame.setVisible(false);

        if (isContinue == 1) {
            System.exit(0);
        } else {
            //Choose what kind of game the user wants to play this time
            Object[] choices = {"Ant", "Beetle", "Ladybug", "Person"};
            int option = JOptionPane.showOptionDialog(
                    frame, "Enter a new game mode.", "Enter a new game mode",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
            game.setGameType(option);
            mainFrame();
        }
    }
}
