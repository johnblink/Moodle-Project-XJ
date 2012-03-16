package dcll.vbjj.mysimplexml;

public class Answer {
	private String text;
	private int fraction;
	private String feedBackText;
	
	public Answer(String text) {
		this.text = text;
	}

	public void setFraction(int fraction) {
		this.fraction = fraction;
	}

	public void setFeedBackText(String feedBackText) {
		this.feedBackText = feedBackText;
	}
	
	public String toString() {
		return "Answer :"+text+" - "+fraction+" - "+feedBackText+"\n";
	}
}
