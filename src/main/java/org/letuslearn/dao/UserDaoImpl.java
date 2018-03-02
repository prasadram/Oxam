// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.dao;

import org.letuslearn.beans.data.User;
import org.letuslearn.database.connection.service.ConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author aksharaaaa Get the UserDaoImplementation
 *
 */
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    public boolean insert(User user) {
        //SqlStatement sqlStatement = new SqlStatement();
        //String insertStatement = sqlStatement.getInsertStatment("user");
        String insertStatement = "INSERT INTO userdetails(userid, username, password, " +
                " firstname, lastname, gender, email, age, flag)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) returning true";
        Connection connection = ConnectionProvider.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Boolean isInserted = Boolean.FALSE;
        try {
            preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getGender().toUpperCase());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setInt(8, user.getAge());
            preparedStatement.setString(9, "N");
            resultSet = preparedStatement.executeQuery();

            logger.info("Result is ", resultSet);
            isInserted = Boolean.TRUE;
        } catch (SQLException sqlException){
            logger.error("Error is " + sqlException.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                    resultSet = null;
                } catch (SQLException e) {
                    logger.error("In Result Closing error " + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                } catch (SQLException e) {
                    logger.error("In Prepared Statement Closing error " + e.getMessage());
                    e.printStackTrace();
                }
            }
            try {
                if (connection != null && !connection.isClosed()){
                    if (!connection.getAutoCommit()) {
                        connection.commit();
                    }
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sqlException){
                logger.error("In Connection Closing Catch " + sqlException.getMessage());
                sqlException.printStackTrace();
            }
        }
        return isInserted;
    }

    public boolean update(User user) {
        String updateStatement = "UPDATE userdetails SET " +
                " firstname=?, lastname=?, gender=?, email=?, age=?, flag=? WHERE userid=?";
        Connection connection = ConnectionProvider.getInstance().getConnection();
        PreparedStatement preparedStatementUpdate = null;
        ResultSet resultSet = null;
        Boolean isInserted = Boolean.FALSE;
        try {
            preparedStatementUpdate = connection.prepareStatement(updateStatement);
            //preparedStatement.setString(1, user.getUserName());
            //preparedStatement.setString(2, user.getPassword());
            preparedStatementUpdate.setString(1, user.getFirstName());
            preparedStatementUpdate.setString(2, user.getLastName());
            preparedStatementUpdate.setString(3, user.getGender().toUpperCase());
            preparedStatementUpdate.setString(4, user.getEmail());
            preparedStatementUpdate.setInt(5, user.getAge());
            preparedStatementUpdate.setString(6, "N");
            preparedStatementUpdate.setInt(7, user.getUserId());
            resultSet = preparedStatementUpdate.executeQuery();

            logger.info("Result is ", resultSet);
            isInserted = Boolean.TRUE;
        } catch (SQLException sqlException){
            logger.error("Error is " + sqlException.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                    resultSet = null;
                } catch (SQLException e) {
                    logger.error("In Result Closing error " + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (preparedStatementUpdate != null){
                try {
                    preparedStatementUpdate.close();
                    preparedStatementUpdate = null;
                } catch (SQLException e) {
                    logger.error("In Prepared Statement Closing error " + e.getMessage());
                    e.printStackTrace();
                }
            }
            try {
                if (connection != null && !connection.isClosed()){
                    if (!connection.getAutoCommit()) {
                        connection.commit();
                    }
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sqlException){
                logger.error("In Connection Closing Catch " + sqlException.getMessage());
                sqlException.printStackTrace();
            }
        }
        return isInserted;

    }

    public int delete(User user) {
        String deleteStatement = "DELETE FROM userdetails WHERE userid=?";
        Connection connection = ConnectionProvider.getInstance().getConnection();
        PreparedStatement preparedStatementDelete = null;
        ResultSet resultSet = null;
        try {
            preparedStatementDelete = connection.prepareStatement(deleteStatement);
            //preparedStatement.setString(1, user.getUserName());
            //preparedStatement.setString(2, user.getPassword());
            preparedStatementDelete.setString(1, user.getFirstName());
            resultSet = preparedStatementDelete.executeQuery();
            logger.info("Result in Delete is ", resultSet);
        } catch (SQLException sqlException) {
            logger.error("In Delete Exception " + sqlException.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                    resultSet = null;
                } catch (SQLException e) {
                    logger.error("In Result Closing error " + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (preparedStatementDelete != null){
                try {
                    preparedStatementDelete.close();
                    preparedStatementDelete = null;
                } catch (SQLException e) {
                    logger.error("In Prepared Statement Closing error " + e.getMessage());
                    e.printStackTrace();
                }
            }
            try {
                if (connection != null && !connection.isClosed()){
                    if (!connection.getAutoCommit()) {
                        connection.commit();
                    }
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sqlException){
                logger.error("In Connection Closing Catch " + sqlException.getMessage());
                sqlException.printStackTrace();
            }
        }
        return 0;
    }

    public List<User> getAll() {
        return null;
    }

    public User get(User type) {
        return null;
    }
}
