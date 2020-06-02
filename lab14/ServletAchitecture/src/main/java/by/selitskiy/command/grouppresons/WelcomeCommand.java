package by.selitskiy.command.grouppresons;

import by.selitskiy.command.Command;
import by.selitskiy.command.CommandResult;
import by.selitskiy.exception.IncorrectDataException;
import by.selitskiy.exception.ServiceException;
import by.selitskiy.model.Person;
import by.selitskiy.service.PersonService;
import by.selitskiy.util.pages.Page;
import static by.selitskiy.command.grouppresons.constant.GroupConstant.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {

        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}

