package edu.ucsb.cs56.projects.games.beetle;
import java.awt.*;
import java.util.*;

public class BPlayer{
	private String name;
    private int roll=0;
	/**
        The following ints hold the number of body
        parts that the beetle is supposed to have.
        They start off at 0 and should end up at
        1,1,6,2,2,1 respectively in order to win.
    */
	private int body=0;
	private int head=0;
	private int legs=0;
	private int eyes=0;
	private int antenna=0;
	private int tail=0;
	
 

    /**
        The BPlayer constructor takes no arguments 
        and creates a BPlayer object
    */
	public BPlayer(){}//end constructor

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
	public int getBody(){return this.body;}
	public int getHead(){return this.head;}
	public int getLegs(){return this.legs;}
	public int getEyes(){return this.eyes;}
	public int getAntenna(){return this.antenna;}
	public int getTail(){return this.tail;}
	
    /**
        manualRoll is used for testing. The parameter
        i should be the body part that you want to add 
        to your BPlayer object
    */
    public void manualRoll(int i){
		this.roll=i;
	}
	/** 
        roll takes no arguments and randomly generates a value between
        1 and 6.
            1 = body
            2 = head
            3 = legs
            4 = eyes
            5 = antenna
            6 = tail
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
        if your BPlayer object needs the body part or not.
        It returns the string that corresponds with the
        action that was preformed. Note that there is already a \n
        included in the string.
    */
	public String addPart(){
		
		if(roll==1 && body==0){
			body++;
			return "added a body\n";
		}
		if(roll==1 && body==1){
			return "already has a body\n";
		}
		if(roll==2 && head==0 && body==1){
			head++;
			return "added a head\n";
		}
		if(roll==2 && head==0 && body==0){
			return "needs a body first\n";
		}
		if(roll==2 && head==1){
			return "already has a head\n";
		}
		if(roll==3 && body==1 && legs<6){
			legs++;
			return "added a leg\n";
		}
		if(roll==3 && body==0){
			return "needs a body first\n";
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
		if(roll==6 && body==1 && tail<1){
			tail++;
			return "added a tail\n";
		}
		if(roll==6 && body==0){
			return "needs a body first\n";
		}
		if(roll==6 && tail==1){
			return "already has a tail\n";
		}
		return "Something went wrong\n";		
	}//end addPart	
	/**
        hasWon checks to see if the BPlayer obeject
        has all of the necessary body parts. This method
        should be called after every turn.
    */
    public boolean hasWon(){
		if(head==1 && body==1 && 
		   eyes==2 && antenna==2 && 
		   legs==6 && tail==1){
			return true;
		}
		else
			return false;
	}//end hasWon
    /**
        reset method will set all the body parts back to 0.
        This is used if the user wants to play again
    */
    public void reset(){
        body=0;
        head=0;
        legs=0;
        eyes=0;
        antenna=0;
        tail=0;
    }
	public void draw(){
	
	}
	

}//end BPlayer	
