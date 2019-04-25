/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class CourseMangmentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student_course> st_co=new ArrayList<>();
        FileManager.write(st_co , "Student_course.bin");
    }
    
}
