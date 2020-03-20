package by.belstu.it.poit.group4.selitsky;

public class Main {

    public static void main(String[] args) {
        try {
            XMLParser obj = new XMLParser();
            obj.valid("files\\XML.xml", "files\\XSD.xsd");
            obj.xmlParserMeth("files\\XML.xml");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
