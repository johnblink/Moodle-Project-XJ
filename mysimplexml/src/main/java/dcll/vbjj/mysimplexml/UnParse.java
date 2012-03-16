package dcll.vbjj.mysimplexml;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class UnParse {
	// List with questions
	ArrayList<Question> listQuestion;
	// XML Trunk = quiz
	static Element racine = new Element("quiz");
	// Create new Document JDOM based on new trunk
	static Document document = new Document(racine);
	
	// Constructor
	public UnParse() {
		
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
	
	// Write A Question
	public void parcoursQuestions(Question q) {
		String typeQuestion = q.getClass().getName();
		Element question;
		
		switch(typeQuestion){
		case "dcll.vbjj.mysimplexml.Calculated":
			typeQuestion="calculated";
			question = new Element(typeQuestion);
			racine.addContent(question);
			
			// Find Attribute to the object
			Attribute classe = new Attribute("test","test");
			question.setAttribute(classe);
			break;
			
		case "dcll.vbjj.mysimplexml.Essay":
			typeQuestion="essay";
			break;
			
		case "dcll.vbjj.mysimplexml.Matching":
			typeQuestion="matching";
			break;
		
		case "dcll.vbjj.mysimplexml.MultipleChoice":
			typeQuestion="multiplechoice";
			break;
		
		case "dcll.vbjj.mysimplexml.NumericalAnswer":
			typeQuestion="numericalanswer";
			break;
		
		case "dcll.vbjj.mysimplexml.ShortQuestion":
			typeQuestion="shortquestion";
			break;
		
		case "dcll.vbjj.mysimplexml.TrueFalse":
			typeQuestion="truefalse";
			break;
		
		default:
		}
	}
	
	private void run (ArrayList<Question> listQuestion){
		
		this.listQuestion = listQuestion;
		Iterator<?> i = listQuestion.iterator();
		
		while(i.hasNext())
			parcoursQuestions((Question)i.next());
		
		enregistre("src/main/java/xmlsample/quiz.xml");
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Question> l = new ArrayList<Question>();
		UnParse unparse = new UnParse();
		unparse.run(l); 
	}

}
