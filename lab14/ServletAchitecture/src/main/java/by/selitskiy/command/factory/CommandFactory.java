package by.selitskiy.command.factory;

import by.selitskiy.command.Command;
import by.selitskiy.command.LoginPageCommand;
import by.selitskiy.command.RegisterPageCommand;
import by.selitskiy.command.authorithation.LoginCommand;
import by.selitskiy.command.authorithation.RegisterNewUserCommand;
import by.selitskiy.command.authorithation.SingOutCommand;
import by.selitskiy.command.grouppresons.AddNewPersonCommand;
import by.selitskiy.command.grouppresons.WelcomeCommand;

//Создает команды

public class CommandFactory {
    public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand;
        switch (commandEnum) {
            case LOGIN: {
                resultCommand = new LoginCommand();
                break;
            }
            case REGISTER_NEW_USER: {
                resultCommand = new RegisterNewUserCommand();
                break;
            }
            case SIGN_OUT: {
                resultCommand = new SingOutCommand();
                break;
            }
            case ADD_NEW_PERSON:{
                resultCommand = new AddNewPersonCommand();
                break;
            }
            case LOGIN_PAGE:{
                resultCommand = new LoginPageCommand();
                break;
            }
            case WELCOME:{
                resultCommand = new WelcomeCommand();
                break;
            }
            case REGISTRATION_PAGE:{
                resultCommand = new RegisterPageCommand();
                break;
            }

            default: {
                throw new IllegalArgumentException("Invalid command" + commandEnum);
            }
        }
        return resultCommand;
    }
}
