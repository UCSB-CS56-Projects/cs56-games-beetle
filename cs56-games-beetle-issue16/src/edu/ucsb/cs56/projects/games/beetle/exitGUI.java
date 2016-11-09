package edu.ucsb.cs56.projects.games.beetle;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Dimension;
import java.io.*;
import javax.swing.*;

public class exitGUI extends JFrame{

	private JButton playAgain;
	private JButton exit;
	private JLabel yourScore;
	private JLabel compScore;
	private JPanel panel = new JPanel();
	private JPanel centerPanel = new JPanel(new GridLayout(2,1));
	int playerScore = 0;
	int computerScore = 0;
	String playerName = "";
	String computerName = "";

    /**
     * no-arg constructor for the exit GUI
     */
    public exitGUI(){

    }

    /**
     * Overloaded constructor with parameters for score
     * @param playerScore the score of the player(player 1)
     * @param computerScore the score of the computer(player 2)
     */
    public exitGUI(int playerScore, int computerScore){

		super("Exit Menu");
		centerPanel.setBackground(new Color(0,155,100));
		this.playerScore = playerScore;
		this.computerScore = computerScore;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playAgain = new JButton("Play Again");
		exit = new JButton("Close Game");
		exit.addActionListener(new ExitListener());
		playAgain.addActionListener(new playAgainListener());
		panel.add(playAgain);
		panel.add(exit);
		getContentPane().add(panel, BorderLayout.SOUTH);


		JPanel rPanel = new JPanel();
		rPanel.setBackground(new Color(0,155,100));
		if (this.playerScore > this.computerScore) {
			JLabel winnerLabel = new JLabel("Congrats to " + this.playerName + " for winning the game!");
			rPanel.add(winnerLabel);
		} else {
			JLabel winnerLabel = new JLabel(this.computerName + " has come out on top!");
			rPanel.add(winnerLabel);
		}
		centerPanel.add(rPanel);


		JPanel sPanel = new JPanel();
		sPanel.setBackground(new Color(0,155,100));
		yourScore = new JLabel(this.playerName + "'s Score: " + this.playerScore + "     ");
		compScore = new JLabel(this.computerName + "'s Score: " + this.computerScore);
		sPanel.add(yourScore);
		sPanel.add(compScore);
		centerPanel.add(sPanel);



		getContentPane().add(centerPanel, BorderLayout.CENTER);

		setSize(300,150);
		setResizable(false);

    }

	/**
	 * Overloaded constructor with parameters for score and names
	 * @param playerScore the score of the player(player 1)
	 * @param computerScore the score of the computer(player 2)
	 * @param playerName the name of the player(player 1)
	 * @param computerName the name of the computer(player 2)
	 */

	public exitGUI(int playerScore, int computerScore, String playerName, String computerName){

		super("Exit Menu");
		centerPanel.setBackground(new Color(0,155,100));
		this.playerScore = playerScore;
		this.computerScore = computerScore;
		this.playerName = playerName;
		this.computerName = computerName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playAgain = new JButton("Play Again");
		exit = new JButton("Close Game");
		exit.addActionListener(new ExitListener());
		playAgain.addActionListener(new playAgainListener());
		panel.setBackground(new Color(0,155,100));
		panel.add(playAgain);
		panel.add(exit);
		getContentPane().add(panel, BorderLayout.SOUTH);


		JPanel rPanel = new JPanel();
		rPanel.setBackground(new Color(0,155,100));
		if (this.playerScore > this.computerScore) {
			JLabel winnerLabel = new JLabel("Congrats to " + this.playerName + " for winning the game!");
			rPanel.add(winnerLabel);
		} else {
			JLabel winnerLabel = new JLabel(this.computerName + " has come out on top!");
			rPanel.add(winnerLabel);
		}
		centerPanel.add(rPanel);

		JPanel sPanel = new JPanel();
		sPanel.setBackground(new Color(0,155,100));
		yourScore = new JLabel(this.playerName + "'s Score: " + this.playerScore + "     ");
		compScore = new JLabel(this.computerName + "'s Score: " + this.computerScore);
		sPanel.add(yourScore);
		sPanel.add(compScore);
		centerPanel.add(sPanel);

		getContentPane().add(centerPanel, BorderLayout.CENTER);

		setSize(300,150);
		setResizable(false);
	}


	/**
     * Action Listener for the Play Again button on the exit GUI window
     */
    class playAgainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    startGUI gui = new startGUI(exitGUI.this.playerScore, exitGUI.this.computerScore, exitGUI.this.playerName, exitGUI.this.computerName);
	    gui.setUpHomeScreen();
	    panel.getRootPane().getParent().setVisible(false);
	}
	}
    /**
     * Action listener for the Close Game button on the exit GUI window
     */
    class ExitListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    System.exit(0);
	}
    }


}
