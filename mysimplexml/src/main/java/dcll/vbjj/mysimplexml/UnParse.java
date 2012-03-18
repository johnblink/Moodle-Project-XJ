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
	      //Classic format with getPrettyFormat()
	      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	      //Serialization.
	      sortie.output(document, new FileOutputStream(fichier));
	   } catch (java.io.IOException e){}
	}
	
	// Print File
	static void affiche()
	{
	   try {
	      // Classic Format getPrettyFormat()
	      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	      sortie.output(document, System.out);
	   } catch (java.io.IOException e){}
	}
	// Function use for NAME tag
	private void ajouteBaliseName (String var) {
		Element name = new Element("name");
		Element text = new Element("text");
		
		text.setText(var);
		name.addContent(text);
		this.question.addContent(name);
	}
	// Function use for QUESTIONTEXT tag
	private void ajouteBaliseQuestionText(String var) {
		Element questiontext = new Element("questiontext");
		Element text = new Element("text");
		Attribute classe = new Attribute("format","moodle_auto_format");
		
		questiontext.setAttribute(classe);
		text.setText(var);
		questiontext.addContent(text);
		this.question.addContent(questiontext);
	}
	// Function use for IMAGE tag
	private void ajouteBaliseImage() {
		Element image = new Element("image");
		
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
	private void ajouteBaliseSimpleTexte(String nom, String var) {
		Element defaultgrade = new Element(nom);
		
		defaultgrade.setText(var);
		this.question.addContent(defaultgrade);
	}	
	
	private void ajouteBaliseAnswer(Answer a) {
		Element answer = new Element("answer");
		Element text = new Element("text");
		Element textfb = new Element("text");
		Element feedback =  new Element("feedback");
		Attribute classe = new Attribute("fraction",a.getFraction());
		
		answer.setAttribute(classe);
		text.setText(a.getText());
		answer.addContent(text);
		textfb.setText(a.getFeedbackText());
		feedback.addContent(textfb);
		answer.addContent(feedback);
		this.question.addContent(answer);
	}
	
	private void ajouteListeBalisesAnswer(ArrayList<Answer> l) {
		Iterator<Answer> i = l.iterator();
		
		while(i.hasNext())
			ajouteBaliseAnswer((Answer)i.next());
	}
	
	private void ajouteBaliseQuestionEssay(Essay e) {
		System.out.println("Question essay");								/* TEST LIGN -> */
		Attribute classe = new Attribute("type","essay");
		this.question.setAttribute(classe);
		
		ajouteBaliseName(e.getName());										/* ADD BALISE NAME */
		ajouteBaliseQuestionText(e.getQuestionText());						/* ADD BALISE QUESTION TEXT */
		ajouteBaliseImage();												/* ADD BALISE IMAGE */
		ajouteBaliseGeneralFeedback(e.getGeneralFeedback());				/* ADD BALISE GENERALFEEDBACK */
		ajouteBaliseSimpleTexte("defaultGrade",e.getDefaultGrade());		/* ADD BALISE DEFAULTGRADE */
		ajouteBaliseSimpleTexte("penalty",e.getPenalty());					/* ADD BALISE PENALTY */
		ajouteBaliseSimpleTexte("hidden",e.getHidden());					/* ADD BALISE HIDDEN */
		ajouteBaliseSimpleTexte("shuffleanswers",e.getShuffleAnswers());	/* ADD BALISE SHUFFLEANSWERS */
		ajouteBaliseAnswer(e.getAnswer());									/* ADD BALISE ANSWER */
		// Put on trunk
		racine.addContent(this.question);
	}
	
	private void ajouteBaliseQuestionNumerical (NumericalAnswer a) {
		System.out.println("Question numericalanswer");						/* TEST LIGN -> */
		Attribute classe = new Attribute("type","numerical");
		question.setAttribute(classe);
		
		ajouteBaliseName(a.getName());										/* ADD BALISE NAME */
		ajouteBaliseQuestionText(a.getQuestionText());						/* ADD BALISE QUESTION TEXT */
		ajouteBaliseImage();												/* ADD BALISE IMAGE */
		ajouteBaliseGeneralFeedback(a.getGeneralFeedback());				/* ADD BALISE GENERALFEEDBACK */
		ajouteBaliseSimpleTexte("defaultGrade", a.getDefaultGrade());		/* ADD BALISE DEFAULTGRADE */
		ajouteBaliseSimpleTexte("penalty", a.getPenalty());					/* ADD BALISE PENALTY */
		ajouteBaliseSimpleTexte("hidden", a.getHidden());					/* ADD BALISE HIDDEN */
		ajouteBaliseSimpleTexte("shuffleanswers", a.getShuffleAnswers());	/* ADD BALISE SHUFFLEANSWERS */
		ajouteBaliseAnswer(a.getAnswer());									/* ADD BALISE ANSWER */
		// Put on trunk
		racine.addContent(this.question);
	}
	
	private void ajouteBaliseQuestionShortAnswer(ShortAnswer sa) {

		System.out.println("Question shortanswer");							/* TEST LIGN -> */
		Attribute classe = new Attribute("type","shortanswer");
		question.setAttribute(classe);
		
		ajouteBaliseName(sa.getName());										/* ADD BALISE NAME */
		ajouteBaliseQuestionText(sa.getQuestionText());						/* ADD BALISE QUESTION TEXT */
		ajouteBaliseImage();												/* ADD BALISE IMAGE */
		ajouteBaliseGeneralFeedback(sa.getGeneralFeedback());				/* ADD BALISE GENERALFEEDBACK */
		ajouteBaliseSimpleTexte("defaultGrade", sa.getDefaultGrade());		/* ADD BALISE DEFAULTGRADE */
		ajouteBaliseSimpleTexte("penalty", sa.getPenalty());				/* ADD BALISE PENALTY */
		ajouteBaliseSimpleTexte("hidden", sa.getHidden());					/* ADD BALISE HIDDEN */
		ajouteBaliseSimpleTexte("shuffleanswers", sa.getShuffleAnswers());	/* ADD BALISE SHUFFLEANSWERS */
		ajouteBaliseSimpleTexte("usecase", sa.getUseCase());				/* ADD BALISE USECASE */
		ajouteListeBalisesAnswer(sa.getListAnswer());						/* ADD BALISE ANSWER */
		// Put on trunk
		racine.addContent(this.question);
	}
	
	private void ajouteBaliseQuestionTrueFalse(TrueFalse tf) {
		System.out.println("Question truefalse");							/* TEST LIGN -> */
		Attribute classe = new Attribute("type","truefalse");
		question.setAttribute(classe);
		
		ajouteBaliseName(tf.getName());										/* ADD BALISE NAME */
		ajouteBaliseQuestionText(tf.getQuestionText());						/* ADD BALISE QUESTION TEXT */
		ajouteBaliseImage();												/* ADD BALISE IMAGE */
		ajouteBaliseGeneralFeedback(tf.getGeneralFeedback());				/* ADD BALISE GENERALFEEDBACK */
		ajouteBaliseSimpleTexte("defaultGrade", tf.getDefaultGrade());		/* ADD BALISE DEFAULTGRADE */
		ajouteBaliseSimpleTexte("penalty", tf.getPenalty());				/* ADD BALISE PENALTY */
		ajouteBaliseSimpleTexte("hidden", tf.getHidden());					/* ADD BALISE HIDDEN */
		ajouteBaliseSimpleTexte("shuffleanswers", tf.getShuffleAnswers());	/* ADD BALISE SHUFFLEANSWERS */
		ajouteListeBalisesAnswer(tf.getListAnswer());						/* ADD BALISE ANSWER */
		// Put on trunk
		racine.addContent(this.question);
	}
	// Write A Question
	private void parcoursQuestions(Question q) {
		switch((String)q.getClass().getName()){
		case "dcll.vbjj.mysimplexml.Calculated":
			/* TEST LIGN -> */System.out.println("Question calculated");
			break;
		case "dcll.vbjj.mysimplexml.Essay":
			ajouteBaliseQuestionEssay((Essay)q);
			break;
		case "dcll.vbjj.mysimplexml.Matching":
			/* TEST LIGN -> */System.out.println("Question matching");
			break;
		case "dcll.vbjj.mysimplexml.MultipleChoice":
			/* TEST LIGN -> */System.out.println("Question multiplechoice");
			break;
		case "dcll.vbjj.mysimplexml.NumericalAnswer":
			ajouteBaliseQuestionNumerical((NumericalAnswer)q);
			break;
		case "dcll.vbjj.mysimplexml.ShortAnswer":
			ajouteBaliseQuestionShortAnswer((ShortAnswer)q);
			break;
		case "dcll.vbjj.mysimplexml.TrueFalse":
			ajouteBaliseQuestionTrueFalse((TrueFalse)q);
			break;
		default:
		}
	}
	
	public void run (ArrayList<Question> lq){
		Comment comment;
		
		Iterator<Question> i = lq.iterator();
		
		while(i.hasNext()) {
			// Every iteration create a new tag question
			this.question = new Element("question");
			// Add number comment for each question
			comment = new Comment("question: "+nbQuestion++);
			racine.addContent(comment);
			
			parcoursQuestions((Question)i.next());
		}
		
		enregistre("src/main/java/xmlsample/quiz.xml");
	}
}
