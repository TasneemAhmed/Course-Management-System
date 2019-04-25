/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;

/**
 *
 * @author dell
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tasneem
 */
public abstract class Staff extends person implements Serializable{
  
    public String position;
    protected Department department;
    public float salary;
    public String subject;
    ArrayList<Course> courses=new ArrayList<>();

    

    public Staff() {
        super();
        this.position="";
        this.salary=0;
        this.department=new Department();
        
    }
   
    public abstract double calculate_salary();
    
    
}

    
    
    
    
    

