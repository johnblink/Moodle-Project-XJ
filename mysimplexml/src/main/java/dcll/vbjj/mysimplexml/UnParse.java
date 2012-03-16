package dcll.vbjj.mysimplexml;


import java.io.FileOutputStream;
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
		Element question = new Element("question");
		Attribute classe;
		
		switch(typeQuestion){
		case "dcll.vbjj.mysimplexml.Calculated":
			/* TEST LIGN -> */System.out.println("Question calculated");
			
			racine.addContent(question);
			// Find Attribute to the object
			classe = new Attribute("test","test");
			question.setAttribute(classe);
			break;
			
		case "dcll.vbjj.mysimplexml.Essay":
			/* TEST LIGN -> */System.out.println("Question essay");
			
			classe = new Attribute("type","essay");
			question.setAttribute(classe);
			
			Element name = new Element("name");
			question.addContent(name);
			Element text = new Element("text");
			name.addContent(text);
			text.setText(((Essay)q).getName());
			// Put on trunk
			racine.addContent(question);
			// Find Attribute to the object
			
			break;
			
		case "dcll.vbjj.mysimplexml.Matching":
			/* TEST LIGN -> */System.out.println("Question matching");
			
			break;
		
		case "dcll.vbjj.mysimplexml.MultipleChoice":
			/* TEST LIGN -> */System.out.println("Question multiplechoice");
			
			break;
		
		case "dcll.vbjj.mysimplexml.NumericalAnswer":
			/* TEST LIGN -> */System.out.println("Question numericalanswer");
			
			break;
		
		case "dcll.vbjj.mysimplexml.ShortAnswer":
			/* TEST LIGN -> */System.out.println("Question shortanswer");
			
			break;
		
		case "dcll.vbjj.mysimplexml.TrueFalse":
			/* TEST LIGN -> */System.out.println("Question truefalse");
			
			break;
		
		default:
		}
	}
	
	public void run (ArrayList<Question> listQuestion){
		
		this.listQuestion = listQuestion;
		Iterator<?> i = listQuestion.iterator();
		
		while(i.hasNext()) {
			parcoursQuestions((Question)i.next());
		}
		
		enregistre("src/main/java/xmlsample/quiz.xml");
	}
}
