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

	public MultipleChoice(String name, String qt, String format, String image,
			String image_base64, String generalfeedback, String defaultgrade,
			String penalty, String hidden, String shuffleanswers0,
			String shuffleanswers1, String single, String correctfeedback,
			String partiallycorrectfeedback, String incorrectfeedback,
			String answernumbering) {
		super();
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
		return "\nAffichage MultipleChoice\n" + "==> " + name + "\n(image="
				+ image + " - image_base64=" + " - generalfeedback="
				+ generalfeedback + " - format=" + format + " - defaultgrade="
				+ defaultgrade + " - penalty=" + penalty + " - hidden="
				+ hidden + " - shuffleanswer=" + shuffleanswers + ")\n"
				+ questionText + "\n" + listAnswer.toString();
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

	// Getter attribute : GETIMAGE_BASE64
	public String getImage_base64() {
		return this.image_base64;
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

	// Getter attribute : SHUFFLEANSWERS1
	public String getShuffleAnswers1() {
		return this.shuffleanswers[0];
	}

	// Getter attribute : SHUFFLEANSWER2
	public String getShuffleAnswers2() {
		return this.shuffleanswers[1];
	}

	// Getter attribute : SINGLE
	public String getSingle() {
		return this.single;
	}

	// Getter attribute : CORRECTFEEDBACK
	public String getCorrectFeedback() {
		return this.correctfeedback;
	}

	// Getter attribute : PARTIALLYCORRECTFEEDBACK
	public String getPartiallyCorrectFeedback() {
		return this.partiallycorrectfeedback;
	}

	// Getter attribute : FEEDBACK
	public String getIncorrectFeedback() {
		return this.incorrectfeedback;
	}

	// Getter attribute : ANSWERNUMBERING
	public String getAnswerNumbering() {
		return this.answernumbering;
	}
}
