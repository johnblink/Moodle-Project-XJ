package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class ShortAnswer extends Question {
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();
	private String format;
	private String image;
	private String defaultgrade;
	private String penalty;
	private String hidden;
	private String shuffleanswers;
	private String usecase;

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

	// Getter attribute : GETLISTANSWER
	public ArrayList<Answer> getListAnswer() {
		return listAnswer;
	}

	// Getter attribute : FORMAT
	public String getFormat() {
		return format;
	}

	// Getter attribute : IMAGE
	public String getImage() {
		return image;
	}

	// Getter attribute : DEFAULTGRADE
	public String getDefaultGrade() {
		return defaultgrade;
	}

	// Getter attribute : PENALTY
	public String getPenalty() {
		return penalty;
	}

	// Getter attribute : HIDDEN
	public String getHidden() {
		return hidden;
	}

	// Getter attribute : SHUFFLEANSWERS
	public String getShuffleAnswers() {
		return shuffleanswers;
	}

	// Getter attribute : USECASE
	public String getUseCase() {
		return usecase;
	}
}
