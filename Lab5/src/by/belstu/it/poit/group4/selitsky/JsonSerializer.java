package by.belstu.it.poit.group4.selitsky;

import Student.Student;
import com.google.gson.Gson;

import java.io.PrintStream;
import java.util.List;

public class JsonSerializer {
    Gson gson = new Gson();

    public void serialize(PrintStream writer, List<Student> StudentList) {
        try {
            writer.println(gson.toJson(StudentList));
        } catch (Exception ex) {
            ex.toString();
        }
    }
}
