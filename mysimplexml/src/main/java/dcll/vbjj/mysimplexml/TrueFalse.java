package dcll.vbjj.mysimplexml;

import java.util.ArrayList;
/**
 * 
 * @author Ben
 *
 */
public class TrueFalse extends Question {
/**
 * Attribute Class listAnswer for stock the answer of the object tag.
 */
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();
/**
 * Attribute Class format for the tag.
 */
	private String format;
/**
 * Attribute Class image for the tag.
 */
	private String image;
/**
 * Attribute Class defaultgrade for the tag.
 */
	private String defaultgrade;
/**
 * Attribute Class penalty for the tag.
 */
	private String penalty;
/**
 * Attribute Class hidden for the tag.
 */
	private String hidden;
/**
 * Attribute Class shuffleanswer for the tag.
 */
	private String shuffleanswer;
/**
 * Constructor.
 * @param n name for the TrueFalse Tag
 * @param qt questionText for the TrueFalse Tag
 * @param f format for the TrueFalse Tag
 * @param image image for the TrueFalse Tag
 * @param generalfeedback generalfeedback for the TrueFalse Tag
 * @param d defaultgrade for the TrueFalse Tag
 * @param p penalty for the TrueFalse Tag
 * @param h hidden for the TrueFalse Tag
 * @param s shuffleanswer for the TrueFalse Tag
 */
	public TrueFalse(String n, String qt, String f, String image,
			String generalfeedback, String d, String p, String h, String s) {
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
/**
 * Method ajoutAnswer for this object Tag.
 * @param a Answer
 */
	public void ajoutAnswer(Answer a) {
		listAnswer.add(a);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nAffichage TrueFalse\n" + "==> " + name + "\n(image=" + image
				+ " - generalfeedback=" + generalfeedback + " - format="
				+ format + " - defaultgrade=" + defaultgrade + " - penalty="
				+ penalty + " - hidden=" + hidden + " - shuffleanswer="
				+ shuffleanswer + ")\n" + questionText + "\n"
				+ listAnswer.toString() + "\n";
	}

/**
 * Getter attribute : GETLISTANSWER.
 * @return listAnswer
 */
	public ArrayList<Answer> getListAnswer() {
		return this.listAnswer;
	}

/**
 * Getter attribute : FORMAT.
 * @return format
 */
	public String getFormat() {
		return this.format;
	}

/**
 * Getter attribute : IMAGE.
 * @return image
 */
	public String getImage() {
		return this.image;
	}

/**
 * Getter attribute : DEFAULTGRADE.
 * @return defaultgrade
 */
	public String getDefaultGrade() {
		return this.defaultgrade;
	}

/**
 * Getter attribute : PENALTY.
 * @return penalty
 */
	public String getPenalty() {
		return this.penalty;
	}

/**
 * Getter attribute : HIDDEN.
 * @return hidden
 */
	public String getHidden() {
		return this.hidden;
	}

/**
 * Getter attribute : SHUFFLEANSWERS.
 * @return shuffleanswers
 */
	public String getShuffleAnswers() {
		return shuffleanswer;
	}
}
