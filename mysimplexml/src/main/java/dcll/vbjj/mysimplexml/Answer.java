package dcll.vbjj.mysimplexml;

public class Answer {
	private String text;
	private String fraction;
	private String feedBackText;
	private String tolerance = "-1";
	private String toleranceType;
	private String correctanswerformat;
	private String correctanswerlenght;

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

	// Getter attribute : TOLERANCE
	public String getTolerance() {
		return this.tolerance;
	}

	// Getter attribute : TOLERANCETYPE
	public String getToleranceType() {
		return this.toleranceType;
	}

	// Getter attribute : CORRECTANSWERFORMAT
	public String getCorrectanswerformat() {
		return this.correctanswerformat;
	}

	// Getter attribute : CORRECTANSWERLENGHT
	public String getCorrectanswerlenght() {
		return this.correctanswerlenght;
	}

}
