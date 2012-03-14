package dcll.vbjj.mysimplexml;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class App 
{
	private ArrayList<Question> listQuestion = new ArrayList<Question>();
	
	private void parser(Element e) {
		switch(e.getAttributeValue("type")) {
			case "truefalse" :
				TrueFalse tf = new TrueFalse();
				Answer a = new Answer(e.getChild("name").getChildText("text"));
				tf.ajoutAnswer(a);
				listQuestion.add(tf);
				break;
				
			case "shortanswer" :
				ShortAnswer sa = new ShortAnswer();
				a = new Answer(e.getChild("name").getChildText("text"));
				sa.ajoutAnswer(a);
				listQuestion.add(sa);
				break;
				
			case "essay" :
				Essay es = new Essay();
				a = new Answer(e.getChild("name").getChildText("text"));
				es.ajoutAnswer(a);
				listQuestion.add(es);
				break;
				
			case "multichoice" :
				
				break;
				
			case "matching" :
				
				break;
			
			case "numerical" :
				
				break;
				
			default :
				Logger logger = Logger.getLogger("app");
				logger.info(e.getAttributeValue("type"));
		}
	}
	
	public void xml2Java(String file) {
		Element racine = null;
		SAXBuilder sxb = new SAXBuilder();
		
		try {
			File f = new File(file);
			if(!f.exists())
				System.out.println("Fichier introuvable!");
			racine = sxb.build(file).getRootElement();
		}
		catch(Exception e){}
		
		Iterator<?> i = racine.getChildren("question").iterator();
		while(i.hasNext())
			parser((Element)i.next());
	}
	
	public void affiche() {
		System.out.println(listQuestion.toString());
	}

	public App() {}
}