package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc : mysql://localhost:3306/bt_book",
                        "root",
                        "123456789");
                System.out.println("Kết nối thành công");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Kết nối thất bại");
            }
        }
        return connection;
    }
}
