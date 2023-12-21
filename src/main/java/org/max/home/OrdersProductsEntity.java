package org.max.home;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders_products", schema = "main", catalog = "")
@IdClass(OrdersProductsEntityPK.class)
public class OrdersProductsEntity {
    private short orderId;
    private short productId;
    private short quantity;

    @Id
    @Column(name = "order_id")
    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "product_id")
    public short getProductId() {
        return productId;
    }

    public void setProductId(short productId) {
        this.productId = productId;
    }

    
    @Column(name = "quantity")
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersProductsEntity that = (OrdersProductsEntity) o;
        return orderId == that.orderId && productId == that.productId && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, quantity);
    }
}
