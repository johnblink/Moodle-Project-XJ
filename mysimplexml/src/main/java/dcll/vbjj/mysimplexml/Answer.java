package dcll.vbjj.mysimplexml;

public class Answer {
	private String text;
	private String fraction;
	private String feedBackText;
	private String tolerance = "-1";
	
	public Answer(String text, String fraction, String feedBackText) {
		this.text = text;
		this.fraction = fraction;
		this.feedBackText = feedBackText;
	}
	
	public void setTolerance(String tolerance) {
		this.tolerance = tolerance;
	}
	
	public String toString() {
		String res = "Answer :" + text + " - fraction=" + fraction + " - ";
		if (!tolerance.equals("-1"))
			res += ("tolerance=" + tolerance + " - ");
		return res + feedBackText + "\n";
	}
	
	// Getter attribute : TEXT
	public String getText() {
		return this.text;
	}
	
	// Getter attribute : FRACTION
	public String getFraction() {
		return this.fraction;
	}
	
	// Getter attribute : FEEDBACKTEXT
	public String getFeedbackText() {
		return this.feedBackText;
	}
}
