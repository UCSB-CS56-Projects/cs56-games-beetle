package edu.ucsb.cs56.projects.games.beetle;

import edu.ucsb.cs56.projects.games.beetle.player.Ant;
import edu.ucsb.cs56.projects.games.beetle.player.Beetle;
import edu.ucsb.cs56.projects.games.beetle.player.Ladybug;
import edu.ucsb.cs56.projects.games.beetle.player.Person;

import javax.sound.sampled.*; 
import javax.swing.*;
import java.awt.*;
import java.io.*; 

/**
 * Class for the GUI based game version.
 * @version Fall 2016, CS56, UCSB
 * @author  Yuanqi Li
 * @author  Samarth Goyal
 * 
 * @version Previous quarters
 * @author Dennis
 * @author Kevin Jih
 * @author Justin Nguyen
 * @author Alex Kang
 */
public class GuiBased {

    public BeetleGame game;
    
    GuiBased(BeetleGame game) {
        this.game = game;
    }

    /**
    * Run the main window with the game options.
    */
    
    void run() {

        JFrame frame = new JFrame("The Beetle Game");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
	gc.gridwidth = 2;
        JButton ant = new JButton("Ant");
	ant.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton beetle = new JButton("Beetle");
	beetle.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton ladybug = new JButton("Ladybug");
	ladybug.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton person = new JButton("Person");
	person.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton exit = new JButton("Exit");
	exit.setFont(new Font("Arial", Font.PLAIN, 20));

	JLabel picLabel1 = new JLabel();
        JLabel picLabel2 = new JLabel();
        JLabel picLabel3 = new JLabel();
        JLabel picLabel4 = new JLabel();
	picLabel1.setIcon(new ImageIcon(new ImageIcon("pictures/ant.jpg").getImage().getScaledInstance(100,75, Image.SCALE_DEFAULT)));
	picLabel2.setIcon(new ImageIcon(new ImageIcon("pictures/beetle.png").getImage().getScaledInstance(100,75, Image.SCALE_DEFAULT)));
	picLabel3.setIcon(new ImageIcon(new ImageIcon("pictures/human.png").getImage().getScaledInstance(100,75, Image.SCALE_DEFAULT)));
	picLabel4.setIcon(new ImageIcon(new ImageIcon("pictures/ladybug.jpg").getImage().getScaledInstance(100,75, Image.SCALE_DEFAULT)));
	picLabel1.setVisible(true);
	picLabel2.setVisible(true);
	picLabel3.setVisible(true);
	picLabel4.setVisible(true);

	
        ant.addActionListener(e -> { game.type = 0; choosePlayers(frame); });
        beetle.addActionListener(e -> { game.type = 1; choosePlayers(frame); });
        ladybug.addActionListener(e -> { game.type = 2; choosePlayers(frame); });
        person.addActionListener(e -> { game.type = 3; choosePlayers(frame); });
        exit.addActionListener(e -> System.exit(0));

	JLabel welcome_label = new JLabel("Welcome to the Beetle Game!");
	welcome_label.setFont(new Font("Serif", Font.PLAIN, 30));
        gc.gridx = 1; gc.gridy = 0; panel.add(welcome_label, gc);
	gc.gridy = 1; panel.add(ant, gc);
        gc.gridy = 2; panel.add(beetle, gc);
        gc.gridy = 3; panel.add(person, gc);
        gc.gridy = 4; panel.add(ladybug, gc);
	gc.insets = new Insets(5,0,0,0);
        gc.gridy = 5; panel.add(exit, gc);
	gc.insets = new Insets(0,40,0,0);
	JPanel pic2panel = new JPanel();
	pic2panel.setBackground(new Color(0,0,0));
	pic2panel.add(picLabel2);
	JPanel pic4panel = new JPanel();
        pic4panel.setBackground(new Color(0,0,255));
	pic4panel.setBorder(BorderFactory.createLineBorder(Color.black));
        pic4panel.add(picLabel4);
	gc.gridx = 0; gc.gridy = 2; panel.add(pic2panel, gc);
	gc.gridx = 0; gc.gridy = 4; panel.add(pic4panel, gc);
	gc.insets = new Insets(10,250,0,0);
	JPanel pic1panel = new JPanel();
        pic1panel.setBackground(new Color(153,51,255));
	pic1panel.setBorder(BorderFactory.createLineBorder(Color.black));
        pic1panel.add(picLabel1);
	JPanel pic3panel = new JPanel();
        pic3panel.setBackground(new Color(255,153,51));
	pic3panel.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        pic3panel.add(picLabel3);
	gc.gridx = 2; gc.gridy = 1; gc.weightx = 1; panel.add(pic1panel, gc);
	gc.gridx = 2; gc.gridy = 3; gc.weightx = 1; panel.add(pic3panel, gc);
	
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBackground(new Color(0,155,100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Beetle Game");
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
    * Choose number of players.
    */
    public void choosePlayers(JFrame frame) {
	Object[] options = {"Single Player", "Two Players"};
        game.numPlayer = JOptionPane.showOptionDialog(
                frame, "Make your decision!", "Make your decision!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        ) + 1;

        game.p1Name = (String)JOptionPane.showInputDialog(
                frame, "Enter Player 1's name", "Player 1",
                JOptionPane.PLAIN_MESSAGE, null, null, "Player 1"
        );
	if (game.p1Name == null) 
	    return; 
        if (game.numPlayer == 2) {
	    
            game.p2Name = (String)JOptionPane.showInputDialog(
                    frame, "Enter Player 2's name", "Player 2",
                    JOptionPane.PLAIN_MESSAGE, null, null, "Player 2"  
            );
	    if (game.p2Name == null) 
		return; 
	}
	
	frame.setVisible(false);
        mainFrame();
    }

    
    /**
    * The main frame that handles all of the GUI game data. 
    */	

    public void mainFrame() {
       
        JFrame frame = new JFrame();  
	ImageIcon[] picture = new ImageIcon[10];  

	JLabel picLabel0 = new JLabel();
	JLabel picLabel1 = new JLabel();
	JLabel picLabel2 = new JLabel();
	JLabel picLabel3 = new JLabel();
	JLabel picLabel4 = new JLabel();
	JLabel picLabel5 = new JLabel();
	JLabel picLabel6 = new JLabel();
	JLabel picLabel7 = new JLabel();
	GridBagConstraints gc = new GridBagConstraints();
        gc.gridwidth = 2;
	
	switch (game.type) {
        case 0: //CompoundIcon????
            game.p1 = new Ant(game.p1Name);
            game.p2 = new Ant(game.p2Name);
	    // picture = new ImageIcon(new ImageIcon("pictures/ant.jpg").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    //put this in for loop later
	    picture[0] = new ImageIcon(new ImageIcon("pictures/pictures/ant/thorax.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    picture[1] = new ImageIcon(new ImageIcon("pictures/pictures/ant/head.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    picture[2] = new ImageIcon(new ImageIcon("pictures/pictures/ant/legs.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    picture[3] = new ImageIcon(new ImageIcon("pictures/pictures/ant/eyes.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    picture[4] = new ImageIcon(new ImageIcon("pictures/pictures/ant/antenna.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[5] = new ImageIcon(new ImageIcon("pictures/pictures/ant/abdomen.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    picture[6] = new ImageIcon(new ImageIcon("pictures/pictures/ant/white.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    break;
        case 1:
            game.p1 = new Beetle(game.p1Name);
            game.p2 = new Beetle(game.p2Name);
	    picture[0] = new ImageIcon(new ImageIcon("pictures/pictures/Beetle/body.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[1] = new ImageIcon(new ImageIcon("pictures/pictures/Beetle/head.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[2] = new ImageIcon(new ImageIcon("pictures/pictures/Beetle/legs.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[4] = new ImageIcon(new ImageIcon("pictures/pictures/Beetle/antenna.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    picture[6] = new ImageIcon(new ImageIcon("pictures/pictures/Beetle/white.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    break;
        case 2:
            game.p1 = new Ladybug(game.p1Name);
            game.p2 = new Ladybug(game.p2Name);
	    picture[0] = new ImageIcon(new ImageIcon("pictures/pictures/ladybug/body.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[1] = new ImageIcon(new ImageIcon("pictures/pictures/ladybug/head.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[2] = new ImageIcon(new ImageIcon("pictures/pictures/ladybug/legs.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            //picture[3] = new ImageIcon(new ImageIcon("pictures/pictures/ladybug/eyes.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[4] = new ImageIcon(new ImageIcon("pictures/pictures/ladybug/antenna.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[5] = new ImageIcon(new ImageIcon("pictures/pictures/ladybug/wings.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    picture[6] = new ImageIcon(new ImageIcon("pictures/pictures/ladybug/white.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    break; 
	default:
            game.p1 = new Person(game.p1Name);
            game.p2 = new Person(game.p2Name);
	    picture[0] = new ImageIcon(new ImageIcon("pictures/pictures/person/body.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[1] = new ImageIcon(new ImageIcon("pictures/pictures/person/head.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[2] = new ImageIcon(new ImageIcon("pictures/pictures/person/legs.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[3] = new ImageIcon(new ImageIcon("pictures/pictures/person/eyes.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[4] = new ImageIcon(new ImageIcon("pictures/pictures/person/mouth.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[5] = new ImageIcon(new ImageIcon("pictures/pictures/person/arms.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
            picture[6] = new ImageIcon(new ImageIcon("pictures/pictures/person/white.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
	    break; 
	}

	//initialize JLabvels w/ ImageIcon obj
	picLabel0.setIcon(picture[0]); //for loop????                                                                                                                 
	picLabel1.setIcon(picture[1]);
	picLabel2.setIcon(picture[2]);
	picLabel3.setIcon(picture[3]);
	picLabel4.setIcon(picture[4]);
	picLabel5.setIcon(picture[5]);
	picLabel6.setIcon(picture[6]);
	
	//p2 pic objects
	JLabel picLabel_0 = new JLabel();
        JLabel picLabel_1 = new JLabel();
        JLabel picLabel_2 = new JLabel();
        JLabel picLabel_3 = new JLabel();
        JLabel picLabel_4 = new JLabel();
        JLabel picLabel_5 = new JLabel();
        JLabel picLabel_6 = new JLabel();
        picLabel_0.setIcon(picture[0]);
        picLabel_1.setIcon(picture[1]);
        picLabel_2.setIcon(picture[2]);
        picLabel_3.setIcon(picture[3]);
        picLabel_4.setIcon(picture[4]);
        picLabel_5.setIcon(picture[5]);
        picLabel_6.setIcon(picture[6]);

        // Set player 1 score boards
        JPanel player1Panel = new JPanel(new GridBagLayout());
        player1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	player1Panel.setBackground(new Color(255,192,0));
	
        JLabel p1Score[] = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            gc.gridy = i + 1; gc.gridx = 0;
            player1Panel.add(new JLabel(game.p1.getPartName(i)), gc);
            p1Score[i] = new JLabel(Integer.toString(game.p1.getPartNeed(i)));
            gc.gridx = 6;
            player1Panel.add(p1Score[i], gc);
        }

        JPanel p1Board = new JPanel();
        p1Board.setLayout(new BoxLayout(p1Board, BoxLayout.Y_AXIS));
        p1Board.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	p1Board.setBackground(new Color(255,128,0));
        JLabel p1NameLable = new JLabel(game.p1.getName() + " score: " + this.game.p1Score);
        p1NameLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1Board.setSize(5, 15);
	p1Board.add(p1NameLable);
        p1Board.add(player1Panel);


        // Set player 2 score boards
        JPanel player2Panel = new JPanel(new GridBagLayout());
        player2Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	player2Panel.setBackground(new Color(0,192,255));
        JLabel p2Score[] = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            gc.gridy = i + 1; gc.gridx = 3;
            player2Panel.add(new JLabel(game.p2.getPartName(i)), gc);
            p2Score[i] = new JLabel(Integer.toString(game.p2.getPartNeed(i)));
            gc.gridx = 0;
            player2Panel.add(p2Score[i], gc);
        }

        JPanel p2Board = new JPanel();
        p2Board.setLayout(new BoxLayout(p2Board, BoxLayout.Y_AXIS));
        p2Board.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	p2Board.setBackground(new Color(0,172,255));
        JLabel p2NameLable = new JLabel(game.p2.getName() + " score: " + this.game.p2Score);
        p2NameLable.setAlignmentX(Component.CENTER_ALIGNMENT);
	p2Board.setSize(5, 15);
        p2Board.add(p2NameLable);
        p2Board.add(player2Panel);

        // Set game info board
        JPanel display = new JPanel();
	display.setBackground(new Color(100,50,0));
        JTextArea text = new JTextArea(20, 26);
        JScrollPane scroll = new JScrollPane(text);
        text.setEditable(false);
        display.add(scroll);

        // Add control buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
	controlPanel.setBackground(new Color(0,155,100));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton roll = new JButton("Roll");
	JButton home = new JButton("Home");
	JButton exit = new JButton("Exit");
	JButton instructions  = new JButton("Instructions");

        roll.addActionListener(e -> {
            text.append(game.p1.addPart() + "\n");
            text.append(game.p2.addPart() + "\n\n");
	    
	    int roll1 = game.p1.getRoll(); 
	    int roll2 = game.p2.getRoll(); 
	    
	    switch (roll1) { 
	    case 0:
		if (game.p1.getPartNeed(0) == 0) { 
		    picLabel0.setVisible(true);
		    break; 
		}
		break; 
	    case 1: 
		if (game.p1.getPartNeed(1) == 0) {
                    picLabel1.setVisible(true);
                    break;
		}
		break; 
	    case 2:
		if (game.p1.getPartNeed(2) == 0) {
                    picLabel2.setVisible(true);
                    break;
		}
                break;
	    case 3:
                if (game.p1.getPartNeed(3) == 0) {
                    picLabel3.setVisible(true);
                    break;
		}
                break;
	    case 4:
		if (game.p1.getPartNeed(4) == 0) {
                    picLabel4.setVisible(true);
		    break; 
		}
                break;
	    case 5:
                if (game.p1.getPartNeed(5) == 0) {
                    picLabel5.setVisible(true);
                    break;
		}
                break;
	    default: 
		break; 
	    } 
		

	    //p2
	    switch (roll2) {
            case 0:
                if (game.p2.getPartNeed(0) == 0) {
                    picLabel_0.setVisible(true);
                    break;
                }
                break;
            case 1:
                if (game.p2.getPartNeed(1) == 0) {
                    picLabel_1.setVisible(true);
                    break;
                }
                break;
            case 2:
                if (game.p2.getPartNeed(2) == 0) {
                    picLabel_2.setVisible(true);
                    break;
                }
                break;
            case 3:
                if (game.p2.getPartNeed(3) == 0) {
                    picLabel_3.setVisible(true);
                    break;
                }
                break;
            case 4:
                if (game.p2.getPartNeed(4) == 0) {
                    picLabel_4.setVisible(true);
                    break;
                }
                break;
            case 5:
                if (game.p2.getPartNeed(5) == 0) {
                    picLabel_5.setVisible(true);
                    break;
                }
                break;		
	    default: 
		break; 
	    }

	    //roll sound
	    music();
	    
            for (int i = 0; i < 6; i++) {
                p1Score[i].setText(Integer.toString(game.p1.getPartNeed(i)));
                p2Score[i].setText(Integer.toString(game.p2.getPartNeed(i)));
            }
	    
            if (game.p1.isWin() && !game.p2.isWin()) {
                game.p1Score++;
                chooseContinue(frame, game.p1.getName() + " won!");
            } else if (game.p2.isWin() && !game.p1.isWin()) {
                game.p2Score++;
                chooseContinue(frame, game.p2.getName() + " won!");
            } else if (game.p2.isWin() && game.p1.isWin()) {
                game.p1Score++;
                game.p2Score++;
                chooseContinue(frame, "Tie!");
            }
        });
	
	home.addActionListener(e -> {
	    frame.setVisible(false);
	    run(); 
	    this.game = new BeetleGame(0,0);
	});

        exit.addActionListener(e -> System.exit(0));
	
	//instructions button
	instructions.addActionListener(e -> {
		JFrame i_frame = new JFrame();
		ImageIcon[] dice_pictures = new ImageIcon[10];
		dice_pictures[0] = new ImageIcon(new ImageIcon("pictures/pictures/dice/Dice0.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT)); 
		dice_pictures[1] = new ImageIcon(new ImageIcon("pictures/pictures/dice/Dice1.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
		dice_pictures[2] = new ImageIcon(new ImageIcon("pictures/pictures/dice/Dice2.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
		dice_pictures[3] = new ImageIcon(new ImageIcon("pictures/pictures/dice/Dice3.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
		dice_pictures[4] = new ImageIcon(new ImageIcon("pictures/pictures/dice/Dice4.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
		dice_pictures[5] = new ImageIcon(new ImageIcon("pictures/pictures/dice/Dice5.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
		i_frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER)); 
		
		i_frame.setSize(470, 300);
                i_frame.getContentPane().setBackground(new Color(0,155,100));
                i_frame.setVisible(true);
                i_frame.setResizable(false);
                i_frame.setTitle("Beetle Game Instructions");

		JLabel dice_label_0 = new JLabel();
		JLabel dice_label_1 = new JLabel();
		JLabel dice_label_2 = new JLabel();
		JLabel dice_label_3 = new JLabel();
		JLabel dice_label_4 = new JLabel();
		JLabel dice_label_5 = new JLabel();
		JLabel dice_label_6 = new JLabel();
		dice_label_0.setIcon(dice_pictures[0]);
		dice_label_1.setIcon(dice_pictures[1]);
		dice_label_2.setIcon(dice_pictures[2]);
		dice_label_3.setIcon(dice_pictures[3]);
		dice_label_4.setIcon(dice_pictures[4]);
		dice_label_5.setIcon(dice_pictures[5]);
		dice_label_6.setIcon(dice_pictures[6]);
		
		i_frame.getContentPane().add(dice_label_0);
		i_frame.getContentPane().add(dice_label_1);
		i_frame.getContentPane().add(dice_label_2);
		i_frame.getContentPane().add(dice_label_3);
		i_frame.getContentPane().add(dice_label_4);
		i_frame.getContentPane().add(dice_label_5);
		i_frame.getContentPane().add(dice_label_6);
		dice_label_0.setVisible(true);
		dice_label_1.setVisible(true);
		dice_label_2.setVisible(true);
		dice_label_3.setVisible(true);
		dice_label_4.setVisible(true);
		dice_label_5.setVisible(true);
		dice_label_6.setVisible(true);
		JLabel info1 = new JLabel();

		String infoStr = "     ";
		for (int i = 0; i < 6; i++)
		    infoStr +=  game.p1.getPartName(i) + "      ";
		info1.setText(infoStr);
		i_frame.getContentPane().add(info1);
		
		JTextArea textArea = new JTextArea(
		    "\n\nWelcome to the Beetle Game!\n\n" + 
		    "-To play, click \"roll\", the number you get will correspond to the above\n " +
		    "insect body parts.\n-You first must obtain a \"body\" in order to add other\n " +
		    "body parts such as legs, eyes...\n-Once you've obtained a body, your goal is " + 
		    "to collect \nall of the insect's body parts before your opponent! Good luck!!\n\n\n\n\n"
                );
		Font font1 = new Font("Verdana", Font.BOLD, 12);  
		textArea.setFont(font1);
		textArea.setForeground(Color.BLACK);
		//textArea.setBackground(new Color(0,155,100));
                textArea.setEnabled(false);
		i_frame.getContentPane().add(textArea);
	    }); 
		
	
        roll.setAlignmentX(Component.CENTER_ALIGNMENT);
	home.setAlignmentX(Component.CENTER_ALIGNMENT);
	exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        controlPanel.add(roll);
	controlPanel.add(home);
        controlPanel.add(instructions);
	controlPanel.add(exit);
        
	GridBagLayout layout  = new GridBagLayout();
	JPanel panel = new JPanel(layout);
	GridBagConstraints c = new GridBagConstraints();

	frame.getContentPane().add(panel);
	
	//adding p1 panel with constraints to 0,0 of gridlayout
	c.fill = GridBagConstraints.BOTH;
	c.weighty = .5; 
	c.gridx = 0;
	c.gridy = 0;
	panel.add(p1Board, c); 
	
	//set weight 
 
	c.weightx = 1;
	c.gridx = 1;
	c.gridy = 0;
	panel.add(display, c);
 
	//panel board 2
	c.weightx = 0; 
	c.gridx = 2; 
	c.gridy = 0; 
	panel.add(p2Board, c);
	
       
	c.gridx = 0;
        c.gridy = 1;
	//panel.add(picLabel_2, c);
	panel.add(picLabel0, c); 
	panel.add(picLabel1, c); 
	panel.add(picLabel2, c); 
	panel.add(picLabel3, c); 
	panel.add(picLabel4, c); 
	panel.add(picLabel5, c); 
	panel.add(picLabel6, c); 
	picLabel0.setVisible(false); 
	picLabel1.setVisible(false);
	picLabel2.setVisible(false);
	picLabel3.setVisible(false);
	picLabel4.setVisible(false);
	picLabel5.setVisible(false);
	picLabel6.setVisible(true);

	c.weightx = 1;
	c.gridx = 1;
        c.gridy = 1;
	panel.add(controlPanel, c);

	c.weightx = 0;
	c.gridx = 2;
        c.gridy = 1;
	panel.add(picLabel_0, c);
	panel.add(picLabel_1, c);
	panel.add(picLabel_2, c);
	panel.add(picLabel_3, c);
	panel.add(picLabel_4, c);
	panel.add(picLabel_5, c);
	panel.add(picLabel_6, c);
	picLabel_0.setVisible(false); 
	picLabel_1.setVisible(false);
	picLabel_2.setVisible(false);
	picLabel_3.setVisible(false);
	picLabel_4.setVisible(false);
	picLabel_5.setVisible(false);
	picLabel_6.setVisible(true);

        // Create the main window
        // frame.getContentPane().add(p1Board, panel);//frame.getContentPane().add(p1Board, BorderLayout.WEST);
        // frame.getContentPane().add(p2Board, panel);//frame.getContentPane().add(p2Board, BorderLayout.EAST); 
        // frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
        // frame.getContentPane().add(display, BorderLayout.CENTER);
        



	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Beetle Game");
        frame.setSize(750, 480);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    
    /**
    * Does the player want to play again or not?
    */
    
    public void chooseContinue(JFrame frame, String msg) {

        Object[] options = {"Continue", "Exit"};
        int isContinue = JOptionPane.showOptionDialog(
                frame, msg, "Do you want to continue?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        );
       
        frame.setVisible(false);

        if (isContinue == 1) {
            System.exit(0);
        } else {
            //Choose what kind of game the user wants to play this time
            Object[] choices = {"Ant", "Beetle", "Ladybug", "Person"};
            int option = JOptionPane.showOptionDialog(
                    frame, "Enter a new game mode.", "Enter a new game mode",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]); 
	    game.setGameType(option);
            mainFrame();
        }
    }
    public void music() {
     	new Thread(new Runnable() { 

	    public void run() { 
		try { 
		    File file = new File("roll.wav");
		    Clip clip = AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(file));
		    
		    //Thread.sleep(clip.getMicrosecondLength());
		    clip.start();
		}catch (Exception e) { System.err.println(e.getMessage()); } 
	    }
	}).start();
    }
}
