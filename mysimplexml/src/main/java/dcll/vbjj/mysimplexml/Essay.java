package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class Essay extends Question{
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();
	private String questionText;
	
	public Essay(String qt) {
		questionText = qt;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Affichage Essay\n"+listAnswer.toString()+"\n"+questionText+"\n";
	}
	
	public void ajoutAnswer(Answer a) {
		listAnswer.add(a);
	}

}
