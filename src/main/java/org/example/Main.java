package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        String username = args[0];
        String password = args[1];

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                username, password);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT productid, productname, unitprice, unitsinstock FROM products");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("Product ID = %s, Product Name = %s, UnitPrice = %s, Units in Stock = %s; \n",
                    resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
