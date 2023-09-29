/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog6112a1_st10261338;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matth
 */
public class StudentTest {
    
    @Test
    public void TestSaveStudent()
    {
        Student stu = new Student();
        
        //create student info
        Scanner kb = new Scanner("121\nMatthew\n21\nnah@gmail.com\nBCAD");
        
        //save student info
        stu.SaveStudent(kb);
        
        //check if a student was added
        assertEquals(1, stu.arraySize());
    }
    
    @Test
    public void TestSearchStudent ()
    {
        Student stu = new Student();
        
        //create student info
        Scanner kb = new Scanner("121\nMatthew\n21\nnah@gmail.com\nBCAD");
        
        //save student info
        stu.SaveStudent(kb);
        
        //search for student
        kb = new Scanner("121\n");
        Info searchStu = stu.SearchStudent(kb);
        
        //check student info
        assertNotNull(searchStu);
        assertEquals("121", searchStu.getID());
        assertEquals("Matthew", searchStu.getName());
        assertEquals(21, searchStu.getAge());
        assertEquals("nah@gmail.com", searchStu.getEmail());
        assertEquals("BCAD", searchStu.getCourse());
    }
    
    @Test
    public void TestSearchStudent_StudentNotFound()
    {
        Student stu = new Student();
        
        //create student info
        Scanner kb = new Scanner("121\nMatthew\n21\nnah@gmail.com\nBCAD");
        
        //save student info
        stu.SaveStudent(kb);
        
        //search for wrong student
        kb = new Scanner("12\n");
        Info searchStu = stu.SearchStudent(kb);
        
        //check if a null returns
        assertNull(searchStu);
    }
    
    @Test
    public void TestDeleteStudent()
    {
        Student stu = new Student();
        
        //create student info
        Scanner kb = new Scanner("121\nMatthew\n21\nnah@gmail.com\nBCAD");
        
        //save student info
        stu.SaveStudent(kb);
        
        //search for student
        kb = new Scanner("121\n");
        Info deleteStu = stu.DeleteStudent(kb);
        assertNotNull(deleteStu);
        
        //check if it returns a student
        kb = new Scanner("121\n");
        Info searchStu = stu.SearchStudent(kb);
        assertNull(searchStu);
    }
    
    @Test
    public void TestDeleteStudent_StudentNotFound() 
    {
        Student stu = new Student();
        
        //create student info
        Scanner kb = new Scanner("121\nMatthew\n21\nnah@gmail.com\nBCAD");
        
        //save student info
        stu.SaveStudent(kb);
        
        //search for student
        kb = new Scanner("12\n");
        Info deleteStu = stu.DeleteStudent(kb);
        
        //check if a null returns
        assertNull(deleteStu);
    }
    
    @Test
    public void TestStudentAge_StudentAgeValid()
    {
        Student stu = new Student();
        
        //create the age being tested
        Scanner kb = new Scanner("21");
        
        //check if the age is returned
        assertEquals(21, stu.AgeCheck(kb));
        
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalid() 
    {
        Student stu = new Student();
        
        //create the age being tested
        Scanner kb = new Scanner("11");
        
        //check if the age is returned
        assertEquals(0, stu.AgeCheck(kb));
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter()
    {
        Student stu = new Student();
        
        //create the age being tested
        Scanner kb = new Scanner("C");
        
        //check if the age is returned
        assertEquals(0, stu.AgeCheck(kb));
    }
}
