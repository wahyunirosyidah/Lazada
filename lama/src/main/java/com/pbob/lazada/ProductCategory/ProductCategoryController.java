package com.pbob.lazada.ProductCategory;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductCategoryController {

   private final ProductCategoryService productCategoryService;
   

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/productcategory/")
    public String index(Model model){
        //data yang dikembalikan method akan disimpan di dalam suatu list dengan nama daftar product
        List<ProductCategory> daftarProductCategory = this.productCategoryService.ambilSemua();

        //dafarproduct dari list di atas
        //datanya = nama yang akan digynakan pada halaman web
        //pada saat mau mengaskses data yang di daftar product, harus pakai datanya
        model.addAttribute("datanyaCategory", daftarProductCategory);

        return "/productcategory/index";
    }
    @GetMapping("/productcategory/tambah")
    public String form_tambahkate(){
        return "/productcategory/tambah";
    }

    //menyimpan data yang ditambahkan
    @PostMapping("/productcategory/simpan")
    public String simpan(@ModelAttribute ProductCategory productcategory){
        //menjalankan perintah di fungsi 
        this.productCategoryService.simpan(productcategory);
        //setelah dtanya disimpan, mau kembali ke halaman mana
        return "redirect:/productcategory/"; 
    }

    @GetMapping("/productcategory/view/{id}")
    public String view(@PathVariable Long id, Model model){

        //mengambil data
        ProductCategory productcategory = this.productCategoryService.ambilById(id);

        //mengambalikan data ke web
        model.addAttribute("productcategory", productcategory);

        return "productcategory/view";

    }

    @GetMapping("/productcategory/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        ProductCategory productcategory = this.productCategoryService.ambilById(id);
        model.addAttribute("productcategory", productcategory);
        return "productcategory/edit";
    }
    
    @PostMapping("/productcategory/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute ProductCategory productcategory){
        this.productCategoryService.ubah(id,productcategory);
        return "redirect:/productcategory/";
    }

    @GetMapping("/productcategory/hapus/{id}")
    public String hapus(@PathVariable Long id){
    this.productCategoryService.hapus(id);
     return "redirect:/productcategory/";
    }
}
