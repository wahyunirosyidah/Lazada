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
    private String jenisPembayaran;
    private String paymentStatus;
    private String shippingStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Orders() {
    }


    public Orders(Long id, Date tanggalOrder, String status, String jenisPembayaran, String paymentStatus, String shippingStatus, Customer customer) {
        this.id = id;
        this.tanggalOrder = tanggalOrder;
        this.status = status;
        this.jenisPembayaran = jenisPembayaran;
        this.paymentStatus = paymentStatus;
        this.shippingStatus = shippingStatus;
        this.customer = customer;
    }


}
