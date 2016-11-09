/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Dennis
 * @author Kevin Jih
 * @author Justin Nguyen
 * @author Alexander Kang
 */


public class antGUI {
    JFrame frame = new JFrame("Ant Dice Rolling Game");
    JPanel thePanel = new JPanel(new GridBagLayout());
    JLabel title = new JLabel("Ant Dice Rolling Game!");
    JLabel pNeed = new JLabel("APlayer still needs");
    JLabel thorax = new JLabel("Thorax: ");
    JLabel head = new JLabel("Head: ");
    JLabel legs = new JLabel("Legs: ");
    JLabel eyes = new JLabel("Eyes: ");
    JLabel antennas = new JLabel("Antennas: ");
    JLabel cNeed = new JLabel("Computer still needs");
    JLabel abdomen = new JLabel("Abdomen: ");
    JLabel cThorax = new JLabel("Thorax: ");
    JLabel cHead = new JLabel("Head: ");
    JLabel cLegs = new JLabel("Legs: ");
    JLabel cEyes = new JLabel("Eyes: ");
    JLabel cAntennas = new JLabel("Antennas: ");
    JLabel cAbdomen = new JLabel("Abdomen: ");
    JTextField pB = new JTextField("1",10);
    JTextField pH = new JTextField("1",10);
    JTextField pL = new JTextField("6",10);
    JTextField pE = new JTextField("2",10);
    JTextField pA = new JTextField("2",10);
    JTextField pT = new JTextField("1",10);
    JTextField cB = new JTextField("1",10);
    JTextField cH = new JTextField("1",10);
    JTextField cL = new JTextField("6",10);
    JTextField cE = new JTextField("2",10);
    JTextField cA = new JTextField("2",10);
    JTextField cT = new JTextField("1",10);
    private int pBN = 1; 
    private int pHN = 1; 
    private int pLN = 6; 
    private int pEN = 2; 
    private int pAN = 2; 
    private int pTN = 1; 
    private int cBN = 1; 
    private int cHN = 1; 
    private int cLN = 6; 
    private int cEN = 2; 
    private int cAN = 2; 
    private int cTN = 1; 
    JLabel info1 = new JLabel("1: Thorax    2: Head       3: Legs");  
    JLabel info2 = new JLabel("4: Eyes    5: Antennas   6: Abdomen");
    JButton roll = new JButton("Roll");
    JButton exit = new JButton("Exit");
    JTextArea text = new JTextArea(20,20);
    JScrollPane scroll = new JScrollPane(text);
    APlayer player = new APlayer();
    APlayer computer = new APlayer();
    Game game = new Game();
    
    //add images
    ImageIcon antPic;
    JLabel picLabel = new JLabel();
    //labels to track score
    JLabel playerScore = new JLabel("Player has won: ");
    JLabel computerScore = new JLabel("Computer has won: ");
    /** no-arg constructor for antGUI
     
     */
    public antGUI(){

    }

    /**
     * Overloaded constructor with score parameters
     * @param playerScore the score of the player(player 1)
     * @param computerScore the score of the computer(player 2)
     */
    public antGUI(int playerScore, int computerScore){
        game.setScore(0, playerScore);
        game.setScore(1, computerScore);
    }

    public antGUI(int playerScore, int computerScore, String playerName, String computerName){
        game.setScore(0, playerScore);
        game.setScore(1, computerScore);
        player.setName(playerName);
        computer.setName(computerName);
    }
    /**
     * Sets up the ant GUI window and launches the Single/MultiPlayer window
     */
    
