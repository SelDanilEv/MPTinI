package by.selitskiy.command.authorithation;

import by.selitskiy.command.Command;
import by.selitskiy.command.CommandResult;
import by.selitskiy.command.session.SessionAttribute;
import by.selitskiy.exception.IncorrectDataException;
import by.selitskiy.exception.ServiceException;
import by.selitskiy.util.pages.Page;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SingOutCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(SingOutCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
            HttpSession session = request.getSession();
            String username  = (String)session.getAttribute(SessionAttribute.NAME);
            LOGGER.info("user was above: name:" + username);
            session.removeAttribute(SessionAttribute.NAME);
            return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
        }
}
