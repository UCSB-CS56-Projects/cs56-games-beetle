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
 * @author Alex Kang
 */
public class startGUI {
    JFrame frame = new JFrame("Dice Rolling Game");
    JPanel thePanel = new JPanel(new GridBagLayout());
    JLabel title = new JLabel("Welcome to Dice Rolling Game!");

    JButton person = new JButton("Person");
    JButton ant = new JButton("Ant");
    JButton beetle = new JButton("Beetle");
    JButton ladybug = new JButton("Ladybug");
    JButton exit = new JButton("Exit");
    private int playerScore=0;
    private int computerScore=0;
	private String playerName="";
	private String computerName="";

    public startGUI(){

    }
    /**
     * @param playerscore      the score of the player(player 1)
     * @param computerscore    the score of the computer(player 2)
     */
    public startGUI(int playerScore, int computerScore){
    	this.playerScore = playerScore;
    	this.computerScore = computerScore;
    }

	public startGUI(int playerScore, int computerScore, String playerName, String computerName){
		this.playerScore = playerScore;
		this.computerScore = computerScore;
		this.playerName = playerName;
		this.computerName = computerName;
	}

    /**
     * Launches the start GUI window which includes buttons to choose the level and to exit the game
     */
    public void setUpHomeScreen(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
	frame.getContentPane().setBackground(new Color(135, 206, 235));
        GridBagConstraints gc = new GridBagConstraints();
        
	// add title to frame
	gc.gridwidth=2;
        gc.gridx=2;
        gc.gridy=0;
        frame.add(title, gc);
        
	// add "Ant" button to launch antGUI
	gc.gridy=1;
	ant.addActionListener(new AntListener());
	frame.add(ant, gc);

	// add "Beetle" button to launch beetleGUI
        gc.gridy=2;
	beetle.addActionListener(new BeetleListener());
	frame.add(beetle, gc);

	// add "Person" button to launch personGUI
	gc.gridy=3;
	person.addActionListener(new PersonListener());
	frame.add(person, gc);

	//add "LadyBug" button to launch ladybugGUI
	gc.gridy=4;
	ladybug.addActionListener(new LadybugListener());
	frame.add(ladybug, gc);
	
	// add exit button
	gc.gridy=5;
        exit.addActionListener(new ExitListener());
        frame.add(exit, gc);



        //frame.getContentPane().add(thePanel);
        frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
        
        
    }
    /**
     * Action listener for the ant level button
     * Creates an instance of antGUI and calls the setUpHomeScreen method
     */
    class AntListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	   if(startGUI.this.playerScore > 0 || startGUI.this.computerScore > 0){
		   antGUI agui = new antGUI(startGUI.this.playerScore, startGUI.this.computerScore, startGUI.this.playerName, startGUI.this.computerName);
		   agui.setUpHomeScreenAgain();
		   frame.setVisible(false);
	   }
	   else{
	       antGUI agui = new antGUI();
	       agui.setUpHomeScreen();
	       frame.setVisible(false);
	   }
	   
	}
    }//end AntListener

    /**                                                                                                                                                                                                    
     * Action listener for the beetle level button                                                                                                                             
     * Creates an instance of beetleGUI and calls the setUpHomeScreen method                                                                                                                              
     */
    class BeetleListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    if(startGUI.this.playerScore > 0 || startGUI.this.computerScore > 0){
	   		beetleGUI bgui = new beetleGUI(startGUI.this.playerScore, startGUI.this.computerScore, startGUI.this.playerName, startGUI.this.computerName);
			bgui.setUpHomeScreenAgain();
			frame.setVisible(false);
	    }
	    else{
			beetleGUI bgui = new beetleGUI();
			bgui.setUpHomeScreen();
			frame.setVisible(false);
	    }
	}
    }//end BeetleListener

    /**                                                                                                                                                                                                    
     * Action listener for the person level button
     * Creates an instance of personGUI and calls the setUpHomeScreen method                                                                                                                              
     */
    class PersonListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    if(startGUI.this.playerScore > 0 || startGUI.this.computerScore > 0){
	   		personGUI pgui = new personGUI(startGUI.this.playerScore, startGUI.this.computerScore, startGUI.this.playerName, startGUI.this.computerName);
			pgui.setUpHomeScreenAgain();
			frame.setVisible(false);
	    }
	    else{
			personGUI pgui = new personGUI();
			pgui.setUpHomeScreen();
			frame.setVisible(false);
	    }
	}
    }//end PersonListener

    /**                                                                                                                                                                                                    
     * Action listener for the ladybug level button                                                                                                                                                        
     * Creates an instance of ladybugGUI and calls the setUpHomeScreen method                                                                                                                              
     */
    class LadybugListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    if(startGUI.this.playerScore > 0 || startGUI.this.computerScore > 0){
	   		ladybugGUI lbgui = new ladybugGUI(startGUI.this.playerScore, startGUI.this.computerScore, startGUI.this.playerName, startGUI.this.computerName);
			lbgui.setUpHomeScreenAgain();
			frame.setVisible(false);
	    }
	    else{
			ladybugGUI lbgui = new ladybugGUI();
			lbgui.setUpHomeScreen();
			frame.setVisible(false);
	    }
	}
    }//end LadybugListener

    /**                                                                                                                                                                                                    
     * Action listener for the exit button                                                                                                                                                         
     * Closes the window and ends the game process
     */
    class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.exit(0);

	}
    }//end ExitListener
}
