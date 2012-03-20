package dcll.vbjj.mysimplexml;

public class NumericalAnswer extends Question {
	private Answer answer;
	private String format;
	private String image;
	private String defaultgrade;
	private String penalty;
	private String hidden;
	private String shuffleanswers;

	public NumericalAnswer(String name, String qt, String format, String image,
			String generalfeedback, String defaultgrade, String penalty,
			String hidden, String shuffleanswers, Answer answer) {
		super();
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
		return "\nAffichage NumericalAnswer\n" + "==> " + name + "\n(image="
				+ image + " - generalfeedback=" + generalfeedback
				+ " - format=" + format + " - defaultgrade=" + defaultgrade
				+ " - penalty=" + penalty + " - hidden=" + hidden
				+ " - shuffleanswer=" + shuffleanswers + ")\n" + questionText
				+ "\n" + answer.toString();
	}

	// Getter attribute : ANSWER
	public Answer getAnswer() {
		return this.answer;
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
		return this.shuffleanswers;
	}

}
