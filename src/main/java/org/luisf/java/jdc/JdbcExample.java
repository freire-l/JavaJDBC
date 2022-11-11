package org.luisf.java.jdc;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
        String username = "root";
        String pwd = "1234";

        try {
            Connection conn = DriverManager.getConnection(url,username,pwd);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM productos");

            while (result.next()){
                System.out.println(result.getString("nombre"));
            }
            result.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
