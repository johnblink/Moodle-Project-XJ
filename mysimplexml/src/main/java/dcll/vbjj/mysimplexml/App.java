package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

/**
 * Classe principale.
 * @author Jer
 */
public final class App {
	/**
	 * Constructeur.
	 */
	private App() {

	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// Creation du parser
		Parse test = new Parse();
		test.xml2Java("src/main/java/xmlsample/Test.xml");
		test.affiche();
		ArrayList<Question> l = test.getQuestions();
		System.out.println(l.size());

		// Creation de l'objet permettant l'enregistrement des questions dans le
		// xml
		UnParse unparse = new UnParse();
		unparse.run(l);
	}
}
