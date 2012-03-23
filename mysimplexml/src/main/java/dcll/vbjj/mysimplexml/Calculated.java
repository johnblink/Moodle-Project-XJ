package dcll.vbjj.mysimplexml;

import dcll.vbjj.mysimplexml.data.CalculatedData;
import dcll.vbjj.mysimplexml.data.DatasetDefinitions;

public class Calculated extends Question {
	private String defaultgrade;
	private String penalty;
	private String hidden;
	private String shuffleanswers;
	private Answer answer;
	private CalculatedData unit;
	private DatasetDefinitions dataDef;

	public Calculated() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "implements me!";
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

	// Getter attribute : ANSWER
	public Answer getAnswer() {
		return this.answer;
	}

	// Getter attribute : UNIT
	public CalculatedData getUnit() {
		return this.unit;
	}

	// Getter attribute : DATADEF
	public DatasetDefinitions getDataDef() {
		return this.dataDef;
	}

}
