//*
/** To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;
//import java.io.ObjectInputStream;
//import java.io.FileInputStream;



/**
 *
 * @author PC
 */
public  class FileManager{
    
    public static Object read(String path) {
        ObjectInputStream Bin = null;
        try {
            Bin = new ObjectInputStream(new FileInputStream(path));
            return Bin.readObject();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "sorry file not do open");
            return null;

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "sorry file not exist");
            return null;
        }

    }

    public static void write(Object object, String path) {
        try {
            ObjectOutputStream Bin = new ObjectOutputStream(new FileOutputStream(path));
            Bin.writeObject(object);
            Bin.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sorry file not do open");
        }

    }


}