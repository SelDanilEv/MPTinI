package User.Tags;

import javafx.beans.property.SimpleObjectProperty;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.ArrayList;

public class SDETable extends SimpleTagSupport {
    private ArrayList<Object> objects;
    private int sum;

    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public SDETable() {
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            String outputText = "<table>";
            for (Object obj:objects
                 ) {
                outputText+="<tr><td>"+obj.toString()+"<hr></td></tr>";
            }
            outputText+="<tr><td>Sum: "+sum+"</tr></td>";
            outputText += "</table>";
            getJspContext().getOut().write(outputText);
        } catch (Exception e) {
            e.printStackTrace();
            // stop page from loading further by throwing SkipPageException
            throw new SkipPageException("Exception in TLD");
        }
    }

}