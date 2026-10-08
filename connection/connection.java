package booksmart.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connection {

//    private static final String DATABASE = "app.db.name";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "kishan2007";
    private static Connection connection;

    static {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksmart_java", USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet Search(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

    public static void IUD(String query) {

        try {
            connection.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
