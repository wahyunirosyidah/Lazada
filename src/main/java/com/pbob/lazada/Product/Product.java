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
    private Double harga;
    private String stok;
    private String brand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kategori_id")
    private ProductCategory kategori;
    
    public Product() {
    }


    public Product(Long id, String nama, String deskripsi, Double harga, String stok, String brand, ProductCategory kategori) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.brand = brand;
        this.kategori = kategori;
    }


}