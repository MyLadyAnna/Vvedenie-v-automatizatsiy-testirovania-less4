package org.max.home;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "delivery", schema = "main", catalog = "")
public class DeliveryEntity {
    private short deliveryId;
    private String dateArrived;
    private String taken;
    private String paymentMethod;

    @Id
    @Column(name = "delivery_id")
    public short getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(short deliveryId) {
        this.deliveryId = deliveryId;
    }

    
    @Column(name = "date_arrived")
    public String getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }

    
    @Column(name = "taken")
    public String getTaken() {
        return taken;
    }

    public void setTaken(String taken) {
        this.taken = taken;
    }

    
    @Column(name = "payment_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryEntity that = (DeliveryEntity) o;
        return deliveryId == that.deliveryId && Objects.equals(dateArrived, that.dateArrived) && Objects.equals(taken, that.taken) && Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, dateArrived, taken, paymentMethod);
    }
}
