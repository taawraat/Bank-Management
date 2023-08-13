package finalproject;
import java.sql.*;

public class DBconnect {
    Connection conn = null;
    
    public static Connection ConnectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/tawraat/NetBeansProjects/DB/Project.db");
            System.out.println("DB connected!");
            return conn;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
