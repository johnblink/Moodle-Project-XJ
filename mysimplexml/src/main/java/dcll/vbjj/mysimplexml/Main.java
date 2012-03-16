package dcll.vbjj.mysimplexml;

public class Main {
    public static void main( String[] args )
    {
        App test = new App();
        test.xml2Java("src/main/java/xmlsample/Test.xml");
        test.affiche();
        test.getQuestions();
    }
}
