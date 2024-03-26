package org.homework.dev_module8;

import org.homework.dev_module8.entity.Client;
import org.homework.dev_module8.validation.ValidationException;
import org.homework.dev_module8.validation.ValidationService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ClientService {
    private final Connection connection;
    private final Logger logger = Logger.getLogger(ClientService.class.getName());
    private final ValidationService validationService = new ValidationService();

    public ClientService(Database database) {
       this.connection = database.getConnection();
    }

    public long create(String name) {
        long clientId = -1;

        try {
            validationService.validateName(name);

            PreparedStatement insertPS = connection.prepareStatement(SQLQuery.CREATE_CLIENT);
            PreparedStatement selectPS = connection.prepareStatement(SQLQuery.GET_LAST_ID);

            insertPS.setString(1, name);
            insertPS.executeUpdate();

            ResultSet resultSet = selectPS.executeQuery();

            if (resultSet.next()) {
                clientId = resultSet.getLong(1);
            }

            insertPS.close();
            selectPS.close();

            logger.info("Client " + name + " added. ID is " + clientId);
        } catch (SQLException | ValidationException e) {
            throw new RuntimeException(e);
        }

        return clientId;
    }

    public String getById(long id) {
        String result = null;

        try {
            validationService.validateId(id);

            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.GET_NAME_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                result = resultSet.getString("NAME");
            }

            preparedStatement.close();
        } catch (SQLException | ValidationException e) {
            throw new RuntimeException(e);
        }

        logger.info("Client " + result + " with ID " + id);

        return result;
    }

    public void setName(long id, String name) {
        try {
            validationService.validateName(name);
            validationService.validateId(id);

            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.SET_NAME_BY_ID);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            logger.info("Client " + id + " new name " + name);
        } catch (SQLException | ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id) {
        try {
            validationService.validateId(id);

            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            logger.info("Client " + id + " removed");
        } catch (SQLException | ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> listAll() {
        List<Client> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(new Client(resultSet.getLong("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
