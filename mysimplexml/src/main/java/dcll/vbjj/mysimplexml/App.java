package dcll.vbjj.mysimplexml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	//Nous allons commencer notre arborescence en créant la racine XML
	//qui sera ici "personnes".
	static Element racine = new Element("quiz");

	//On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
	static Document document = new Document(racine);
	
	public static void xml2Java(String file) {
		 //On crée une instance de SAXBuilder
	      SAXBuilder sxb = new SAXBuilder();
	      try
	      {
	         //On crée un nouveau document JDOM avec en argument le fichier XML
	         //Le parsing est terminé ;)
	         document = sxb.build(new File(file));
	      }
	      catch(Exception e){}

	      //On initialise un nouvel élément racine avec l'élément racine du document.
	      racine = document.getRootElement();
	      
	      System.out.println("<"+racine.getText()+">");

	      //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		  List listQuestion = racine.getChildren("question");
		  //On crée un Iterator sur notre liste
		  Iterator i = listQuestion.iterator();
		  while(i.hasNext()) {
			  //On recrée l'Element courant à chaque tour de boucle afin de
			  //pouvoir utiliser les méthodes propres aux Element comme :
			  //selectionner un noeud fils, modifier du texte, etc...
			  Element courant = (Element)i.next();
			  //On affiche le nom de l'element courant
			  System.out.println(courant.getText());
		  }
	}
	
    public static void main( String[] args )
    {
        xml2Java("Test.xml");
    }
}
