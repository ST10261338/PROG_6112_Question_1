/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog6112a1_st10261338;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author matth
 */
public class PROG6112A1_ST10261338 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //initialize variables
        Scanner kb = new Scanner(System.in);
        int choice;
        
        //initilaized object
        Student stu = new Student();
        
        //getting choice
        System.out.println("STUDENT MANAGEMENT APPLICATION\n" +
                "**************************************\nEnter (1) to launch menu or any other key to exit");;
        choice = kb.nextInt();
            
        if (choice == 1) {
            stu.Menu(kb);
        } else {
            stu.ExitStudentApplication();
        }
        
    }
    
}
