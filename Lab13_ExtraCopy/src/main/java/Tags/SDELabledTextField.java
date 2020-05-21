package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SDELabledTextField extends SimpleTagSupport {

    private String label;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public SDELabledTextField() {
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            String outputText = String.format("<input type=\"text\" name=\"%s\" placeholder=\"%s\">",name,label);
//            String outputText = "Hello";
            getJspContext().getOut().write(outputText);
        } catch (Exception e) {
            e.printStackTrace();
            // stop page from loading further by throwing SkipPageException
            throw new SkipPageException("Exception in TLD");
        }
    }

}