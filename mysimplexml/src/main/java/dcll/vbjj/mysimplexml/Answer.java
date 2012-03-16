package dcll.vbjj.mysimplexml;

public class Answer {
	private String text;
	private String fraction;
	private String feedBackText;
	
	public Answer(String text, String fraction, String feedBackText) {
		this.text = text;
		this.fraction = fraction;
		this.feedBackText = feedBackText;
	}

	public String toString() {
		return "Answer :"+text+" - "+fraction+" - "+feedBackText+"\n";
	}
}
