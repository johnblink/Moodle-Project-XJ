package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

/**
 * Main class.
 * @author Jer
 */
public final class App {
	/**
	 * Constructor.
	 */
	private App() {

	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// Parser creation
		Parse test = new Parse();
		test.xml2Java("src/main/java/xmlsample/Test.xml");
		test.affiche();
		ArrayList<Question> l = test.getQuestions();
		System.out.println(l.size());

		// Unparser creation
		UnParse unparse = new UnParse();
		unparse.run(l);
	}
}
