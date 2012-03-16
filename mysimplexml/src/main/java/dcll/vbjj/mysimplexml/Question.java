package dcll.vbjj.mysimplexml;

public abstract class Question {
	protected String name;
	protected String questionText;
	protected String generalfeedback;
	public abstract String toString();
	
	// Getter attribute : name
	public String getName(){
		return this.name;
	}
	
	// Getter attribute : questionText
	public String getQuestionText(){
		return this.questionText;
	}
	
	// Getter attribute : generalfeedback
	public String getGeneralFeedback(){
		return this.generalfeedback;
	}
}
