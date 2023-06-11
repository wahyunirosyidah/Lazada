package com.pbob.lazada.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//sebagai turunan dari kelas JPA repositury
//dependency string jpa digunakan di sini

@Repository

//ini kelas berelasi dengan kelas product
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Product itu kek kelas mahasiswa, Long itu tipe data primarynha

}
