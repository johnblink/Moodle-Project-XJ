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
			System.out.println("Question1");
			// Find Attribute to the object
			Attribute classe = new Attribute("test","test");
			question.setAttribute(classe);
			break;
			
		case "dcll.vbjj.mysimplexml.Essay":
			typeQuestion="essay";
			System.out.println("Question2");
			break;
			
		case "dcll.vbjj.mysimplexml.Matching":
			typeQuestion="matching";
			System.out.println("Question3");
			break;
		
		case "dcll.vbjj.mysimplexml.MultipleChoice":
			typeQuestion="multiplechoice";
			System.out.println("Question4");
			break;
		
		case "dcll.vbjj.mysimplexml.NumericalAnswer":
			typeQuestion="numericalanswer";
			System.out.println("Question5");
			break;
		
		case "dcll.vbjj.mysimplexml.ShortQuestion":
			typeQuestion="shortquestion";
			System.out.println("Question6");
			break;
		
		case "dcll.vbjj.mysimplexml.TrueFalse":
			typeQuestion="truefalse";
			System.out.println("Question7");
			break;
		
		default:
		}
	}
	
	public void run (ArrayList<Question> listQuestion){
		
		this.listQuestion = listQuestion;
		Iterator<?> i = listQuestion.iterator();
		
		while(i.hasNext()) {
			System.out.println("Question---");
			parcoursQuestions((Question)i.next());
		}
		
		enregistre("src/main/java/xmlsample/quiz.xml");
	}
}
