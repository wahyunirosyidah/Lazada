package com.pbob.lazada.ProductCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data

@Entity

public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kategori;



    public ProductCategory() {
    }


    public ProductCategory(String kategori) {
        this.kategori = kategori;
    }


    
}
