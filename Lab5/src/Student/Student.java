package Student;

import Enum.*;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.StringWriter;

public class Student implements ErrorHandler {
    public Student(String pName, int pCourse, String pForm, String pSpecialization) {
        this.name = pName;
        this.course = pCourse;
        this.form = pForm;
        this.specialization = pSpecialization;
    }

    String name;

    public Student() {
    }

    @Override
    public String toString() {
        return this.name + " " + this.course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int course;

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    String form;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    String specialization;

    public String getSpec() {
        return specialization;
    }

    public void setSpec(String spec) {
        this.specialization = spec;
    }


    public void GoWalk() {
        System.out.println("Go walk");
    }

    public void MissLesson() {
        System.out.println("Miss");
    }

    public void PlayGames() {
        System.out.println("Play");
    }

    public void warning(SAXParseException exception) throws SAXException {
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }
}