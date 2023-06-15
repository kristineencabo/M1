/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph;

/**
 *
 * @author User
 */
public class Employee {
    private String id;
    private String first_name;
    private String last_name;
    private float hourly_rate;
    
    public Employee(String id, String firstName,String lastName, float hourlyRate) {
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.hourly_rate = hourlyRate;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public float getHourly_rate() {
        return hourly_rate;
    }
    
}
