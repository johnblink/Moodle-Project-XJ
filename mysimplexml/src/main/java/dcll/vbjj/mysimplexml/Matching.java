package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class Matching extends Question {
	private ArrayList<SubQuestion> listSubQuestion = new ArrayList<SubQuestion>();
	private String defaultgrade;
	private String penalty;
	private String hidden;
	private String shuffleanswers;

	public Matching() {
		super();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return listSubQuestion.toString();
	}

	// Getter attribute : LISTSUBQUESTION
	public ArrayList<SubQuestion> getListSubQuestion() {
		return this.listSubQuestion;
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
