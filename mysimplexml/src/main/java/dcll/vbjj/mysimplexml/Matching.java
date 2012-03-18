package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class Matching extends Question{
	private ArrayList<SubQuestion> listSubQuestion = new ArrayList<SubQuestion>();
	
	public Matching() {
		super();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return listSubQuestion.toString();
	}

}
