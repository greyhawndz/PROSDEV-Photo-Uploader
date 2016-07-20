/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author William
 */
public class Photo {
     private String username;
    private String directory;

    public String getUsername() {
        return username;
    }

    public String getDirectory() {
        return directory;
    }

    public Photo(String username, String directory) {
        this.username = username;
        this.directory = directory;
    }
}
