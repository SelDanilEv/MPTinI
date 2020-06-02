package by.selitskiy.service;

import by.selitskiy.exception.RepositoryException;
import by.selitskiy.exception.ServiceException;
import by.selitskiy.model.User;
import by.selitskiy.repository.RepositoryCreator;
import by.selitskiy.repository.SQLHelper;
import by.selitskiy.repository.UserRepository;
import by.selitskiy.repository.paramspecification.UserByLogin;
import by.selitskiy.repository.paramspecification.UserByLoginPassword;

// Service with user - login, save user

import java.util.Optional;

public class UserService {

    public Optional<User> login(String login, byte[] password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {

            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLoginPassword params = new UserByLoginPassword(login, password);
            return userRepository.queryForSingleResult(SQLHelper.SQL_GET_USER, params);

        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    public Integer save(User user) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLogin param = new UserByLogin(user.getLogin());
            if (!userRepository.queryForSingleResult(SQLHelper.SQL_CHECK_LOGIN, param).isPresent()) {
                return userRepository.save(user);
            } else {
                return 0;
            }
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
