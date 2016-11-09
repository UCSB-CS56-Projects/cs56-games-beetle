package edu.ucsb.cs56.projects.games.beetle;
import java.awt.*;
import java.util.*;

public class APlayer{
    private String name;
    private int roll=0;
    /**
        The following ints hold the number of body
        parts that the ant is supposed to have.
        They start off at 0 and should end up at
        1,1,6,2,2,1 respectively in order to win.
    */
    private int abdomen=0;
    private int head=0;
    private int legs=0;
    private int eyes=0;
    private int antenna=0;
    private int thorax=0;
    
    /**
        The APlayer constructor takes no arguments 
        and creates a APlayer object
    */
    public APlayer(){}//end constructor

    //here are the getters and setters for name and roll
    public String getName(){
	return this.name;
    }
    /**
        getRoll will return the current roll.
    */
    public int getRoll(){
	return this.roll;
    }
    /**
        setName can be implemented later in the GUI
        to allow a user to set their in-game name
    */
    public void setName(String a){
	this.name=a;
    }
    /**
        The following 6 methods return the number of
        body parts each part has
    */
    public int getThorax(){return this.thorax;}
    public int getAbdomen(){return this.abdomen;}
    public int getHead(){return this.head;}
    public int getLegs(){return this.legs;}
    public int getEyes(){return this.eyes;}
    public int getAntenna(){return this.antenna;}
    public int getTail(){return this.thorax;}
    /**
        manualRoll is used for testing. The parameter
        i should be the thorax part that you want to add 
        to your APlayer object
    */
    public void manualRoll(int i){
	this.roll=i;
    }
    /** 
        roll takes no arguments and randomly generates a value between
        1 and 6.
            1 = thorax
            2 = head
            3 = legs
            4 = eyes
            5 = antenna
            6 = abdomen
    */
    public void roll(){
	Random rnd = new Random();
	int min=1;
	int max=6;
	int rndInt = rnd.nextInt(max - min + 1) + min;
	this.roll=rndInt;
    }
    
    /**
        Add part will take the current roll and determine
        if your APlayer object needs the thorax part or not.
        It returns the string that corresponds with the
        action that was preformed. Note that there is already a \n
        included in the string.
    */
	public String addPart(){
		
		if(roll==1 && thorax==0){
			thorax++;
			return "added a thorax\n";
		}
		if(roll==1 && thorax==1){
			return "already has a thorax\n";
		}
		if(roll==2 && head==0 && thorax==1){
			head++;
			return "added a head\n";
		}
		if(roll==2 && head==0 && thorax==0){
			return "needs a thorax first\n";
		}
		if(roll==2 && head==1){
			return "already has a head\n";
		}
		if(roll==3 && thorax==1 && legs<6){
			legs++;
			return "added a leg\n";
		}
		if(roll==3 && thorax==0){
			return "needs a thorax first\n";
		}
		if(roll==3 && legs==6){
			return "already has enough legs\n";
		}
		if(roll==4 && head==1 && eyes<2){
			eyes++;
			return "added an eye\n";
		}
		if(roll==4 && head==0){
			return "needs a head first\n";
		}
		if(roll==4 && eyes==2){
			return "already has enough eyes\n";
		}
		if(roll==5 && head==1 && antenna<2){
			antenna++;
			return "added an antenna\n";
		}
		if(roll==5 && head==0){
			return "needs a head first\n";
		}
		if(roll==5 && antenna==2){
			return "already has enough antenna\n";
		}
		if(roll==6 && thorax==1 && abdomen<1){
			abdomen++;
			return "added a abdomen\n";
		}
		if(roll==6 && thorax==0){
			return "needs a thorax first\n";
		}
		if(roll==6 && thorax==1){
			return "already has an abdomen\n";
		}
		return "Something went wrong\n";		
	}//end addPart	
	/**
        hasWon checks to see if the APlayer obeject
        has all of the necessary thorax parts. This method
        should be called after every turn.
    */
    public boolean hasWon(){
		if(head==1 && thorax==1 && 
		   eyes==2 && antenna==2 && 
		   legs==6 && abdomen==1){
			return true;
		}
		else
			return false;
	}//end hasWon
    /**
        reset method will set all the thorax parts back to 0.
        This is used if the user wants to play again
    */
    public void reset(){
        thorax=0;
        head=0;
        legs=0;
        eyes=0;
        antenna=0;
        abdomen=0;
    }
	public void draw(){
	
	}
    

}//end APlayer	
