package dcll.vbjj.mysimplexml;

import java.io.File;
import java.util.Iterator;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class App 
{
	private Element racine;
	private Document document;
	
	public void xml2Java(String file) {
		 //On crée une instance de SAXBuilder
	      SAXBuilder sxb = new SAXBuilder();
	      try
	      {
	    	 File f = new File(file);
	    	 if(!f.exists())
	    		 System.out.println("Fichier introuvable!");
	         //On crée un nouveau document JDOM avec en argument le fichier XML
	         //Le parsing est terminé ;)
	         //document = sxb.build(this.getClass().getResourceAsStream(file));
	    	 document = sxb.build(file);
	      }
	      catch(Exception e){}

	      //On initialise un nouvel élément racine avec l'élément racine du document.
	      racine = document.getRootElement();

		  //On crée un Iterator sur notre liste
		  Iterator i = racine.getChildren("question").iterator();
		  while(i.hasNext()) {
			  //On recrée l'Element courant à chaque tour de boucle afin de
			  //pouvoir utiliser les méthodes propres aux Element comme :
			  //selectionner un noeud fils, modifier du texte, etc...
			  parser((Element)i.next());
		  }
	}
	
	private void parser(Element e) {
		if(e.getAttributeValue("type").equals("truefalse")) {
			TrueFalse tf = new TrueFalse();
			Answer a = new Answer(e.getChild("name").getChildText("text"));
			tf.ajoutAnswer(a);
			tf.affiche();
		}
	}

	public App() {
		
	}
}