/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6112a1_st10261338;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
In case you forgot how to do the change, ask for id
ask for what they want with a switch
take in the value
reiterate all the unchanged values with then new value
replace the old one with your new one
*/

/**
 *
 * @author matth
 */
public class Student {
    
    //creating a private arrayList
    private List<Info> studentDetails;

    public Student() {
        this.studentDetails = new ArrayList<>();
    }
    
    //menu
    public void Menu(Scanner kb)
    {
        //initializing variables
        int menuChoice;
        boolean end = false;
         while (!end) {
        
            System.out.println("Please selet one of the menu items\n"
                + "1) Capture a new student\n"
                + "2) Search for a student\n"
                + "3) Delete a students information\n"
                + "4) Display full student information\n"
                + "5) Exit application\n");
        
            menuChoice = kb.nextInt();
        
            //while loop to keep menu running
       
            switch (menuChoice) 
            {
                case 1://sends to SaveStudent method
                    System.out.println("");
                    SaveStudent(kb);
                    System.out.println("");break;
                
                case 2://sends to SearchStudent method
                    System.out.println("");
                    SearchStudent(kb);
                    System.out.println("");break;
                
                case 3://sends to DeleteStudent method
                    System.out.println("");
                    DeleteStudent(kb);
                    System.out.println("");break;
                    
                case 4://sends to StudentReport method
                    System.out.println("");
                    StudentReport(kb);
                    System.out.println("");break;
                    
                case 5://sends to ExitStudentApplication method
                    System.out.println("");
                    ExitStudentApplication();break;
                    
                default : //check for valid entry
                    System.out.println("");
                    JOptionPane.showMessageDialog(null, "Please enter a valid option"); break;
            }
        }
    }
    
    //save student info
    public void SaveStudent(Scanner kb)
    {
        String ID, name, email, course;
        //grabing values
        System.out.println("Please enter student ID:");
        ID  = kb.next();
        System.out.println("Please enter student name:");
        name = kb.next();
        int age = AgeCheck(kb);
        if (age == 0){
            AgeCheck(kb);
        }
        System.out.println("Please enter student email:");
        email = kb.next();
        System.out.println("Please enter student course:");
        course = kb.next();
        
        //adding all the details to the Array to be used later
        studentDetails.add(new Info(ID, name, email, course, age));
        System.out.println("Student data captured!");
    }
    
    //search for a student
    public Info SearchStudent(Scanner kb)
    {
        //prompt user
        String searchID;
        System.out.println("Please enter the ID of the student you wish to find");
        searchID = kb.next();
        
        //for loop to check each iteration of student data
        for (Info info: studentDetails) {
            if (info.getID().equals(searchID)) {
                System.out.println("Student found!\n"
                        + "*********************\n"
                        + "ID: " + info.getID()
                        + "\nName: " + info.getName()
                        + "\nAge: " + info.getAge()
                        + "\nEmail: " + info.getEmail()
                        + "\nCourse: " + info.getCourse());
                return info;
            }
            
        }
        System.out.println("No student was found");
        return null;
    }
    
    //delete a students info
    public Info DeleteStudent(Scanner kb)
    {
         String deleteID;
        
        System.out.println("Enter the ID of the Student you want to delete");
        deleteID = kb.next();
        
        //deletes the correspoinding i values place in the array which was requested by the user
        for (Info info: studentDetails) {
            if (info.getID().equals(deleteID)){
                studentDetails.remove(info);
                System.out.println("Student successfully deleted");
                return info;
                
            }
        }
        System.out.println("Student not found");
        return null;
    }
    
    //displays student info
    public void StudentReport(Scanner kb)
    {
        int i = 1;
       if (studentDetails.isEmpty()) {
           System.out.println("No Student data has been captured");
       } else {
           for (Info info: studentDetails) {
               System.out.println("Student: " + i
                        + "\n*********************\n"
                        + "ID: " + info.getID()
                        + "\nName: " + info.getName()
                        + "\nAge: " + info.getAge()
                        + "\nEmail: " + info.getEmail()
                        + "\nCourse: " + info.getCourse());
               i++;
           }
       }
    }
    
    //exit application
    public void ExitStudentApplication ()
    {
        System.out.println("Thank you for using this application!!!"
                + "\n          Have a great day!");
        System.exit(0);
    }
    
    //age checker helps keep the code of the menu clean
    public int AgeCheck(Scanner kb)
    {
        String tempAGE;
        int age;
        System.out.println("Please enter student age:"
                + " (can not be less than 16)");
        tempAGE = kb.next();
        //if to check if value is valid
        int alphaCount = 0;
        int numCount = 0;
        int specialCount = 0;
        
        //constants -> limits
        final int alphaCountLIMIT = 0;
        final int numCountLIMIT = 1;
        final int specialCountLIMIT = 0;
        
        for (int i = 0; i < tempAGE.length(); i++) {
                  //split
                  char vChar = tempAGE.charAt(i);
                
                  if(Character.isUpperCase(vChar) || Character.isLowerCase(vChar))
                              alphaCount++;
                  else if (!Character.isDigit(vChar) && !Character.isUpperCase(vChar)
                          && !Character.isLowerCase(vChar))
                              specialCount++;
                  else if (Character.isDigit(vChar))
                              numCount++;
        }
        //check for invlaid characters
        if (alphaCount == alphaCountLIMIT && specialCount == specialCountLIMIT
                  && numCount >= numCountLIMIT) {
                  //save temp value
                  age = Integer.parseInt(tempAGE);
                  if (age >= 16) {
                      return age;
                  } else {
                      System.out.println("Entry invalid\nPlease enter a valid entry");
                  }
        }
        else {
                  System.out.println("Entry invalid\nPlease enter a valid entry");
             }
        return 0;
    }
    
    //gets size of students entered
    public int arraySize() {
        return studentDetails.size();
    }
}
