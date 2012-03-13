package dcll.vbjj.mysimplexml;

import java.util.ArrayList;
import java.util.Iterator;

public class TrueFalse extends Question {
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();

	public TrueFalse() {
	}
	
	public void ajoutAnswer(Answer a) {
		listAnswer.add(a);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Affichage TrueFalse\n"+listAnswer.toString()+"\n";
	}
}
