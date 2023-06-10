package com.pbob.lazada.Orders;

import com.pbob.lazada.Customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date tanggalOrder;
    private Customer customer;
    private String status;
    private Boolean paymentStatus;
    private String shippingStatus;


    public Orders(Date tanggalOrder, Customer customer, String status, Boolean paymentStatus, String shippingStatus) {
        this.tanggalOrder = tanggalOrder;
        this.customer = customer;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.shippingStatus = shippingStatus;
    }
}
