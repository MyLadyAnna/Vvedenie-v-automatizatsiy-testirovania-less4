package org.max.seminar;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "current", schema = "main", catalog = "")
public class CurrentEntity {
    private short currentId;
    private String balance;
    private String openDate;
    private String number;
    private short client;
    private short employee;

    @Column(name = "client_id")
    public short getClient() {
        return client;
    }

    public void setClient(short client) {
        this.client = client;
    }

    @Column(name = "employee_id")
    public short getEmployee() {
        return employee;
    }

    public void setEmployee(short employee) {
        this.employee = employee;
    }

    @Id
    @Column(name = "current_id")
    public short getCurrentId() {
        return currentId;
    }

    public void setCurrentId(short currentId) {
        this.currentId = currentId;
    }

    
    @Column(name = "balance")
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    
    @Column(name = "open_date")
    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentEntity that = (CurrentEntity) o;
        return currentId == that.currentId && client == that.client && employee == that.employee && Objects.equals(balance, that.balance) && Objects.equals(openDate, that.openDate) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentId, balance, openDate, number, client, employee);
    }
}
