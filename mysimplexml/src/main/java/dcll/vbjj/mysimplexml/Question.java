package dcll.vbjj.mysimplexml;

public abstract class Question {
	protected String name;
	protected String questionText;
	protected String generalfeedback;

	public abstract String toString();

	// Getter attribute : NAME
	public String getName() {
		return this.name;
	}

	// Getter attribute : QUESTIONTEXT
	public String getQuestionText() {
		return this.questionText;
	}

	// Getter attribute : GENERALFEEDBACK
	public String getGeneralFeedback() {
		return this.generalfeedback;
	}
}
