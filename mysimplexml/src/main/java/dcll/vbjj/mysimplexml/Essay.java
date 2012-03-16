package dcll.vbjj.mysimplexml;

public class Essay extends Question{
	private Answer answer;
	private String questionText;
	private String format;
	private String image;
	private String generalfeedback;
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
}
