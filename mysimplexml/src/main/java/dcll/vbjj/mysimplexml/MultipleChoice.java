package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class MultipleChoice extends Question {
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();
	private String format;
	private String image;
	private String image_base64;
	private String defaultgrade;
	private String penalty;
	private String hidden;
	private String[] shuffleanswers = new String[2];
	private String single;
	private String correctfeedback;
	private String partiallycorrectfeedback;
	private String incorrectfeedback;
	private String answernumbering;
	
	public MultipleChoice(String name, String qt, String format, String image, String image_base64, String generalfeedback, String defaultgrade, 
			String penalty, String hidden, String shuffleanswers0, String shuffleanswers1, String single, String correctfeedback,
			String partiallycorrectfeedback, String incorrectfeedback, String answernumbering) {
		this.questionText = qt;
		this.name = name;
		this.format = format;
		this.image = image;
		this.image_base64 = image_base64;
		this.generalfeedback = generalfeedback;
		this.defaultgrade = defaultgrade;
		this.penalty = penalty;
		this.hidden = hidden;
		this.shuffleanswers[0] = shuffleanswers0;
		this.shuffleanswers[1] = shuffleanswers1;
		this.single = single;
		this.correctfeedback = correctfeedback;
		this.partiallycorrectfeedback = partiallycorrectfeedback;
		this.incorrectfeedback = incorrectfeedback;
		this.answernumbering = answernumbering;
	}
	
	public void ajoutAnswer(Answer a) {
		listAnswer.add(a);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nAffichage MultipleChoice\n"+"==> "+name+"\n(image="+image+" - image_base64="+" - generalfeedback="+generalfeedback+" - format="+format+" - defaultgrade="+defaultgrade+" - penalty="+penalty+" - hidden="+hidden+" - shuffleanswer="+shuffleanswers+")\n"+questionText+"\n"+listAnswer.toString();
	}
	// Getter attribute : getListAnswer
	public ArrayList<Answer> getListAnswer() {
		return this.listAnswer;
	}
	// Getter attribute : format
	public String getFormat() {
		return this.format;
	}
	// Getter attribute : image
	public String getImage() {
		return this.image;
	}
	// Getter attribute : getImage_base64
	public String getImage_base64() {
		return this.image_base64;
	}
	// Getter attribute : defaultgrade
	public String getDefaultGrade() {
		return this.defaultgrade;
	}
	// Getter attribute : penalty
	public String getPenalty() {
		return this.penalty;
	}
	// Getter attribute : hidden
	public String getHidden() {
		return this.hidden;
	}
	// Getter attribute : shuffleanswers
	public String[] getShuffleAnswers() {
		return this.shuffleanswers;
	}
	// Getter attribute : single
	public String getSingle() {
		return this.single;
	}
	// Getter attribute : correctfeedback
	public String getCorrectFeedback() {
		return this.correctfeedback;
	}
	// Getter attribute : partiallycorrectfeedback
	public String getPartiallyCorrectFeedback() {
		return this.partiallycorrectfeedback;
	}
	// Getter attribute : incorrectfeedback
	public String getIncorrectFeedback() {
		return this.incorrectfeedback;
	}
	// Getter attribute : answernumbering
	public String getAnswerNumbering() {
		return this.answernumbering;
	}
}
