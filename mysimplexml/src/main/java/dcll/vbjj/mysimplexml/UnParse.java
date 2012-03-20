package dcll.vbjj.mysimplexml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.jdom.Attribute;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class UnParse {
	// XML Trunk = quiz
	private static Element racine = new Element("quiz");
	// Create new Document JDOM based on new trunk
	private static Document document = new Document(racine);
	// Element Question Main Tag
	private Element question;
	// Iterator Question Number
	private int nbQuestion;

	// Constructor
	public UnParse() {
		this.nbQuestion = 1;
	}

	// Save file
	static void enregistre(String fichier) {
		try {
			// Classic format with getPrettyFormat()
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			// Serialization.
			sortie.output(document, new FileOutputStream(fichier));
		} catch (java.io.IOException e) {
		}
	}

	// Print File
	static void affiche() {
		try {
			// Classic Format getPrettyFormat()
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, System.out);
		} catch (java.io.IOException e) {
		}
	}

	// Function use for add simple tag (NOM with attribute) with text tag (VAR)
	private void ajouteBaliseSimpleAvecTexte(String nom, String attribute,
			String var) {
		Element balise = new Element(nom);
		Element text = new Element("text");
		if (!attribute.equals("")) {
			Attribute classe = new Attribute("format", attribute);
			balise.setAttribute(classe);
		}
		text.setText(var);
		balise.addContent(text);
		this.question.addContent(balise);
	}

	// Function use for IMAGE tag
	private void ajouteBaliseImage(String nom, String source) {
		Element image = new Element(nom);
		if (!source.equals("")) {
			image.setText(source);
		}
		this.question.addContent(image);
	}

	// Function use for FEEDBACK tag
	private void ajouteBaliseGeneralFeedback(String var) {
		Element generalfeedback = new Element("generalfeedback");
		Element text = new Element("text");

		text.setText(var);
		generalfeedback.addContent(text);
		this.question.addContent(generalfeedback);
	}

	// Function use for DEFAULTGRADE, PENALTY, HIDDEN, SHUFFLEANSWERS tags
	private void ajouteBaliseSimple(String nom, String var) {
		Element balise = new Element(nom);

		balise.setText(var);
		this.question.addContent(balise);
	}

	// Add Tag Answer
	private void ajouteBaliseAnswer(Answer a) {
		Element answer = new Element("answer");
		Element text = new Element("text");
		Element textfb = new Element("text");
		Element feedback = new Element("feedback");
		Attribute classe = new Attribute("fraction", a.getFraction());
		answer.setAttribute(classe);
		text.setText(a.getText());
		answer.addContent(text);
		textfb.setText(a.getFeedbackText());
		feedback.addContent(textfb);
		answer.addContent(feedback);
		this.question.addContent(answer);
	}

	// Add Tags in Answers List
	private void ajouteListeBalisesAnswer(ArrayList<Answer> l) {
		Iterator<Answer> i = l.iterator();

		while (i.hasNext())
			ajouteBaliseAnswer((Answer) i.next());
	}

	// Add Tags in SubQuestions List
	private void ajouteBaliseSubQuestion(ArrayList<SubQuestion> l) {
		Element subquestion, text, answer;

		Iterator<SubQuestion> i = l.iterator();
		while (i.hasNext()) {
			subquestion = new Element("subquestion");
			text = new Element("text");
			text.setText(i.next().getText());
			subquestion.addContent(text);
			answer = new Element("answer");
			text = new Element("text");
			text.setText(i.next().getAnswerText());
			answer.addContent(text);
			subquestion.addContent(answer);
			this.question.addContent(subquestion);
		}
	}

	// Add Tag Question Calculated
	private void ajouteBaliseQuestionCalculated(Calculated d) {
		System.out.println("Question calculated");/* TEST LIGN -> */
		Attribute classe = new Attribute("type", "calculated");
		this.question.setAttribute(classe);

		// ADD TAG NAME
		ajouteBaliseSimpleAvecTexte("name", "", d.getName());
		// ADD TAG QUESTION TEXT
		ajouteBaliseSimpleAvecTexte("questiontext", "moodle_auto_format",
				d.getQuestionText());
		// ADD TAG IMAGE
		ajouteBaliseImage("image", "");
		// ADD TAG GENERALFEEDBACK
		ajouteBaliseSimpleAvecTexte("generalfeedback", "",
				d.getGeneralFeedback());
		// ADD TAG DEFAULTGRADE
		ajouteBaliseSimple("defaultGrade", d.getDefaultGrade());
		// ADD TAG PENALTY
		ajouteBaliseSimple("penalty", d.getPenalty());
		// ADD TAG HIDDEN
		ajouteBaliseSimple("hidden", d.getHidden());
		// ADD TAG SHUFFLEANSWERS
		ajouteBaliseAnswer(d.getAnswer());
		// Put on trunk
		racine.addContent(this.question);
	}

	// Add Tag Question Essay
	private void ajouteBaliseQuestionEssay(Essay e) {
		System.out.println("Question essay");/* TEST LIGN -> */
		Attribute classe = new Attribute("type", "essay");
		this.question.setAttribute(classe);

		// ADD TAG NAME
		ajouteBaliseSimpleAvecTexte("name", "", e.getName());
		// ADD TAG QUESTION TEXT
		ajouteBaliseSimpleAvecTexte("questiontext", "moodle_auto_format",
				e.getQuestionText());
		// ADD TAG IMAGE
		ajouteBaliseImage("image", "");
		// ADD TAG GENERALFEEDBACK
		ajouteBaliseGeneralFeedback(e.getGeneralFeedback());
		// ADD TAG DEFAULTGRADE
		ajouteBaliseSimple("defaultGrade", e.getDefaultGrade());
		// ADD TAG PENALTY
		ajouteBaliseSimple("penalty", e.getPenalty());
		// ADD TAG HIDDEN
		ajouteBaliseSimple("hidden", e.getHidden());
		// ADD TAG SHUFFLEANSWERS
		ajouteBaliseSimple("shuffleanswers", e.getShuffleAnswers());
		// ADD TAG ANSWER
		ajouteBaliseAnswer(e.getAnswer());
		// Put on trunk
		racine.addContent(this.question);
	}

	// Add Tag Question Numerical
	private void ajouteBaliseQuestionNumerical(NumericalAnswer a) {
		System.out.println("Question numericalanswer");/* TEST LIGN -> */
		Attribute classe = new Attribute("type", "numerical");
		question.setAttribute(classe);

		// ADD TAG NAME
		ajouteBaliseSimpleAvecTexte("name", "", a.getName());
		// ADD TAG QUESTION TEXT
		ajouteBaliseSimpleAvecTexte("questiontext", "moodle_auto_format",
				a.getQuestionText());
		// ADD TAG IMAGE
		ajouteBaliseImage("image", "");
		// ADD TAG GENERALFEEDBACK
		ajouteBaliseGeneralFeedback(a.getGeneralFeedback());
		// ADD TAG DEFAULTGRADE
		ajouteBaliseSimple("defaultGrade", a.getDefaultGrade());
		// ADD TAG PENALTY
		ajouteBaliseSimple("penalty", a.getPenalty());
		// ADD TAG HIDDEN
		ajouteBaliseSimple("hidden", a.getHidden());
		// ADD TAG SHUFFLEANSWERS
		ajouteBaliseSimple("shuffleanswers", a.getShuffleAnswers());
		// ADD TAG ANSWER
		ajouteBaliseAnswer(a.getAnswer());
		// Put on trunk
		racine.addContent(this.question);
	}

	// Add Tag Question Matching
	private void ajouteBaliseQuestionMatching(Matching m) {
		System.out.println("Question matching");/* TEST LIGN -> */
		Attribute classe = new Attribute("type", "matching");
		question.setAttribute(classe);

		// ADD TAG NAME
		ajouteBaliseSimpleAvecTexte("name", "", m.getName());
		// ADD TAG QUESTION TEXT
		ajouteBaliseSimpleAvecTexte("questiontext", "moodle_auto_format",
				m.getQuestionText());
		// ADD TAG IMAGE
		ajouteBaliseImage("image", "");
		// ADD TAG GENERALFEEDBACK
		ajouteBaliseSimpleAvecTexte("generalfeedback", "",
				m.getGeneralFeedback());
		// ADD TAG DEFAULTGRADE
		ajouteBaliseSimple("defaultGrade", m.getDefaultGrade());
		// ADD TAG PENALTY
		ajouteBaliseSimple("penalty", m.getPenalty());
		// ADD TAG HIDDEN
		ajouteBaliseSimple("hidden", m.getHidden());
		// ADD TAG SHUFFLEANSWERS
		ajouteBaliseSimple("shuffleanswers", m.getShuffleAnswers());
		// ADD TAG SUBQUESTIONS
		ajouteBaliseSubQuestion(m.getListSubQuestion());
		// Put on trunk
		racine.addContent(this.question);
	}

	// Add Tag Question Multiple Choice
	private void ajouteBaliseQuestionMultipleChoice(MultipleChoice mc) {
		System.out.println("Question multichoice");/* TEST LIGN -> */
		Attribute classe = new Attribute("type", "multichoice");
		question.setAttribute(classe);

		// ADD TAG NAME
		ajouteBaliseSimpleAvecTexte("name", "", mc.getName());
		// ADD TAG QUESTION TEXT
		ajouteBaliseSimpleAvecTexte("questiontext", "html",
				mc.getQuestionText());
		// ADD TAG IMAGE
		ajouteBaliseImage("image", mc.getImage());
		// ADD TAG IMAGE
		ajouteBaliseImage("image_base64", mc.getImage_base64());
		// ADD TAG GENERALFEEDBACK
		ajouteBaliseSimpleAvecTexte("generalfeedback", "",
				mc.getGeneralFeedback());
		// ADD TAG DEFAULTGRADE
		ajouteBaliseSimple("defaultGrade", mc.getDefaultGrade());
		// ADD TAG PENALTY
		ajouteBaliseSimple("penalty", mc.getPenalty());
		// ADD TAG HIDDEN
		ajouteBaliseSimple("hidden", mc.getHidden());
		// ADD TAG SHUFFLEANSWERS
		ajouteBaliseSimple("shuffleanswers", mc.getShuffleAnswers1());
		// ADD TAG SINGLE
		ajouteBaliseSimple("single", mc.getSingle());
		// ADD TAG SHUFFLEANSWERS
		ajouteBaliseSimple("shuffleanswers2", mc.getShuffleAnswers1());
		// ADD TAG CORRECTFEEDBACK
		ajouteBaliseSimpleAvecTexte("correctfeedback", "",
				mc.getCorrectFeedback());
		// ADD TAG PARTIALLYCORRECTFEEDBACK
		ajouteBaliseSimpleAvecTexte("partiallycorrectfeedback", "",
				mc.getPartiallyCorrectFeedback());
		// ADD TAG INCORRECTFEEDBACK
		ajouteBaliseSimpleAvecTexte("incorrectfeedback", "",
				mc.getIncorrectFeedback());
		// ADD TAG SINGLE
		ajouteBaliseSimple("answernumbering", mc.getAnswerNumbering());
		// ADD TAGS ANSWER
		ajouteListeBalisesAnswer(mc.getListAnswer());
		// Put on trunk
		racine.addContent(this.question);
	}

	// Add Tag Question Short Answer
	private void ajouteBaliseQuestionShortAnswer(ShortAnswer sa) {
		// TEST LIGN ->
		System.out.println("Question shortanswer");
		Attribute classe = new Attribute("type", "shortanswer");
		question.setAttribute(classe);

		// ADD TAG NAME
		ajouteBaliseSimpleAvecTexte("name", "", sa.getName());
		// ADD TAG QUESTION TEXT
		ajouteBaliseSimpleAvecTexte("questiontext", "moodle_auto_format",
				sa.getQuestionText());
		// ADD TAG IMAGE
		ajouteBaliseImage("image", "");
		// ADD TAG GENERALFEEDBACK
		ajouteBaliseGeneralFeedback(sa.getGeneralFeedback());
		// ADD TAG DEFAULTGRADE
		ajouteBaliseSimple("defaultGrade", sa.getDefaultGrade());
		// ADD TAG PENALTY
		ajouteBaliseSimple("penalty", sa.getPenalty());
		// ADD TAG HIDDEN
		ajouteBaliseSimple("hidden", sa.getHidden());
		// ADD TAG SHUFFLEANSWERS
		ajouteBaliseSimple("shuffleanswers", sa.getShuffleAnswers());
		// ADD TAG USECASE
		ajouteBaliseSimple("usecase", sa.getUseCase());
		// ADD TAGS ANSWER
		ajouteListeBalisesAnswer(sa.getListAnswer());
		// Put on trunk
		racine.addContent(this.question);
	}

	// Add Tag Question True False
	private void ajouteBaliseQuestionTrueFalse(TrueFalse tf) {
		System.out.println("Question truefalse");/* TEST LIGN -> */
		Attribute classe = new Attribute("type", "truefalse");
		question.setAttribute(classe);

		// ADD TAG NAME
		ajouteBaliseSimpleAvecTexte("name", "", tf.getName());
		// ADD TAG QUESTION TEXT
		ajouteBaliseSimpleAvecTexte("questiontext", "moodle_auto_format",
				tf.getQuestionText());
		// ADD TAG IMAGE
		ajouteBaliseImage("image", "");
		// ADD TAG GENERALFEEDBACK
		ajouteBaliseGeneralFeedback(tf.getGeneralFeedback());
		// ADD TAG DEFAULTGRADE
		ajouteBaliseSimple("defaultGrade", tf.getDefaultGrade());
		// ADD TAG PENALTY
		ajouteBaliseSimple("penalty", tf.getPenalty());
		// ADD TAG HIDDEN
		ajouteBaliseSimple("hidden", tf.getHidden());
		// ADD TAG SHUFFLEANSWERS
		ajouteBaliseSimple("shuffleanswers", tf.getShuffleAnswers());
		// ADD TAGS ANSWER
		ajouteListeBalisesAnswer(tf.getListAnswer());
		// Put on trunk
		racine.addContent(this.question);
	}

	// Write A Question
	private void parcoursQuestions(Question q) {
		switch ((String) q.getClass().getName()) {
		case "dcll.vbjj.mysimplexml.Calculated":
			ajouteBaliseQuestionCalculated((Calculated) q);
			break;
		case "dcll.vbjj.mysimplexml.Essay":
			ajouteBaliseQuestionEssay((Essay) q);
			break;
		case "dcll.vbjj.mysimplexml.Matching":
			ajouteBaliseQuestionMatching((Matching) q);
			break;
		case "dcll.vbjj.mysimplexml.MultipleChoice":
			ajouteBaliseQuestionMultipleChoice((MultipleChoice) q);
			break;
		case "dcll.vbjj.mysimplexml.NumericalAnswer":
			ajouteBaliseQuestionNumerical((NumericalAnswer) q);
			break;
		case "dcll.vbjj.mysimplexml.ShortAnswer":
			ajouteBaliseQuestionShortAnswer((ShortAnswer) q);
			break;
		case "dcll.vbjj.mysimplexml.TrueFalse":
			ajouteBaliseQuestionTrueFalse((TrueFalse) q);
			break;
		default:
		}
	}

	public void run(ArrayList<Question> lq) {
		Comment comment;

		Iterator<Question> i = lq.iterator();
		while (i.hasNext()) {
			// Every iteration create a new tag question
			this.question = new Element("question");
			// Add number comment for each question
			comment = new Comment("question: " + nbQuestion++);
			racine.addContent(comment);

			parcoursQuestions((Question) i.next());
		}
		enregistre("src/main/java/xmlsample/quiz.xml");
	}
}
