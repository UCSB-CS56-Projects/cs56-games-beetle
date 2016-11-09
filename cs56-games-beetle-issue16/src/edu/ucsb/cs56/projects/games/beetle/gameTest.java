package edu.ucsb.cs56.projects.games.beetle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class gameTest {

    @Test public void test_antGUI(){

	antGUI agui = new antGUI();
	APlayer aP = new APlayer();

	aP.manualRoll(1);
	assertEquals(1, aP.getRoll());
	aP.addPart();
	assertEquals(1, aP.getThorax());
	
	aP.manualRoll(2);
	assertEquals(2,aP.getRoll());
	aP.addPart();
	assertEquals(1, aP.getHead());

	aP.manualRoll(3);
	assertEquals(3, aP.getRoll());
	aP.addPart();
	assertEquals(1, aP.getLegs());

	aP.manualRoll(3);
	assertEquals(3, aP.getRoll());
	aP.addPart();
	assertEquals(2, aP.getLegs());

	aP.manualRoll(3);
	assertEquals(3, aP.getRoll());
	aP.addPart();
	assertEquals(3, aP.getLegs());

	aP.manualRoll(4);
	assertEquals(4, aP.getRoll());
	aP.addPart();
	assertEquals(1, aP.getEyes());

	aP.manualRoll(4);
	assertEquals(4, aP.getRoll());
	aP.addPart();
	assertEquals(2, aP.getEyes());

	assertEquals(0, aP.getAntenna());
	
	aP.manualRoll(6);
	assertEquals(6, aP.getRoll());
	aP.addPart();
	assertEquals(1, aP.getAbdomen());
	
	assertEquals(0, agui.game.getScore(0));
	assertEquals(0, agui.game.getScore(1));
    }

    @Test public void test_beetleGUI(){
	
	beetleGUI bgui = new beetleGUI();
	BPlayer bP = new BPlayer();

	bP.manualRoll(1);
	assertEquals(1, bP.getRoll());
	bP.addPart();
	assertEquals(1, bP.getBody());

	bP.manualRoll(2);
	assertEquals(2, bP.getRoll());
	bP.addPart();
	assertEquals(1, bP.getHead());

	bP.manualRoll(3);
	assertEquals(3, bP.getRoll());
	bP.addPart();
	assertEquals(1, bP.getLegs());

	bP.manualRoll(3);
	assertEquals(3, bP.getRoll());
	bP.addPart();
	assertEquals(2, bP.getLegs());

	bP.manualRoll(3);
	assertEquals(3, bP.getRoll());
	bP.addPart();
	assertEquals(3, bP.getLegs());

	bP.manualRoll(4);
	assertEquals(4, bP.getRoll());
	bP.addPart();
	assertEquals(1, bP.getEyes());

	bP.manualRoll(4);
	assertEquals(4, bP.getRoll());
	bP.addPart();
	assertEquals(2, bP.getEyes());

	assertEquals(0, bP.getAntenna());
	
	bP.manualRoll(6);
	assertEquals(6, bP.getRoll());
	bP.addPart();
	assertEquals(1, bP.getTail());

	
	assertEquals(0, bgui.game.getScore(0));
	assertEquals(0, bgui.game.getScore(1));
    }

    @Test public void test_personGUI(){
	
	personGUI pgui = new personGUI();
	PPlayer pP = new PPlayer();

	
	pP.manualRoll(1);
	assertEquals(1, pP.getRoll());
	pP.addPart();
	assertEquals(1, pP.getBody());

	pP.manualRoll(2);
	assertEquals(2, pP.getRoll());
	pP.addPart();
	assertEquals(1, pP.getHead());

	pP.manualRoll(3);
	assertEquals(3, pP.getRoll());
	pP.addPart();
	assertEquals(1, pP.getLegs());

	pP.manualRoll(3);
	assertEquals(3, pP.getRoll());
	pP.addPart();
	assertEquals(2, pP.getLegs());

	pP.manualRoll(4);
	assertEquals(4, pP.getRoll());
	pP.addPart();
	assertEquals(1, pP.getEyes());

	pP.manualRoll(4);
	assertEquals(4, pP.getRoll());
	pP.addPart();
	assertEquals(2, pP.getEyes());

	assertEquals(0, pP.getMouth());

	pP.manualRoll(6);
	assertEquals(6, pP.getRoll());
	pP.addPart();
	assertEquals(1, pP.getArms());

	pP.manualRoll(6);
	assertEquals(6, pP.getRoll());
	pP.addPart();
	assertEquals(2, pP.getArms());
	
	assertEquals(0, pgui.game.getScore(0));
	assertEquals(0, pgui.game.getScore(1));
    }

    @Test public void test_ladybugGUI(){
	
	ladybugGUI lgui = new ladybugGUI();
	LPlayer lP = new LPlayer();
	
	lP.manualRoll(1);
	assertEquals(1, lP.getRoll());
	lP.addPart();
	assertEquals(1, lP.getBody());

	lP.manualRoll(2);
	assertEquals(2, lP.getRoll());
	lP.addPart();
	assertEquals(1, lP.getHead());

	lP.manualRoll(3);
	assertEquals(3, lP.getRoll());
	lP.addPart();
	assertEquals(1, lP.getLegs());

	lP.manualRoll(3);
	assertEquals(3, lP.getRoll());
	lP.addPart();
	assertEquals(2, lP.getLegs());

	lP.manualRoll(3);
	assertEquals(3, lP.getRoll());
	lP.addPart();
	assertEquals(3, lP.getLegs());

	lP.manualRoll(4);
	assertEquals(4, lP.getRoll());
	lP.addPart();
	assertEquals(1, lP.getEyes());

	lP.manualRoll(4);
	assertEquals(4, lP.getRoll());
	lP.addPart();
	assertEquals(2, lP.getEyes());

	assertEquals(0, lP.getAntenna());

	lP.manualRoll(6);
	assertEquals(6, lP.getRoll());
	lP.addPart();
	assertEquals(1, lP.getWings());

	
	assertEquals(0, lgui.game.getScore(0));
	assertEquals(0, lgui.game.getScore(1));
    }

    //Open the start game window
    @Test public void test_startGUI(){
	startGUI sgui = new startGUI();
	sgui.setUpHomeScreen();
    }
    
    //Open the end game window
    @Test public void test_exitGUI(){
	exitGUI egui = new exitGUI();
	egui.setVisible(true);
    }
    
}
