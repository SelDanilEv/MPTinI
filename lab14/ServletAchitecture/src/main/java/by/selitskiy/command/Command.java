package by.selitskiy.command;

import by.selitskiy.exception.IncorrectDataException;
import by.selitskiy.exception.ServiceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws  ServiceException, IncorrectDataException, ServletException, IOException;
}
