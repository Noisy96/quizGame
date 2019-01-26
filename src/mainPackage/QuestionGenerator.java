package mainPackage;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuestionGenerator {
	
	private String questionsList[];
	private String questionsMatrix[][];
	private String error[] = {"e","e","e","e","e","e","e","0"};
	private int age;
	
	public QuestionGenerator(int userAge){
		
		age = userAge;
		
		String data ="";
		try {
			try {
				data = new String(Files.readAllBytes(Paths.get(Main.class.getResource("/questions.txt").toURI())));
				
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		questionsList = data.split("\n");
		questionsMatrix = new String[questionsList.length][7];
		
		for(byte i=0;i<questionsList.length;i++) {
			questionsMatrix[i] = questionsList[i].split("-");
		}
	}
	
	private String ageNumberToCategory() {
		if(age >= 3 && age <= 10) return "A";
		else if(age >= 11 && age <= 20) return "B";
		else if(age >= 21 && age <= 30) return "C";
		else if(age >= 31) return "D";
		else return "E";
	}
	
	public String[] getQuestion(String subject) {
		for(byte i=0;i<questionsMatrix.length;i++) {
			if(questionsMatrix[i][1].equals(subject) && questionsMatrix[i][0].equals(ageNumberToCategory())) {
				questionsMatrix[i][0] += "done";
				return questionsMatrix[i];
			}
		}
		return error;
	}
}