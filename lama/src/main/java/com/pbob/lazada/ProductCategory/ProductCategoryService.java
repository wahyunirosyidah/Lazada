package com.pbob.lazada.ProductCategory;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;


    

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }


    public void simpan(ProductCategory productcategory) {
        this.productCategoryRepository.save(productcategory);
    }


    public List<ProductCategory> ambilSemua() {
        return this.productCategoryRepository.findAll();
    }


    public ProductCategory ambilById(Long id) {
        ProductCategory productcategory = this.productCategoryRepository.findById(id).orElse(null);
        return productcategory;
    }


    public void ubah(Long id, ProductCategory productcategory) {
    
            ProductCategory data_lama=this.productCategoryRepository.findById(id).orElse(null);

            data_lama.setKategori(productcategory.getKategori());
            this.productCategoryRepository.save(data_lama);
    
    }


    public void hapus(Long id) {
        this.productCategoryRepository.deleteById(id);
    }

 







    
}
