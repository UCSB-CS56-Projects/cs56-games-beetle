package edu.ucsb.cs56.projects.games.beetle;

//import java.awt.event.*;
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

class DrawPanel extends JPanel 
{
    private int whichOne=0;
    private int one=0;
    private int two=0;
    private int three=0;
    private int four=0;
    private int five=0;
    private int six=0;

    public DrawPanel(int whichOne, int one, int two, int three, int four, int five, int six)
    {
	this.whichOne = whichOne;
	this.one = one;
	this.two = two;
	this.three = three;
	this.four = four;
	this.five = five;
	this.six = six;
    }

    public void setParts(int one, int two, int three, int four, int five, int six)
    {
	this.one = one;
	this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }

    public void paintComponent(Graphics g) 
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(Color.red);
	g2.fillRect(0,0,this.getWidth(),this.getHeight());
	switch(this.whichOne) {

        case 3:
	    PDraw p = new PDraw(this.one, this.two, this.three, this.four, this.five, this.six);
	    g2.draw(p);
	    break;


	} // switch


    } // paintComponent
}
