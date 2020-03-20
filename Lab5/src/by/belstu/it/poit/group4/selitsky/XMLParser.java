package by.belstu.it.poit.group4.selitsky;

import Student.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import Enum.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

public class XMLParser {
    private boolean isValid;
    public List<Student> students;

    public void valid(String XMLPath, String XSDPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            File schemaLocation = new File(XSDPath);
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(XMLPath);
            validator.validate(source);
            isValid = true;
            System.out.println("File is Valid");
        } catch (SAXException sx) {
            System.out.println("File is not Valid");
        } catch (Exception e) {
            e.toString();
        }

    }

    public void xmlParserMeth(String filepath) {
        if (!isValid) {
            return;
        }
        try {
            JsonSerializer jS = new JsonSerializer();
            PrintStream writer = new PrintStream("files\\JSONFile.txt");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.parse(filepath);
            Gson gson = new Gson();

            doc.getDocumentElement().normalize();
            NodeList nodelist = doc.getElementsByTagName("Student");
            students = new ArrayList<Student>();

            for (int i = 0; i < nodelist.getLength(); i++) {
                Student buff = new Student();
                Node nNode = nodelist.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    buff.setName(element.getAttribute("name"));
                    buff.setCourse(Integer.parseInt(element.getElementsByTagName("course").item(0).getTextContent()));
                    String form = element.getElementsByTagName("form").item(0).getTextContent();
                    buff.setForm(form);
                    String spec = element.getElementsByTagName("spec").item(0).getTextContent();
                    buff.setSpec(spec);
                }
                students.add(buff);
            }
            jS.serialize(writer, students);
            Reader eadr = new FileReader("files\\JSONFile.txt");
            List<Student> students = new ArrayList<Student>();
            Type genDeser = new TypeToken<List<Student>>() {
            }.getType();
            students = gson.fromJson(eadr, genDeser);
            System.out.println("Deserialized");
            for (Student f : students) {
                f.toString();
                f.GoWalk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
