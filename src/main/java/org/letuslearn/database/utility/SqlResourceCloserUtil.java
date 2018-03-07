// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author aksharaaaa Get the SQlClosingUtil to close Resources used
 *
 */
public class SqlResourceCloserUtil {
    public static final Logger logger = LoggerFactory.getLogger(SqlResourceCloserUtil.class);
    public void close(PreparedStatement preparedStatement){
        try {
            preparedStatement.close();
            preparedStatement = null;
        } catch (SQLException e) {
            logger.error("In Prepared Statement Closing error " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void close(ResultSet resultSet){
        try {
            resultSet.close();
            resultSet = null;
        } catch (SQLException e) {
            logger.error("In Result Closing error " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void close(Connection connection){
        try {
            if (!connection.isClosed()){
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
}
