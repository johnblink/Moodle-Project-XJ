package dcll.vbjj.mysimplexml;

public class NumericalAnswer extends Question {
	/**
	 * answer for tag.
	 */
	private Answer answer;
	/**
	 * Attribute class : format for tag.
	 */
	private String format;
	/**
	 * Attribute class : image for tag.
	 */
	private String image;
	/**
	 * Attribute class : defaultgrade for tag.
	 */
	private String defaultgrade;
	/**
	 * Attribute class : penalty for tag.
	 */
	private String penalty;
	/**
	 * Attribute class : hidden for tag.
	 */
	private String hidden;
	/**
	 * Attribute class : shuffleanswers for tag.
	 */
	private String shuffleanswers;

	/**
	 * Constructor.
	 * @param name
	 * @param qt
	 * @param format
	 * @param image
	 * @param generalfeedback
	 * @param defaultgrade
	 * @param penalty
	 * @param hidden
	 * @param shuffleanswers
	 * @param answer
	 */
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

	/**
	 * Getter attribute : ANSWER.
	 * @return
	 */
	public Answer getAnswer() {
		return this.answer;
	}

	/**
	 * Getter attribute : FORMAT.
	 * @return
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * Getter attribute : IMAGE.
	 * @return
	 */
	public String getImage() {
		return this.image;
	}

	/**
	 * Getter attribute : DEFAULTGRADE.
	 * @return
	 */
	public String getDefaultGrade() {
		return this.defaultgrade;
	}

	/**
	 * Getter attribute : PENALTY.
	 * @return
	 */
	public String getPenalty() {
		return this.penalty;
	}

	/**
	 * Getter attribute : HIDDEN.
	 * @return
	 */
	public String getHidden() {
		return this.hidden;
	}

	/**
	 * Getter attribute : SHUFFLEANSWERS.
	 * @return
	 */
	public String getShuffleAnswers() {
		return this.shuffleanswers;
	}

}
