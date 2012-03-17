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
	// Element Question Main Balise
	private Element question;
	// Iterator Question Number
	private int nbQuestion;
	
	
	// Constructor
		public UnParse() {
		this.nbQuestion = 1;
	}

	// Save file
	static void enregistre(String fichier)
	{
	   try
	   {
	      //Classic format with getPrettyFormat()
	      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	      //Serialization.
	      sortie.output(document, new FileOutputStream(fichier));
	   }
	   catch (java.io.IOException e){}
	}
	
	// Print File
	static void affiche()
	{
	   try
	   {
	      // Classic Format getPrettyFormat()
	      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	      sortie.output(document, System.out);
	   }
	   catch (java.io.IOException e){}
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
	
	// Write A Question
	private void parcoursQuestions(Question q) {
		Attribute classe;
		
		switch(q.getClass().getName()){
		case "dcll.vbjj.mysimplexml.Calculated":
			/* TEST LIGN -> */System.out.println("Question calculated");
			
			break;
			
		case "dcll.vbjj.mysimplexml.Essay":
			/* TEST LIGN -> */System.out.println("Question essay");
			classe = new Attribute("type","essay");
			this.question.setAttribute(classe);
			
			/* ADD BALISE NAME */
			ajouteBaliseName(((Essay)q).getName());
			/* ADD BALISE QUESTION TEXT */
			ajouteBaliseQuestionText(((Essay)q).getQuestionText());
			/* ADD BALISE IMAGE */
			ajouteBaliseImage();
			/* ADD BALISE GENERALFEEDBACK */
			ajouteBaliseGeneralFeedback(((Essay)q).getGeneralFeedback());
			/* ADD BALISE DEFAULTGRADE */
			ajouteBaliseSimpleTexte("defaultGrade",((Essay)q).getDefaultGrade());
			/* ADD BALISE PENALTY */
			ajouteBaliseSimpleTexte("penalty",((Essay)q).getPenalty());
			/* ADD BALISE HIDDEN */
			ajouteBaliseSimpleTexte("hidden",((Essay)q).getHidden());
			/* ADD BALISE SHUFFLEANSWERS */
			ajouteBaliseSimpleTexte("shuffleanswers",((Essay)q).getShuffleAnswers());
			/* ADD BALISE ANSWER */
			ajouteBaliseAnswer(((Essay)q).getAnswer());
		
			// Put on trunk
			racine.addContent(this.question);
			break;
			
		case "dcll.vbjj.mysimplexml.Matching":
			/* TEST LIGN -> */System.out.println("Question matching");
			
			break;
		
		case "dcll.vbjj.mysimplexml.MultipleChoice":
			/* TEST LIGN -> */System.out.println("Question multiplechoice");
			
			break;
		
		case "dcll.vbjj.mysimplexml.NumericalAnswer":
			/* TEST LIGN -> */System.out.println("Question numericalanswer");
			classe = new Attribute("type","numerical");
			question.setAttribute(classe);
			
			/* ADD BALISE NAME */
			ajouteBaliseName(((NumericalAnswer)q).getName());
			/* ADD BALISE QUESTION TEXT */
			ajouteBaliseQuestionText(((NumericalAnswer)q).getQuestionText());
			/* ADD BALISE IMAGE */
			ajouteBaliseImage();
			/* ADD BALISE GENERALFEEDBACK */
			ajouteBaliseGeneralFeedback(((NumericalAnswer)q).getGeneralFeedback());
			/* ADD BALISE DEFAULTGRADE */
			ajouteBaliseSimpleTexte("defaultGrade",((NumericalAnswer)q).getDefaultGrade());
			/* ADD BALISE PENALTY */
			ajouteBaliseSimpleTexte("penalty",((NumericalAnswer)q).getPenalty());
			/* ADD BALISE HIDDEN */
			ajouteBaliseSimpleTexte("hidden",((NumericalAnswer)q).getHidden());
			/* ADD BALISE SHUFFLEANSWERS */
			ajouteBaliseSimpleTexte("shuffleanswers",((NumericalAnswer)q).getShuffleAnswers());
			/* ADD BALISE ANSWER */
			ajouteBaliseAnswer(((NumericalAnswer)q).getAnswer());
		
			// Put on trunk
			racine.addContent(this.question);
			
			break;
		
		case "dcll.vbjj.mysimplexml.ShortAnswer":
			/* TEST LIGN -> */System.out.println("Question shortanswer");
			classe = new Attribute("type","shortanswer");
			question.setAttribute(classe);
			
			/* ADD BALISE NAME */
			ajouteBaliseName(((ShortAnswer)q).getName());
			/* ADD BALISE QUESTION TEXT */
			ajouteBaliseQuestionText(((ShortAnswer)q).getQuestionText());
			/* ADD BALISE IMAGE */
			ajouteBaliseImage();
			/* ADD BALISE GENERALFEEDBACK */
			ajouteBaliseGeneralFeedback(((ShortAnswer)q).getGeneralFeedback());
			/* ADD BALISE DEFAULTGRADE */
			ajouteBaliseSimpleTexte("defaultGrade",((ShortAnswer)q).getDefaultGrade());
			/* ADD BALISE PENALTY */
			ajouteBaliseSimpleTexte("penalty",((ShortAnswer)q).getPenalty());
			/* ADD BALISE HIDDEN */
			ajouteBaliseSimpleTexte("hidden",((ShortAnswer)q).getHidden());
			/* ADD BALISE SHUFFLEANSWERS */
			ajouteBaliseSimpleTexte("shuffleanswers",((ShortAnswer)q).getShuffleAnswers());
			/* ADD BALISE USECASE */
			ajouteBaliseSimpleTexte("usecase",((ShortAnswer)q).getUseCase());
			/* ADD BALISE ANSWER */
			ajouteListeBalisesAnswer(((ShortAnswer)q).getListAnswer());
		
			// Put on trunk
			racine.addContent(this.question);
			break;
		
		case "dcll.vbjj.mysimplexml.TrueFalse":
			/* TEST LIGN -> */System.out.println("Question truefalse");
			classe = new Attribute("type","truefalse");
			question.setAttribute(classe);
			
			/* ADD BALISE NAME */
			ajouteBaliseName(((TrueFalse)q).getName());
			/* ADD BALISE QUESTION TEXT */
			ajouteBaliseQuestionText(((TrueFalse)q).getQuestionText());
			/* ADD BALISE IMAGE */
			ajouteBaliseImage();
			/* ADD BALISE GENERALFEEDBACK */
			ajouteBaliseGeneralFeedback(((TrueFalse)q).getGeneralFeedback());
			/* ADD BALISE DEFAULTGRADE */
			ajouteBaliseSimpleTexte("defaultGrade",((TrueFalse)q).getDefaultGrade());
			/* ADD BALISE PENALTY */
			ajouteBaliseSimpleTexte("penalty",((TrueFalse)q).getPenalty());
			/* ADD BALISE HIDDEN */
			ajouteBaliseSimpleTexte("hidden",((TrueFalse)q).getHidden());
			/* ADD BALISE SHUFFLEANSWERS */
			ajouteBaliseSimpleTexte("shuffleanswers",((TrueFalse)q).getShuffleAnswers());
			/* ADD BALISE ANSWER */
			ajouteListeBalisesAnswer(((ShortAnswer)q).getListAnswer());
		
			// Put on trunk
			racine.addContent(this.question);
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
