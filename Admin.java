/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;

import java.util.ArrayList;
import java.lang.String;

/**
 *
 * @author dell
 */
public class Admin extends person 
{
    public void add_student_to_course(Student student,Course course,int level)
    {
        course.add_student(student, level);
    }
    public void add_course_to_branch(Branch branch,Course course)
    {
        branch.add_course(course);
    }
    public void add_instructor_to_branch(Branch branch,Instructor instructor )
    {
        branch.add_instructor(instructor);
    }
    public void add_course_to_instructor(Course course,Instructor instructor )
    {
        instructor.addCourse(course);
    }
    public void add_course_to_asstaint(Course course,Assistant asstaint )
    {
        asstaint.addCourse(course);
    }
    
    public static Admin login(String username,String password)
    {
        if (username.equals("Admin") && password.equals("123"))
        {
            return new Admin();
        }
        return null;
    }
        
}


