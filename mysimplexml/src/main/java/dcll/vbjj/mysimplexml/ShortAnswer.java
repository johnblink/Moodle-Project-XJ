package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

/**
 * 
 * @author Ben
 *
 */
public class ShortAnswer extends Question {
/**
 * Attribute list of answers for tag.
 */
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();
/**
 * Attribute text format for tag.
 */
	private String format;
/**
 * Attribute image source for tag.
 */
	private String image;
/**
 * Attribute text defaultgrade for tag.
 */
	private String defaultgrade;
/**
 * Attribute text penalty for tag.
 */
	private String penalty;
/**
 * Attribute text hidden for tag.
 */
	private String hidden;
/**
 * Attribute text shuffleanswers for tag.
 */
	private String shuffleanswers;
/**
 * Attribute text usecase for tag.
 */
	private String usecase;
/**
 * 
 * @param name name of ShortAnswer
 * @param qt questionText of ShortAnswer
 * @param format format of ShortAnswer
 * @param image image of ShortAnswer
 * @param generalfeedback generalfeedback of ShortAnswer
 * @param defaultgrade defaultgrade of ShortAnswer
 * @param penalty penaly of ShortAnswer
 * @param hidden hidden of ShortAnswer
 * @param shuffleanswers shuffleanswers of ShortAnswer
 * @param usecase usecase of ShortAnswer
 */
	public ShortAnswer(String name, String qt, String format, String image,
			String generalfeedback, String defaultgrade, String penalty,
			String hidden, String shuffleanswers, String usecase) {
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
		this.usecase = usecase;
	}
/**
 * Method ajoutAnswer
 * @param a Answer
 */
	public void ajoutAnswer(Answer a) {
		listAnswer.add(a);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nAffichage ShortAnswer\n" + "==> " + name + "\n(image="
				+ image + " - generalfeedback=" + generalfeedback
				+ " - format=" + format + " - defaultgrade=" + defaultgrade
				+ " - penalty=" + penalty + " - hidden=" + hidden
				+ " - shuffleanswer=" + shuffleanswers + " - usecase="
				+ usecase + ")\n" + questionText + "\n" + listAnswer.toString();
	}

/**
 * Getter attribute : GETLISTANSWER.
 * @return listAnswer
 */
	public ArrayList<Answer> getListAnswer() {
		return listAnswer;
	}
/**
 * 	Getter attribute : FORMAT.
 * @return format
 */
	public String getFormat() {
		return format;
	}

/**
 * Getter attribute : IMAGE.
 * @return image
 */
	public String getImage() {
		return image;
	}

/**
 * Getter attribute : DEFAULTGRADE.
 * @return defaultgrade
 */
	public String getDefaultGrade() {
		return defaultgrade;
	}

/**
 * Getter attribute : PENALTY.
 * @return penalty
 */
	public String getPenalty() {
		return penalty;
	}

/**
 * Getter attribute : HIDDEN.
 * @return hidden
 */
	public String getHidden() {
		return hidden;
	}

/**
 * Getter attribute : SHUFFLEANSWERS.
 * @return shuffleanswers
 */
	public String getShuffleAnswers() {
		return shuffleanswers;
	}

/**
 * Getter attribute : USECASE.
 * @return usecase
 */
	public String getUseCase() {
		return usecase;
	}
}
