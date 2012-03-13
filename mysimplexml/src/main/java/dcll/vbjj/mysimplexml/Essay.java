package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class Essay extends Question{
	private ArrayList<Answer> listAnswer = new ArrayList<Answer>();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return listAnswer.toString();
	}

}
