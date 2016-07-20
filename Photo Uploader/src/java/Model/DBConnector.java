/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author William
 */
public class DBConnector {
     private static String url;
    private static String dbName;
    private static String driver;
    private static String username;
    private static String password;
    private static DBConnector connector;
    private Connection connect;
    
    
    private DBConnector(){
        
        this.dbName = "photoupload";
        this.url = "jdbc:mysql://localhost:3306/" + dbName;
        this.driver = "com.mysql.jdbc.Driver";
        this.username = "root";
        this.password = "water";
        try{
            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(url, username, password);
          
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("no connection");
        }
    }
    
    public Connection getConnection(){
        
        
        return connect;
    }
    
    
//    public static void executeStatement(String statement){
//        Connection conn = getConnection();
//        ResultSet res = null;
//        try{
//            Statement st = conn.createStatement();
//            st.execute(statement);
//            conn.close();
//        }catch(SQLException e){
//            e.printStackTrace();
//            System.out.println("DB Error");
//        }
//    }
//    
//    public static ResultSet executeQuery(String query){
//        ResultSet result = null;
//        Connection conn = DBConnector.getConnection();
//        try{
//            Statement st = conn.createStatement();
//            result = st.executeQuery(query);
//        }catch(SQLException ex){
//             Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
    
    public Connection getConnect(){
        return connect;
    }
    
    public static DBConnector getInstance(){
        if(connector == null){
            connector = new DBConnector();
        }
        return connector;
    }
}
