/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author William
 */
public class PhotoHandler {
     private static PhotoHandler photo = new PhotoHandler();
    private DBConnector connector;
    private Connection connect;
    private  ResultSet result;
    private PreparedStatement statement;
    
    private PhotoHandler(){
        connector = DBConnector.getInstance();
        connect = connector.getConnect();
    }
    
    public static PhotoHandler getInstance(){
        return photo;
    }
    
    public void upload(Photo puto, String username){
        try{
            String query = "UPDATE account SET image = ? WHERE name = ?";
            statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, puto.getDirectory());
            statement.setString(2, username);
            statement.executeUpdate();
            result = statement.getGeneratedKeys();
            result.next();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Photo retrieve(String username){
        Photo pic = null;
        
        try{
            String query = "SELECT image FROM account WHERE name = ?";
            statement = connect.prepareStatement(query);
            statement.setString(1, username);
            result = statement.executeQuery();
            if(result.next()){
                pic = new Photo(username, result.getString("image"));
               
            }
            return pic;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
        
    }
}
