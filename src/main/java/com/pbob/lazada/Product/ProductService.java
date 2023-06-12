package com.pbob.lazada.Product;

import java.util.List;

import org.springframework.stereotype.Service;

//menyatakan kelas ini adlaah kelas service
@Service

//untuk menjalankan semua bisnis logic yang digunakan di dalam aplikasi
//bisnis logic=apa yang harus dilakukan jika fungsi2 didalam aplikasi itu apa saja
public class ProductService {

    //buat objek
    private final ProductRepository productRepository;

    //buat konstruktor

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void simpan(Product product) {
        this.productRepository.save(product);
        //jpa reposirtry sudah ada methos method yang bisa langsung digunakann

    }

    public List<Product> ambilSemua() {

        //cara 1
        //mengambil semua data list product
        // List<Product> data = this.productRepository.findAll();
        // return data;

        // //cara 2
        return this.productRepository.findAll();
    }

    public Product ambilById(Long id) {
        //mengambil data
        Product productnya = this.productRepository.findById(id).orElse(null);
        return productnya;
    }

    public void ubah(Long id, Product product) {
        //mengambul data lama
        Product data_lama=this.productRepository.findById(id).orElse(null);

        //mengganti isinay dengan yang baru
        data_lama.setNama(product.getNama());
        data_lama.setHarga(product.getHarga());
        data_lama.setStok(product.getStok());
        data_lama.setDeskripsi(product.getDeskripsi());
         data_lama.setBrand(product.getBrand());
        this.productRepository.save(data_lama);
    }

    public void hapus(Long id) {
        this.productRepository.deleteById(id);
    }


    
}
