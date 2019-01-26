package mainPackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class QuestionsWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	//Shared label objects
	String question[];
	private JLabel TimeLabel,count,score,lblQuestion;
	private QuestionGenerator questionGenerator;
	private JButton choiceBtn1,choiceBtn2,choiceBtn3,choiceBtn4;
	Window motherObj;
	
	//Keeping count of questions
	private int questionsCounter=0;
	
	//The timer code
	private int seconds = 150;
	
	Timer countDown = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			if(seconds > 0) {
				seconds--;
				String temp = ((seconds%60)>=10)?"":"0";
				TimeLabel.setText("0"+String.valueOf(seconds/60)+":"+temp+String.valueOf(seconds%60));
			}
			else {
				motherObj.DisplayResult(Integer.parseInt(score.getText())/100);
				motherObj.setVisible(true);
				
				//to close the window we force the questions counter to reach max
				questionsCounter=10;
				chooseAnswer("e","e");				
			}
		}
	};

	public QuestionsWindow(Window obj, String userInterests[], int userAge){
		
		motherObj = obj;
		
		countDown.scheduleAtFixedRate(task, 1000, 1000);
		questionGenerator = new QuestionGenerator(userAge);
		question = questionGenerator.getQuestion(userInterests[questionsCounter]);
		
		setResizable(false);
		setTitle("Questions");
		setBounds(100, 100, 720, 520);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TimeLabel = new JLabel("02:30");
		TimeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		TimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TimeLabel.setBounds(282, 7, 154, 61);
		contentPane.add(TimeLabel);
		
		JLabel qtsCountLabel = new JLabel("Questions Count :");
		qtsCountLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		qtsCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		qtsCountLabel.setBounds(33, 39, 135, 26);
		contentPane.add(qtsCountLabel);
		
		count = new JLabel("01/10");
		count.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		count.setHorizontalAlignment(SwingConstants.CENTER);
		count.setHorizontalTextPosition(SwingConstants.CENTER);
		count.setBounds(40, 65, 114, 35);
		contentPane.add(count);
		
		JLabel scoreLabel = new JLabel("Score :");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		scoreLabel.setBounds(599, 39, 81, 26);
		contentPane.add(scoreLabel);
		
		score = new JLabel("0000");
		score.setHorizontalTextPosition(SwingConstants.CENTER);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		score.setBounds(588, 65, 92, 35);
		contentPane.add(score);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(65, 105, 225, 100));
		panel.setBounds(33, 225, 652, 233);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblQuestion = new JLabel();
		lblQuestion.setVerticalAlignment(SwingConstants.TOP);
		lblQuestion.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(30, 15, 612, 48);
		panel.add(lblQuestion);
		
		choiceBtn1 = new JButton();
		choiceBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseAnswer("1",userInterests[(questionsCounter+=1)%5]);
			}
		});
		choiceBtn1.setFocusable(false);
		choiceBtn1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		choiceBtn1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		choiceBtn1.setBounds(30, 80, 280, 55);
		panel.add(choiceBtn1);
		
		choiceBtn2 = new JButton();
		choiceBtn2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		choiceBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseAnswer("2",userInterests[(questionsCounter+=1)%5]);
			}
		});
		choiceBtn2.setFocusable(false);
		choiceBtn2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		choiceBtn2.setBounds(339, 80, 280, 55);
		panel.add(choiceBtn2);
		
		choiceBtn3 = new JButton();
		choiceBtn3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		choiceBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseAnswer("3",userInterests[(questionsCounter+=1)%5]);
			}
		});
		choiceBtn3.setFocusable(false);
		choiceBtn3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		choiceBtn3.setBounds(339, 156, 280, 55);
		panel.add(choiceBtn3);
		
		choiceBtn4 = new JButton();
		choiceBtn4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		choiceBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseAnswer("4",userInterests[(questionsCounter+=1)%5]);
			}
		});
		choiceBtn4.setFocusable(false);
		choiceBtn4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		choiceBtn4.setBounds(30, 156, 280, 55);
		panel.add(choiceBtn4);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/6.JPG")));
		lblNewLabel.setBounds(2, 0, 714, 491);
		contentPane.add(lblNewLabel);
		setVisible(true);
		
		setQuestionUp();
	}
	
	private void chooseAnswer(String choosenAnswerNumber, String nextInterstToFetch) {
		if(question[7].contains(choosenAnswerNumber)) {
			this.score.setText("0"+String.valueOf(Integer.valueOf(this.score.getText())+100));
		}
		String tmp = (questionsCounter==9) ? "" : "0";
		this.count.setText(tmp+(questionsCounter+1)+"/10");
		if(questionsCounter==10) {
			motherObj.DisplayResult(Integer.parseInt(score.getText())/100);
			motherObj.setVisible(true);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		question = questionGenerator.getQuestion(nextInterstToFetch);
		setQuestionUp();
	}
	
	private void setQuestionUp() {
		this.repaint();
		this.lblQuestion.setText(question[2]);
		this.choiceBtn1.setText("A.  "+question[3]);
		this.choiceBtn2.setText("B.  "+question[4]);
		this.choiceBtn3.setText("C.  "+question[5]);
		this.choiceBtn4.setText("D.  "+question[6]);
	}
}