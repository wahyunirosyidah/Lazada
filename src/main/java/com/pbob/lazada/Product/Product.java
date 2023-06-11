package com.pbob.lazada.Product;

import com.pbob.lazada.ProductCategory.ProductCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Product
 */


 //agar tidka usah buat setter getter
 @Data
 
 //menyatakan bahwa kelas ini merupakan kelas Entitas
 //akan direlasikan dengan tabel pada database
 @Entity
public class Product {

    //mmenentukan atribut mana yang digunakan sebagai ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nama;
    private String deskripsi;
    private String harga;
    private String stok;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kategori_id")
    private ProductCategory kategori;
    
    public Product() {
    }


    //membuat kontruktor
    // public Product(String nama, String deskripsi, String harga, String stok) {
    //     this.nama = nama;
    //     this.deskripsi = deskripsi;
    //     this.harga = harga;
    //     this.stok = stok;
    // }



    public Product(String nama, String deskripsi, String harga, String stok, ProductCategory kategori) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }


    
}