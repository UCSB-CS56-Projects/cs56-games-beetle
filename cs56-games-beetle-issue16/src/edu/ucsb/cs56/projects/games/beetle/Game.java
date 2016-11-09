package edu.ucsb.cs56.projects.games.beetle;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Game{
	private int[] score = {0,0};
	public Game(){}
    /**
     * increaseScore takes an index i
     * and adds 1 the array score.
     * @param i i = 0 -> player score, i = 1 -> computer score
    */
	public void increaseScore(int i){
        this.score[i]++;
    }
    /**
     * setScore adds the surrent score to the indexs of the desired player
     * @param person who to add the score to, 0 -> player1, 1 -> player2
     * @param score score to add
     */
    public void setScore(int person, int score){
        this.score[person] = score;
    }
    /**
     * returns the score of the desired player
     * @param i which player's score to return, 0 -> player1, 1 -> player2
     */
    public int getScore(int i){
		return score[i];
}
}
