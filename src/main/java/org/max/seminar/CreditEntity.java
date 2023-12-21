package org.max.seminar;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "credit", schema = "main", catalog = "")
public class CreditEntity {
    private short creditId;
    private String balance;
    private String openDate;
    private String closeDate;
    private String summ;
    private String number;
    private String status;
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
    @Column(name = "credit_id")
    public short getCreditId() {
        return creditId;
    }

    public void setCreditId(short creditId) {
        this.creditId = creditId;
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

    
    @Column(name = "close_date")
    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    
    @Column(name = "summ")
    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }

    
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditEntity that = (CreditEntity) o;
        return creditId == that.creditId && Objects.equals(balance, that.balance) && Objects.equals(openDate, that.openDate) && Objects.equals(closeDate, that.closeDate) && Objects.equals(summ, that.summ) && Objects.equals(number, that.number) && Objects.equals(status, that.status) && Objects.equals(client, that.client) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditId, balance, openDate, closeDate, summ, number, status, client, employee);
    }
}
