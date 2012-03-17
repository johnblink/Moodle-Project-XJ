package dcll.vbjj.mysimplexml;

public class Essay extends Question{
	private Answer answer;
	private String format;
	private String image;
	private String defaultgrade;
	private String penalty;
	private String hidden;
	private String shuffleanswers;
	
	public Essay(String name, String qt, String format, String image, String generalfeedback, String defaultgrade, String penalty, String hidden, String shuffleanswers, Answer answer) {
		this.questionText = qt;
		this.name = name;
		this.format = format;
		this.image = image;
		this.generalfeedback = generalfeedback;
		this.defaultgrade = defaultgrade;
		this.penalty = penalty;
		this.hidden = hidden;
		this.shuffleanswers = shuffleanswers;
		this.answer = answer;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nAffichage Essay\n"+"==> "+name+"\n(image="+image+" - generalfeedback="+generalfeedback+" - format="+format+" - defaultgrade="+defaultgrade+" - penalty="+penalty+" - hidden="+hidden+" - shuffleanswer="+shuffleanswers+")\n"+questionText+"\n"+answer.toString();
	}
	
	// Getter attribute : format
	public String getFormat() {
		return this.format;
	}
	// Getter attribute : image
	public String getImage() {
		return this.image;
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
	public String getShuffleAnswers() {
		return this.shuffleanswers;
	}
	// Getter attribute : answer
	public Answer getAnswer() {
		return this.answer;
	}
}
