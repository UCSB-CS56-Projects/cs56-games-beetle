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

import java.awt.geom.GeneralPath;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.projects.games.utilities.GeneralPathWrapper;

public class PDraw extends GeneralPathWrapper implements Shape
{
    private int body=0;
    private int head=0;
    private int legs=0;
    private int eyes=0;
    private int mouth=0;
    private int arms=0;

    
    public PDraw(int body, int head, int legs, int eyes, int mouth, int arms)
    {
	Line2D.Double b = new Line2D.Double(50,50,50,150);

	GeneralPath wholePerson = this.get();
	wholePerson.append(b, false);
    }
}


