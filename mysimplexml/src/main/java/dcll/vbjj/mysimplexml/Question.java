package dcll.vbjj.mysimplexml;

/**
 * 
 * @author Ben
 *
 */
public abstract class Question {
/**
 * Attribute text name for tag.
 */
	protected String name;
/**
 * Attribute text questionText for tag.
 */
	protected String questionText;
/**
 * Attribute text generalfeedback for tag.
 */
	protected String generalfeedback;
/**
 * Method to see arguments of class.
 */
	public abstract String toString();

/**
 *  Getter attribute : NAME.
 * @return name
 */
	public String getName() {
		return this.name;
	}

/**
 * Getter attribute : QUESTIONTEXT.
 * @return questionText
 */
	public String getQuestionText() {
		return this.questionText;
	}

/**
 * Getter attribute : GENERALFEEDBACK.
 * @return generalfeedback
 */
	public String getGeneralFeedback() {
		return this.generalfeedback;
	}
}
