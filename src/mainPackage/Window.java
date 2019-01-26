package mainPackage;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;

import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class Window extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int interestsCount=0;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private RoundButton playButton;
	private ArrayList<JCheckBox> interests;
	private Window w;
	
	JLabel lblNbrOfCorrectAns;
	JLabel lblCheerUp;
	
	public Window() {
		this.setResizable(false);
		this.setTitle("Quiz Game");
		this.setBounds(100, 100, 600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.w = this;
		
		Container defaultPane = this.getContentPane();
		
		CardLayout c1 = new CardLayout(0, 0);
		defaultPane.setLayout(c1);
		
		JPanel panel = new JPanel();
		defaultPane.add(panel);
		panel.setLayout(null);
		
		
		playButton = new RoundButton("Play");
		playButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.next(defaultPane);
			}
		});
		playButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		playButton.setForeground(new Color(255, 255, 255));
		playButton.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		playButton.setBackground(new Color(0, 128, 0));
		playButton.setBounds(458, 440, 100, 100);
		panel.add(playButton);
		
		RoundButton scoreButton = new RoundButton("Play");
		scoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"1 - 1000\n2 - 800\n3 - 700\n4 - 500\n5 - 450","Top Scores",JOptionPane.PLAIN_MESSAGE);
			}
		});
		scoreButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scoreButton.setText("Score");
		scoreButton.setForeground(Color.WHITE);
		scoreButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		scoreButton.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		scoreButton.setBackground(new Color(30, 144, 255));
		scoreButton.setBounds(247, 440, 100, 100);
		panel.add(scoreButton);
		
		RoundButton exitButton = new RoundButton("Play");
		exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitButton.setText("Exit");
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		exitButton.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		exitButton.setBackground(new Color(30, 144, 255));
		exitButton.setBounds(25, 440, 100, 100);
		panel.add(exitButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/quiz_logo2.png")));
		lblNewLabel_1.setBounds(92, 47, 410, 134);
		panel.add(lblNewLabel_1);
		
		JLabel lblSoYpu = new JLabel("So you wanna play a game ?");
		lblSoYpu.setForeground(new Color(255, 255, 255));
		lblSoYpu.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		lblSoYpu.setBounds(58, 236, 483, 50);
		panel.add(lblSoYpu);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/background_1.JPG")));
		lblNewLabel.setBounds(0, 0, 594, 571);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		defaultPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHowToPlay = new JLabel("How to play ?");
		lblHowToPlay.setForeground(new Color(255, 255, 255));
		lblHowToPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblHowToPlay.setBounds(31, 32, 234, 40);
		panel_1.add(lblHowToPlay);
		
		JTextArea txtrSomeRandomText = new JTextArea();
		txtrSomeRandomText.setRequestFocusEnabled(false);
		txtrSomeRandomText.setFocusable(false);
		txtrSomeRandomText.setBorder(BorderFactory.createCompoundBorder(new LineBorder(new Color(0, 0, 0)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtrSomeRandomText.setForeground(new Color(255, 255, 255));
		txtrSomeRandomText.setBackground(new Color(100, 149, 237));
		txtrSomeRandomText.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		txtrSomeRandomText.setEditable(false);
		txtrSomeRandomText.setText("1 - Enter your age by filling the input space correspanding and\r\n     make sure it is you actual age\r\n\r\n2 - Choose five interests in which you find yourself most adequat\r\n     to answer questions on\r\n\r\n3 - Start the game by clicking on the play button\r\n\r\n4 - You have 2 and a half minutes to complete 10 questions\r\n\r\n\t\tGood luck !");
		txtrSomeRandomText.setRows(10);
		txtrSomeRandomText.setBounds(28, 110, 530, 283);
		panel_1.add(txtrSomeRandomText);
		
		RoundButton acceptButton = new RoundButton("Play");
		acceptButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.next(defaultPane);
			}
		});
		acceptButton.setText("Accept");
		acceptButton.setForeground(Color.WHITE);
		acceptButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		acceptButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		acceptButton.setBackground(new Color(0, 128, 0));
		acceptButton.setBounds(458, 440, 100, 100);
		panel_1.add(acceptButton);
		
		RoundButton backButton = new RoundButton("Play");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.previous(defaultPane);
			}
		});
		backButton.setText("Back");
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		backButton.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		backButton.setBackground(new Color(30, 144, 255));
		backButton.setBounds(25, 440, 100, 100);
		panel_1.add(backButton);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(Main.class.getResource("/background_1.JPG")));
		label.setBounds(0, 0, 594, 571);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		defaultPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblInterests = new JLabel("Interests :");
		lblInterests.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblInterests.setBounds(339, 100, 137, 36);
		panel_2.add(lblInterests);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblAge.setBounds(40, 100, 80, 36);
		panel_2.add(lblAge);
		
		JLabel lblChooseYourAge = new JLabel("Enter your age and choose your interests");
		lblChooseYourAge.setForeground(Color.WHITE);
		lblChooseYourAge.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblChooseYourAge.setBounds(30, 30, 534, 43);
		panel_2.add(lblChooseYourAge);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(100, 149, 237));
		panel_4.setBounds(334, 150, 230, 240);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		//This array list is necessary for getting the choosen options
		interests = new ArrayList<JCheckBox>();
		
		JCheckBox chckbxSports = new JCheckBox("Sport");
		chckbxSports.setFocusable(false);
		chckbxSports.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choosingInterests(chckbxSports);
			}
		});
		chckbxSports.setBackground(new Color(100, 149, 237));
		chckbxSports.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		chckbxSports.setBounds(6, 10, 122, 23);
		panel_4.add(chckbxSports);
		interests.add(chckbxSports);
		
		JCheckBox chckbxHistory = new JCheckBox("History");
		chckbxHistory.setFocusable(false);
		chckbxHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choosingInterests(chckbxHistory);
			}
		});
		chckbxHistory.setBackground(new Color(100, 149, 237));
		chckbxHistory.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		chckbxHistory.setBounds(6, 38, 122, 23);
		panel_4.add(chckbxHistory);
		interests.add(chckbxHistory);
		
		JCheckBox chckbxGeography = new JCheckBox("Geography");
		chckbxGeography.setFocusable(false);
		chckbxGeography.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choosingInterests(chckbxGeography);
			}
		});
		chckbxGeography.setBackground(new Color(100, 149, 237));
		chckbxGeography.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		chckbxGeography.setBounds(6, 66, 122, 23);
		panel_4.add(chckbxGeography);
		interests.add(chckbxGeography);
		
		JCheckBox chckbxArt = new JCheckBox("Art");
		chckbxArt.setFocusable(false);
		chckbxArt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choosingInterests(chckbxArt);
			}
		});
		chckbxArt.setBackground(new Color(100, 149, 237));
		chckbxArt.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		chckbxArt.setBounds(6, 92, 122, 23);
		panel_4.add(chckbxArt);
		interests.add(chckbxArt);
		
		JCheckBox chckbxScience = new JCheckBox("Science");
		chckbxScience.setFocusable(false);
		chckbxScience.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choosingInterests(chckbxScience);
			}
		});
		chckbxScience.setBackground(new Color(100, 149, 237));
		chckbxScience.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		chckbxScience.setBounds(6, 118, 122, 23);
		panel_4.add(chckbxScience);
		interests.add(chckbxScience);
		
		JCheckBox chckbxTech = new JCheckBox("Technology");
		chckbxTech.setFocusable(false);
		chckbxTech.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choosingInterests(chckbxTech);
			}
		});
		chckbxTech.setBackground(new Color(100, 149, 237));
		chckbxTech.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		chckbxTech.setBounds(6, 146, 122, 23);
		panel_4.add(chckbxTech);
		interests.add(chckbxTech);
		
		JCheckBox chckbxCinema = new JCheckBox("Cinema");
		chckbxCinema.setFocusable(false);
		chckbxCinema.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choosingInterests(chckbxCinema);
			}
		});
		chckbxCinema.setBackground(new Color(100, 149, 237));
		chckbxCinema.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		chckbxCinema.setBounds(6, 174, 122, 23);
		panel_4.add(chckbxCinema);
		interests.add(chckbxCinema);
		
		JCheckBox chckbxNature = new JCheckBox("Nature");
		chckbxNature.setFocusable(false);
		chckbxNature.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choosingInterests(chckbxNature);
			}
		});
		chckbxNature.setBackground(new Color(100, 149, 237));
		chckbxNature.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		chckbxNature.setBounds(6, 202, 122, 23);
		panel_4.add(chckbxNature);
		interests.add(chckbxNature);		
		
		RoundButton roundButton = new RoundButton("Play");
		roundButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		roundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.previous(defaultPane);
			}
		});
		roundButton.setText("Back");
		roundButton.setForeground(Color.WHITE);
		roundButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		roundButton.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		roundButton.setBackground(new Color(30, 144, 255));
		roundButton.setBounds(25, 440, 100, 100);
		panel_2.add(roundButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(294, 135, 6, 300);
		panel_2.add(panel_3);
		
		JTextField ageText = new JTextField();
		ageText.setMargin(new Insets(2, 15, 2, 2));
		ageText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c))) {
					arg0.consume();
				}
			}
		});
		ageText.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		ageText.setBackground(new Color(100, 149, 236));
		ageText.setBounds(34, 147, 126, 36);
		panel_2.add(ageText);
				
		
		RoundButton rndbtnNext = new RoundButton("Play");
		rndbtnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rndbtnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(interestsCount==5 && Integer.parseInt(ageText.getText()) < 100 && Integer.parseInt(ageText.getText()) > 2) {
					QuestionsWindow qsWindow = new QuestionsWindow(w,gatherInterests(),Integer.parseInt(ageText.getText()));
					
					//for the next uses of the app
					ageText.setText("");
					interestsCount=0;
					
					w.setVisible(false);
					c1.next(defaultPane);
				}
				else if(interestsCount!=5){
					JOptionPane.showMessageDialog(null, "You need to fill "+ (5-interestsCount) + " more interests to continue !","Alert",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Make sure you have entered correct informations","Alert",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		rndbtnNext.setText("Next");
		rndbtnNext.setForeground(Color.WHITE);
		rndbtnNext.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		rndbtnNext.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		rndbtnNext.setBackground(new Color(0, 128, 0));
		rndbtnNext.setBounds(458, 440, 100, 100);
		panel_2.add(rndbtnNext);
		
		JLabel label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(Main.class.getResource("/background_1.JPG")));
		label_1.setBounds(0, 0, 594, 571);
		panel_2.add(label_1);
		
		JPanel panel_5 = new JPanel();
		defaultPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Main.class.getResource("/smileyFace.png")));
		lblNewLabel_3.setBounds(192, 53, 211, 225);
		panel_5.add(lblNewLabel_3);
		
		lblNbrOfCorrectAns = new JLabel("You answered 8 questions correctly");
		lblNbrOfCorrectAns.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblNbrOfCorrectAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblNbrOfCorrectAns.setBounds(38, 289, 519, 79);
		panel_5.add(lblNbrOfCorrectAns);
		
		lblCheerUp = new JLabel("which is huge !");
		lblCheerUp.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblCheerUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheerUp.setBounds(173, 355, 248, 52);
		panel_5.add(lblCheerUp);
		
		JPanel panel_6 = new JPanel();
		panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.next(defaultPane);
			}
		});
		panel_6.setBackground(new Color(0, 153, 51));
		panel_6.setBounds(181, 447, 232, 61);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblPlayAgain = new JLabel("Play Again");
		lblPlayAgain.setForeground(new Color(255, 255, 255));
		lblPlayAgain.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblPlayAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayAgain.setBounds(45, 11, 139, 39);
		panel_6.add(lblPlayAgain);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Main.class.getResource("/endBackground.png")));
		lblNewLabel_2.setBounds(0, 0, 594, 571);
		panel_5.add(lblNewLabel_2);
	}
	
	private void choosingInterests(JCheckBox obj) {
		if(interestsCount < 5) {
			if(obj.isSelected()) interestsCount--;
			else interestsCount++;
		}
		else if(obj.isSelected()) interestsCount--;
		else obj.setSelected(true);
	}
	
	private String[] gatherInterests() {
		String[] interestsResult = new String[10];
		byte j = 0;
		for(byte i=0;i<interests.size();i++) {
			if(interests.get(i).isSelected()) {
				interestsResult[j] = interests.get(i).getText();
				interests.get(i).setSelected(false); //for the next use of the game, the fields are emptied manually to avoid any other heavier solutions
				j++;
			}
		}
		return interestsResult;
	}
	
	public void DisplayResult(int nbrCorrectAns) {
		lblNbrOfCorrectAns.setText("You answered "+nbrCorrectAns+" questions correctly");
		String temp = (nbrCorrectAns>5)?"huge":"not bad";
		lblCheerUp.setText("Which is "+temp+" !");;
	}
}