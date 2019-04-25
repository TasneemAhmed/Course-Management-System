/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Attendance implements Serializable{
    public String course_id;
    public String student_id;
    public int session_number;
    
    
    
    public static void attend(Course course , Student student , int session_number)
    {
        ArrayList<Attendance> attend_student =(ArrayList<Attendance>) FileManager.read("Attendance.bin"); 
        Attendance temp=new Attendance();
        temp.course_id=course.id;
        temp.student_id=student.id;
        temp.session_number=session_number;
        attend_student.add(temp);
        FileManager.write(attend_student, "Attendance.bin");
    }
    
    public void remove_attend(Course course , Student student , int session_number)
    {
        ArrayList<Attendance> attend_student =(ArrayList<Attendance>) FileManager.read("Attendance.bin"); 
        for(int i=0;i<attend_student.size();i++)
        {
            if(attend_student.get(i).course_id.equals(course.id) && attend_student.get(i).student_id.equals(student.id) && attend_student.get(i).session_number==session_number)
            {
                attend_student.remove(i);
            }
        }
        FileManager.write(attend_student, "Attendance.bin");
    }
    

    public static ArrayList<Attendance> all()
     {
         return (ArrayList<Attendance>) FileManager.read("Attendance.bin"); 
     }
}
