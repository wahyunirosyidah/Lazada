package com.pbob.lazada.ProductCategory;

import java.util.List;

import com.pbob.lazada.Product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data

@Entity

public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kategori;

    // @OneToMany(mappedBy = "category")
    // private List<Product> products;

    public ProductCategory() {
    }


    public ProductCategory(String kategori) {
        this.kategori = kategori;
    }


    
}
