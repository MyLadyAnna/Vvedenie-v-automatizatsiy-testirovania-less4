package org.max.seminar;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "main", catalog = "")
public class EmployeeEntity {
    private short employeeId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String portion;

    @Id
    @Column(name = "employee_id")
    public short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(short employeeId) {
        this.employeeId = employeeId;
    }

    
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    @Column(name = "portion")
    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return employeeId == that.employeeId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(portion, that.portion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, phoneNumber, portion);
    }
}
