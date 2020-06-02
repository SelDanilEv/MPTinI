package by.selitskiy.builder;

import by.selitskiy.exception.RepositoryException;
import java.sql.ResultSet;

public interface Builder <T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
