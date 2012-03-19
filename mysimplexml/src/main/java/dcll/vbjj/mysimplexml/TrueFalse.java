package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class TrueFalse extends Question {
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();
	private String format;
	private String image;
	private String defaultgrade;
	private String penalty;
	private String hidden;
	private String shuffleanswer;

	public TrueFalse(String n, String qt, String f, String image, String generalfeedback, String d, String p, String h, String s) {
		super();
		this.name = n;
		this.format = f;
		this.questionText = qt;
		this.defaultgrade = d;
		this.penalty = p;
		this.hidden = h;
		this.shuffleanswer = s;
		this.generalfeedback = generalfeedback;
		this.image = image;
	}
	
	public void ajoutAnswer(Answer a) {
		listAnswer.add(a);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nAffichage TrueFalse\n"+"==> "+name+"\n(image="+image+" - generalfeedback="+generalfeedback+" - format="+format+" - defaultgrade="+defaultgrade+" - penalty="+penalty+" - hidden="+hidden+" - shuffleanswer="+shuffleanswer+")\n"+questionText+"\n"+listAnswer.toString()+"\n";
	}
	// Getter attribute : GETLISTANSWER
	public ArrayList<Answer> getListAnswer() {
		return this.listAnswer;
	}
	// Getter attribute : FORMAT
	public String getFormat() {
		return this.format;
	}
	// Getter attribute : IMAGE
	public String getImage() {
		return this.image;
	}
	// Getter attribute : DEFAULTGRADE
	public String getDefaultGrade() {
		return this.defaultgrade;
	}
	// Getter attribute : PENALTY
	public String getPenalty() {
		return this.penalty;
	}
	// Getter attribute : HIDDEN
	public String getHidden() {
		return this.hidden;
	}
	// Getter attribute : SHUFFLEANSWERS
	public String getShuffleAnswers() {
		return shuffleanswer;
	}
}
