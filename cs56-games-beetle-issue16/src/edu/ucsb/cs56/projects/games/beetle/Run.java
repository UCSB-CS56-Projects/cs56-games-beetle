package edu.ucsb.cs56.projects.games.beetle;
import java.awt.*;
import java.io.*;
import javax.swing.*;
/**
	This is the code for the game Beetle
	It allows for a player to play against a computer	
        @author Aki Stankoski and Dennis Huynh
        @version for cs56, Winter 12, UCSB
*/

public class Run{
    // Start the startGUI
    public static void main(String[] args){
        startGUI gui = new startGUI();
        gui.setUpHomeScreen();
    }
}

