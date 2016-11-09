package edu.ucsb.cs56.projects.games.beetle;

// import java.awt.event.*;
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

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles

import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

class DrawComponent extends JComponent 
{
    private int whichOne=0;
    private int one=0;
    private int two=0;
    private int three=0;
    private int four=0;
    private int five=0;
    private int six=0;

    public DrawComponent(int whichOne, int one, int two, int three, int four, int five, int six)
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

	//	switch(this.whichOne) {

	    //case 3:
	    PDraw p = new PDraw(this.one, this.two, this.three, this.four, this.five, this.six);
	    //p.setVisible(true);
	    g2.setColor(Color.RED);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    
	    g2.draw(p);
	    //break;
	    	    
	    //	} // switch
	    

    } // paintComponent
}
