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
public class Branch implements Serializable {
    public String id;
    public String Address;
    public String phoneNumber;
    public int openHour;
    public int closeHour;
    
    
     public boolean load(String id)
   {
      ArrayList<Branch> Branchs =(ArrayList<Branch>) FileManager.read("Branch.bin"); 
      for(int i=0;i<Branchs.size();i++)
      {
          if(Branchs.get(i).id.equals(id))
          {
              this.Address = Branchs.get(i).Address;
              this.id = Branchs.get(i).id;
              this.phoneNumber = Branchs.get(i).phoneNumber;
              this.openHour = Branchs.get(i).openHour;
              this.closeHour = Branchs.get(i).closeHour;
              
              return true;
          }
      }
      return false;
   }
    public ArrayList<Course> avilableCourses()
    {
        ArrayList<Branch_course> Branch_courses =(ArrayList<Branch_course>) FileManager.read("Branch_course.bin");
        ArrayList<Course> result=new ArrayList<>();
        for(int i=0;i<Branch_courses.size();i++)
        {
             if(Branch_courses.get(i).branch_id.equals(this.id))
             {
                Course temp=new Course();
                temp.load(Branch_courses.get(i).course_id);
                result.add(temp);
             }
        }
        return result;
    }
    
    public void add_course(Course course)
   {
        ArrayList<Branch_course> branch_courses =(ArrayList<Branch_course>) FileManager.read("Branch_course.bin");
        Branch_course temp=new Branch_course();
        temp.course_id=course.id;
        temp.branch_id=this.id;
        branch_courses.add(temp);
        FileManager.write(branch_courses, "Branch_course.bin");
   }
      
    public ArrayList<Instructor> avilableInstructor()
    {
        ArrayList<Branch_instractor> Branch_instractors =(ArrayList<Branch_instractor>) FileManager.read("Branch_instractor.bin");
        ArrayList<Instructor> result=new ArrayList<>();
        for(int i=0;i<Branch_instractors.size();i++)
        {
             if(Branch_instractors.get(i).branch_id.equals(this.id))
             {
                Instructor temp=new Instructor();
                temp.load(Branch_instractors.get(i).instructor_id);
                result.add(temp);
             }
        }
        return result;
    }
      
   public void add_instructor(Instructor instructor)
   {
        ArrayList<Branch_instractor> branch_courses =(ArrayList<Branch_instractor>) FileManager.read("Branch_instractor.bin");
        Branch_instractor temp=new Branch_instractor();
        temp.instructor_id=instructor.id;
        temp.branch_id=this.id;
        branch_courses.add(temp);
        FileManager.write(branch_courses, "Branch_instractor.bin");
   }
      
  
}
