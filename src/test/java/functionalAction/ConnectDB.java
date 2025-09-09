package functionalAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root","Trinhkim6#123");
        System.out.println(connection);
        if(connection.isClosed()){
            System.out.println("We disconect DB");
        }else {
            System.out.println("We connect successfully");
        }
    }
}
