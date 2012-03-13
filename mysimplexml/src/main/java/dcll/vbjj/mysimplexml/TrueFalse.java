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
	
	public void affiche() {
		System.out.println("Affichage TrueFalse");
		Iterator<Answer> i = listAnswer.iterator();
		while(i.hasNext()) {
			i.next().affiche();
		}
	}
}