    public void setUpHomeScreen(){
	// Option for Single Player or Two Players
       
    antPic = new ImageIcon(new ImageIcon("pictures/ant.jpg").getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
    picLabel.setIcon(antPic);       


        
	frame.getContentPane().setBackground(new Color(0, 153, 0));
	Object[] options = {"Single Player",
			    "Two Players"};
	int n = JOptionPane.showOptionDialog(frame,
					     "Please Select One",
					     "Please Select One",
					     JOptionPane.YES_NO_OPTION,
					     JOptionPane.QUESTION_MESSAGE,
					     null,     //do not use a custom Icon
					     options,  //the titles of buttons
					     options[0]); //default button title

	// if Single Player, prompt for Player 1 name & automaticlaly set Player 2 to "Computer"
	if(n == 0) {
	    player.setName( (String)JOptionPane.showInputDialog(
								frame,
								"Enter Player 1 Name\n",
								"Player 1",
								JOptionPane.PLAIN_MESSAGE,
								null,
								null,
								"Player 1") );

	    computer.setName("Computer");
	}
	// if Two Player, prompt for Player 1 name, then Player 2 name and set
	else if(n == 1) {
	    player.setName( (String)JOptionPane.showInputDialog(
								frame,
								"Enter Player 1 Name\n",
								"Player 1",
								JOptionPane.PLAIN_MESSAGE,
								null,
								null,
								"Player 1") );
	    
	    computer.setName( (String)JOptionPane.showInputDialog(
								  frame,
								  "Enter Player 2 Name\n",
								  "Player 2",
								  JOptionPane.PLAIN_MESSAGE,
								  null,
								  null,
								  "Player 2") );
	}
	
	// set player needs JLable to correct names
	pNeed = new JLabel(player.getName() + " still needs");
	cNeed = new JLabel(computer.getName() + " still needs");

        text.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
    playerScore = new JLabel(player.getName() + " has won: " + game.getScore(0) + " game(s)" );
	computerScore = new JLabel("    " + computer.getName() + " has won: " + game.getScore(1) + " game(s)");
    // add title to frame
        gc.gridwidth=2;
        gc.gridx=2;
        gc.gridy=0;
        frame.add(title, gc);

	// add text scroll panel to frame 
        gc.gridy=1;
        gc.gridheight=8;
        frame.add(scroll, gc);
        
        //player score
	// add player needs label
        gc.gridwidth=1;
        gc.gridheight=1;
	gc.gridx=0;
	gc.gridy=1;
    frame.add(pNeed, gc);

	// format and add thorax label
        gc.gridx=0;
        gc.gridy=2;
	frame.add(thorax, gc);
        gc.gridx=1;
	pB.setEditable(false);
	// add thorax counter
	frame.add(pB, gc);
	// format and add head label
        gc.gridx=0;
        gc.gridy=3;
        frame.add(head, gc);
        gc.gridx=1;
	pH.setEditable(false);
	// add head counter
        frame.add(pH, gc);

	// format and add legs label
        gc.gridx=0;
        gc.gridy=4;
        frame.add(legs, gc);
        gc.gridx=1;
	pL.setEditable(false);
	// add legs counter
        frame.add(pL, gc);

	// format and add eyes label
        gc.gridx=0;
        gc.gridy=5;
        frame.add(eyes, gc);
        gc.gridx=1;
	pE.setEditable(false);
	// add eyes counter
        frame.add(pE, gc);

	// format and add antennas label
        gc.gridx=0;
        gc.gridy=6;
        frame.add(antennas, gc);
        gc.gridx=1;
	pA.setEditable(false);
	// add antennas counter
        frame.add(pA, gc);

	// format and add abdomen label
        gc.gridx=0;
        gc.gridy=7;
        frame.add(abdomen, gc);
        gc.gridx=1;
	pT.setEditable(false);
	// add abdomen counter
        frame.add(pT, gc);

    //format and add player 1 score
        gc.gridx = 0;
        gc.gridy = 8;
        frame.add(playerScore, gc);
        
        //computer score
	// add computer needs label
	gc.gridx=4;
	gc.gridy=1;
	frame.add(cNeed, gc);

	// format and add thorax label
	gc.gridx=4;
        gc.gridy=2;
	frame.add(cThorax, gc);
        gc.gridx=5;
	cB.setEditable(false);
	// add thorax counter
        frame.add(cB, gc);

	// format and add head label
        gc.gridx=4;
        gc.gridy=3;
        frame.add(cHead, gc);
        gc.gridx=5;
	cH.setEditable(false);
	// add head counter
        frame.add(cH, gc);

	// format and add legs label
        gc.gridx=4;
        gc.gridy=4;
        frame.add(cLegs, gc);
        gc.gridx=5;
	cL.setEditable(false);
	// add legs counter
        frame.add(cL, gc);

	// format and add eyes label
        gc.gridx=4;
        gc.gridy=5;
        frame.add(cEyes, gc);
        gc.gridx=5;
	cE.setEditable(false);
	// add eyes counter
        frame.add(cE, gc);

	// format and add antennas label
        gc.gridx=4;
        gc.gridy=6;
        frame.add(cAntennas, gc);
        gc.gridx=5;
	cA.setEditable(false);
	// add antennas counter
        frame.add(cA, gc);

	// format and add abdomen label
        gc.gridx=4;
        gc.gridy=7;
        frame.add(cAbdomen, gc);
        gc.gridx=5;
	cT.setEditable(false);
	// add abdomen counter
        frame.add(cT, gc);
    //add computer score
        gc.gridx = 4;
        gc.gridy = 8;
        frame.add(computerScore, gc);
        
	// add Roll button
        gc.gridx=2;
        gc.gridy=9;
        roll.addActionListener(new RollListener());
        frame.add(roll, gc);

	// add Exit button
        gc.gridx=3;
        exit.addActionListener(new ExitListener());
        frame.add(exit, gc);

	// format and add information on what roll gets which body part
        gc.gridwidth=2;
        gc.gridx=2;
        gc.gridy=10;
        frame.add(info1, gc);
        gc.gridy=11;
        frame.add(info2, gc);

        //add the picture
        //Why 4.
        gc.gridwidth = 4;
        gc.gridy = 12;
        gc.gridx = 1;
        frame.add(picLabel,gc);

        //frame.getContentPane().add(thePanel);
        frame.pack();
        frame.setSize(900,600);
        frame.setVisible(true);
        
        
    }

    public void setUpHomeScreenAgain(){
        // Option for Single Player or Two Players

        antPic = new ImageIcon(new ImageIcon("pictures/ant.jpg").getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
        picLabel.setIcon(antPic);



        frame.getContentPane().setBackground(new Color(0, 153, 0));

        // set player needs JLable to correct names
        pNeed = new JLabel(player.getName() + " still needs");
        cNeed = new JLabel(computer.getName() + " still needs");

        text.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        playerScore = new JLabel(player.getName() + " has won: " + game.getScore(0) + " game(s)" );
        computerScore = new JLabel("    " + computer.getName() + " has won: " + game.getScore(1) + " game(s)");
        // add title to frame
        gc.gridwidth=2;
        gc.gridx=2;
        gc.gridy=0;
        frame.add(title, gc);

        // add text scroll panel to frame
        gc.gridy=1;
        gc.gridheight=8;
        frame.add(scroll, gc);

        //player score
        // add player needs label
        gc.gridwidth=1;
        gc.gridheight=1;
        gc.gridx=0;
        gc.gridy=1;
        frame.add(pNeed, gc);

        // format and add thorax label
        gc.gridx=0;
        gc.gridy=2;
        frame.add(thorax, gc);
        gc.gridx=1;
        pB.setEditable(false);
        // add thorax counter
        frame.add(pB, gc);
        // format and add head label
        gc.gridx=0;
        gc.gridy=3;
        frame.add(head, gc);
        gc.gridx=1;
        pH.setEditable(false);
        // add head counter
        frame.add(pH, gc);

        // format and add legs label
        gc.gridx=0;
        gc.gridy=4;
        frame.add(legs, gc);
        gc.gridx=1;
        pL.setEditable(false);
        // add legs counter
        frame.add(pL, gc);

        // format and add eyes label
        gc.gridx=0;
        gc.gridy=5;
        frame.add(eyes, gc);
        gc.gridx=1;
        pE.setEditable(false);
        // add eyes counter
        frame.add(pE, gc);

        // format and add antennas label
        gc.gridx=0;
        gc.gridy=6;
        frame.add(antennas, gc);
        gc.gridx=1;
        pA.setEditable(false);
        // add antennas counter
        frame.add(pA, gc);

        // format and add abdomen label
        gc.gridx=0;
        gc.gridy=7;
        frame.add(abdomen, gc);
        gc.gridx=1;
        pT.setEditable(false);
        // add abdomen counter
        frame.add(pT, gc);

        //format and add player 1 score
        gc.gridx = 0;
        gc.gridy = 8;
        frame.add(playerScore, gc);

        //computer score
        // add computer needs label
        gc.gridx=4;
        gc.gridy=1;
        frame.add(cNeed, gc);

        // format and add thorax label
        gc.gridx=4;
        gc.gridy=2;
        frame.add(cThorax, gc);
        gc.gridx=5;
        cB.setEditable(false);
        // add thorax counter
        frame.add(cB, gc);

        // format and add head label
        gc.gridx=4;
        gc.gridy=3;
        frame.add(cHead, gc);
        gc.gridx=5;
        cH.setEditable(false);
        // add head counter
        frame.add(cH, gc);

        // format and add legs label
        gc.gridx=4;
        gc.gridy=4;
        frame.add(cLegs, gc);
        gc.gridx=5;
        cL.setEditable(false);
        // add legs counter
        frame.add(cL, gc);

        // format and add eyes label
        gc.gridx=4;
        gc.gridy=5;
        frame.add(cEyes, gc);
        gc.gridx=5;
        cE.setEditable(false);
        // add eyes counter
        frame.add(cE, gc);

        // format and add antennas label
        gc.gridx=4;
        gc.gridy=6;
        frame.add(cAntennas, gc);
        gc.gridx=5;
        cA.setEditable(false);
        // add antennas counter
        frame.add(cA, gc);

        // format and add abdomen label
        gc.gridx=4;
        gc.gridy=7;
        frame.add(cAbdomen, gc);
        gc.gridx=5;
        cT.setEditable(false);
        // add abdomen counter
        frame.add(cT, gc);
        //add computer score
        gc.gridx = 4;
        gc.gridy = 8;
        frame.add(computerScore, gc);

        // add Roll button
        gc.gridx=2;
        gc.gridy=9;
        roll.addActionListener(new RollListener());
        frame.add(roll, gc);

        // add Exit button
        gc.gridx=3;
        exit.addActionListener(new ExitListener());
        frame.add(exit, gc);

        // format and add information on what roll gets which body part
        gc.gridwidth=2;
        gc.gridx=2;
        gc.gridy=10;
        frame.add(info1, gc);
        gc.gridy=11;
        frame.add(info2, gc);

        //add the picture
        //Why 4.
        gc.gridwidth = 4;
        gc.gridy = 12;
        gc.gridx = 1;
        frame.add(picLabel,gc);

        //frame.getContentPane().add(thePanel);
        frame.pack();
        frame.setSize(900,600);
        frame.setVisible(true);


    }

    /**
     * Action Listener for rolling on the ant GUI window
     */
    class RollListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
	    // Roll for both players and append the propper text to the text scroll panel
            player.roll();
            computer.roll();
            text.append(player.getName() + " rolled: " + player.getRoll() + "\n");
            text.append(player.getName()  + " " + player.addPart());
            text.append(computer.getName() + " rolled: " + computer.getRoll() + "\n");
            text.append(computer.getName() + " "+ computer.addPart());
            text.append("\n");
	    
	    // set counter text on GUI
            pB.setText("" +(pBN - player.getThorax()));
            pH.setText("" +(pHN - player.getHead()));
            pL.setText("" +(pLN - player.getLegs()));
            pE.setText("" +(pEN - player.getEyes()));
            pA.setText("" +(pAN - player.getAntenna()));
            pT.setText("" +(pTN - player.getAbdomen()));
            cB.setText("" +(cBN - computer.getThorax()));
            cH.setText("" +(cHN - computer.getHead()));
            cL.setText("" +(cLN - computer.getLegs()));
            cE.setText("" +(cEN - computer.getEyes()));
            cA.setText("" +(cAN - computer.getAntenna()));
            cT.setText("" +(cTN - computer.getAbdomen()));
            
	    // message and reset if Player 1 wins
            if(player.hasWon()){
		//frame.setVisible(false);
	       game.increaseScore(0);
	       exitGUI exit = new exitGUI(game.getScore(0), game.getScore(1), player.getName(), computer.getName());
	       exit.setVisible(true);
	       frame.setVisible(false);
	       
	       text.append(player.getName() + " WINS!!\n\n");
	       // reset APlayer objects
	       player.reset();
	       computer.reset();
	       playerScore.setText(player.getName() + " has won: " + game.getScore(0) + " game(s)" );
		// reset counter text fields
                pB.setText("1");
                pH.setText("1");
                pL.setText("6");
                pE.setText("2");
                pA.setText("2");
		pT.setText("1");
                cB.setText("1");
                cH.setText("1");
                cL.setText("6");
                cE.setText("2");
                cA.setText("2");
		cT.setText("1");

		// reset counters
		pBN = 1;
		pHN = 1;
                pLN = 6;
        	pEN = 2;
		pAN = 2;
		pTN = 1;
                cBN = 1;
                cHN = 1;
                cLN = 6;
                cEN = 2;
                cAN = 2;
                cTN = 1;    
	    }	
	    
	    // message and reset if Player 2 wins
            if(computer.hasWon()){

                //frame.setVisible(false); 
                game.increaseScore(1);
                exitGUI exit = new exitGUI(game.getScore(0), game.getScore(1), player.getName(), computer.getName());
                exit.setVisible(true);
		frame.setVisible(false);
		
                text.append(computer.getName() + " WINS!!\n\n");
		// reset APlayer objects
                player.reset();
                computer.reset();
		        computerScore.setText("    " + computer.getName() + " has won: " + game.getScore(1) + " game(s)");
		// reset counter text fields
                pB.setText("1");
                pH.setText("1");
                pL.setText("6");
                pE.setText("2");
                pA.setText("2");
		pT.setText("1");
                cB.setText("1");
                cH.setText("1");
                cL.setText("6");
                cE.setText("2");
                cA.setText("2");
		cA.setText("1");
		
		// reset counters
                pBN = 1;
                pHN = 1;
                pLN = 6;
                pEN = 2;
                pAN = 2;
                pTN = 1; 
                cBN = 1;
                cHN = 1;
                cLN = 6;
                cEN = 2;
                cAN = 2;
                cTN = 1;
            }
            
        }
    }//end RollListener

    /**
     * Action Listener for exiting the ant GUi window
     */
    class ExitListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		System.exit(0);

	}
    }//end ExitListener
}
