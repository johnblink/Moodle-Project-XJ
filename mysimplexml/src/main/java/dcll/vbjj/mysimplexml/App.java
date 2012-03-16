package dcll.vbjj.mysimplexml;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class App 
{
	private ArrayList<Question> listQuestion = new ArrayList<Question>();
	
	private void parser(Element e) {
		switch(e.getAttributeValue("type")) {
			case "truefalse" :
				TrueFalse tf = new TrueFalse(e.getChild("name").getChildText("text"),e.getChild("questiontext").getChildText("text"),e.getChild("questiontext").getAttributeValue("format"),e.getChild("image").getValue(),e.getChild("generalfeedback").getTextTrim(),e.getChild("defaultgrade").getText(),e.getChild("penalty").getTextTrim(),e.getChild("hidden").getText(),e.getChild("shuffleanswers").getText());
				Iterator<?> ite = e.getChildren("answer").iterator();
				while(ite.hasNext()) {
					Element parcour = (Element) ite.next();
					if(parcour.getName().equals("answer"))
						tf.ajoutAnswer(new Answer(parcour.getChildText("text"),parcour.getAttributeValue("fraction"),parcour.getChild("feedback").getTextTrim()));
				}
				listQuestion.add(tf);
				break;
				
			case "shortanswer" :
				ShortAnswer sa = new ShortAnswer(e.getChild("name").getChildText("text"),e.getChild("questiontext").getChildText("text"),e.getChild("questiontext").getAttributeValue("format"),e.getChild("image").getValue(),e.getChild("generalfeedback").getTextTrim(),e.getChild("defaultgrade").getText(),e.getChild("penalty").getTextTrim(),e.getChild("hidden").getText(),e.getChild("shuffleanswers").getText(),e.getChild("usecase").getText());
				ite = e.getChildren("answer").iterator();
				while(ite.hasNext()) {
					Element parcour = (Element) ite.next();
					if(parcour.getName().equals("answer"))
						sa.ajoutAnswer(new Answer(parcour.getChildTextTrim("text"),parcour.getAttributeValue("fraction"),parcour.getChild("feedback").getChildTextTrim("text")));
				}
				listQuestion.add(sa);
				break;
				
			case "essay" :
				Essay es = new Essay(e.getChild("name").getChildText("text"),e.getChild("questiontext").getChildText("text"),e.getChild("questiontext").getAttributeValue("format"),e.getChild("image").getValue(),e.getChild("generalfeedback").getTextTrim(),e.getChild("defaultgrade").getText(),e.getChild("penalty").getTextTrim(),e.getChild("hidden").getText(),e.getChild("shuffleanswers").getText(),new Answer(e.getChild("answer").getChildText("text"),e.getChild("answer").getAttributeValue("fraction"),e.getChild("answer").getChild("feedback").getTextTrim()));
				listQuestion.add(es);
				break;
				
			case "multichoice" :
				
				break;
				
			case "matching" :
				
				break;
			
			case "numerical" :
				Answer a = new Answer(e.getChild("answer").getChildText("text"),e.getChild("answer").getAttributeValue("fraction"),e.getChild("answer").getChild("feedback").getTextTrim());
				a.setTolerance(e.getChild("answer").getChildText("tolerance"));
				NumericalAnswer na = new NumericalAnswer(e.getChild("name").getChildText("text"),e.getChild("questiontext").getChildText("text"),e.getChild("questiontext").getAttributeValue("format"),e.getChild("image").getValue(),e.getChild("generalfeedback").getTextTrim(),e.getChild("defaultgrade").getText(),e.getChild("penalty").getTextTrim(),e.getChild("hidden").getText(),e.getChild("shuffleanswers").getText(),a);
				listQuestion.add(na);
				break;
				
			case "calculated" :
				
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