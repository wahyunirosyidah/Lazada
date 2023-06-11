package com.pbob.lazada.Customer;

import com.pbob.lazada.User.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String namaLengkap;
    private String nomorHp;
    private String alamat;

    public Customer() {
       
    }

    public Customer(User user, String namaLengkap, String nomorHp, String alamat) {
        this.user = user;
        this.namaLengkap = namaLengkap;
        this.nomorHp = nomorHp;
        this.alamat = alamat;
    }

}
