package com.example.api.dbunit;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomDeleteOperation extends DatabaseOperation {

    private void deleteFromUserTable(IDatabaseConnection connection) throws SQLException {
        String deleteSql = "DELETE FROM `USER`";

        try (Connection sqlConnection = connection.getConnection();
             PreparedStatement preparedStatement = sqlConnection.prepareStatement(deleteSql)) {
            preparedStatement.executeUpdate();
        }
    }

    private void deleteFromOtherTables(IDatabaseConnection connection) throws SQLException {

        String deleteFromAddress = "DELETE FROM `address`";
        String deleteFromClassroom = "DELETE FROM `classroom`";

        executeDelete(connection, deleteFromAddress);
        executeDelete(connection, deleteFromClassroom);

    }

    private void executeDelete(IDatabaseConnection connection, String deleteSql) throws SQLException {
        try (Connection sqlConnection = connection.getConnection();
             PreparedStatement preparedStatement = sqlConnection.prepareStatement(deleteSql)) {
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void execute(IDatabaseConnection iDatabaseConnection, IDataSet iDataSet) throws DatabaseUnitException, SQLException {
        if (iDatabaseConnection.getConnection().isClosed()) {
            throw new SQLException("Connection is already closed");
        }
        deleteFromUserTable(iDatabaseConnection);

        deleteFromOtherTables(iDatabaseConnection);

    }
}
