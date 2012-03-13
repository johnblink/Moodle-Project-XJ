package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class ShortAnswer extends Question{
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();

	public void ajoutAnswer(Answer a) {
		listAnswer.add(a);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Affichage ShortAnswer\n"+listAnswer.toString()+"\n";
	}


}
