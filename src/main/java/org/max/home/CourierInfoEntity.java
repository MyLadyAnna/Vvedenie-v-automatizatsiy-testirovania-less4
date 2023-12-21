package org.max.home;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "courier_info", schema = "main", catalog = "")
public class CourierInfoEntity {
    private short courierId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String deliveryType;

    @Id
    @Column(name = "courier_id")
    public short getCourierId() {
        return courierId;
    }

    public void setCourierId(short courierId) {
        this.courierId = courierId;
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


    @Column(name = "delivery_type")
    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourierInfoEntity that = (CourierInfoEntity) o;
        return courierId == that.courierId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(deliveryType, that.deliveryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courierId, firstName, lastName, phoneNumber, deliveryType);
    }
}
