/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6112a1_st10261338;

/**
 *
 * @author matth
 */
public class Info {
    private String ID, name, email, course;
    private int age;
    
    
    //constructor
    public Info(String ID, String name, String email, String course, int age) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }
    
    //getters
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }
    
    
}
