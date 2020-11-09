/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Chathumal
 */
public class DBConnection {
    
    private Connection connection;
    private static DBConnection dBConnection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root","mysql");
    }
    public Connection getConnection(){
        return connection;
    }
    public static DBConnection getInstace() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }return dBConnection;
    }
    
    
}
