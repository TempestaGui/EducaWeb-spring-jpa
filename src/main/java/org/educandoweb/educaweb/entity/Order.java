package org.educandoweb.educaweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.educandoweb.educaweb.enums.OrderStatusEnum;
import org.hibernate.engine.internal.Cascade;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) //mapenado para ter o mesmo id, se o pedido for id 5 o pagamento tmb vai ser 5
    private Payments payments;

    public Order(){}

    public Order(Long id, User client, Instant moment, OrderStatusEnum orderStatus){
        this.id = id;
        this.client = client;
        this.moment = moment;
        setOrderStatus(orderStatus);
    }


    public User getUser() {
        return client;
    }

    public void setUser(User client) {
        this.client = client;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatusEnum getOrderStatus() {
        return OrderStatusEnum.valueOf(orderStatus);
    }
    public void setOrderStatus(OrderStatusEnum orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    public Set<OrderItem> getItem(){
        return items;
    }

    public Double getTotal(){
        double total = 0;
        for(OrderItem item : items ){
            total += item.getSubTotal();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
