package com.pbob.lazada.Customer;


import com.pbob.lazada.User.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User user;
    private String namaLengkap;
    private String nomorHp;
    private String alamat;


    public Customer(User user, String namaLengkap, String nomorHp, String alamat) {
        this.user = user;
        this.namaLengkap = namaLengkap;
        this.nomorHp = nomorHp;
        this.alamat = alamat;
    }


    // public Customer(User user, String namaLengkap, String nomorHp, String alamat) {
    //     this.user = user;
    //     this.namaLengkap = namaLengkap;
    //     this.nomorHp = nomorHp;
    //     this.alamat = alamat;
    // }

    
}
