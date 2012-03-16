package dcll.vbjj.mysimplexml;

import java.util.ArrayList;

public class Main {
    public static void main( String[] args )
    {
        App test = new App();
        test.xml2Java("src/main/java/xmlsample/Test.xml");
        test.affiche();
        ArrayList <Question> l = test.getQuestions();
        System.out.println(l.size());
        UnParse unparse = new UnParse();
		unparse.run(l); 
    }
}
