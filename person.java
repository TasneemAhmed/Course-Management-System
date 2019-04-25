/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;

import java.io.Serializable;

/**
 *
 * @author dell
 */
public class person implements Serializable{
     public String id;
     public String name;
     public String phone;
     public String address;
     public String email;
     public String password;
     public String username;


    public person() {
        this.id = "";
        this.name = "";
        this.phone = "";
        this.address = "";
        this.email = "";
        this.password = "";
        this.username = "";
    }
    
}
