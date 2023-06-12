package com.pbob.lazada.Orders;

import java.util.Date;

import com.pbob.lazada.Customer.Customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date tanggalOrder;
    private String status;
    private String paymentStatus;
    private String shippingStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Orders() {
    }

    public Orders(Date tanggalOrder, Customer customer, String status, String paymentStatus, String shippingStatus) {
        this.tanggalOrder = tanggalOrder;
        this.customer = customer;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.shippingStatus = shippingStatus;
    }

}
