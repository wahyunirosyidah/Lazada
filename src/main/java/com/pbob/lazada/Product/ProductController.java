package com.pbob.lazada.Product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


//karena ini buat web, kalau backend pakai RestAPI nati pakai RestController
@Controller
public class ProductController {
    //mengatur rute

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //pakai ini utnuk mengaskses and point "/product/"  -GET
    @GetMapping("/product/")
    public String index(Model model){
        //data yang dikembalikan method akan disimpan di dalam suatu list dengan nama daftar product
        List<Product> daftarProduct = this.productService.ambilSemua();

        //dafarproduct dari list di atas
        //datanya = nama yang akan digynakan pada halaman web
        //pada saat mau mengaskses data yang di daftar product, harus pakai datanya
        model.addAttribute("datanya", daftarProduct);

        return "product/index";
    }

    //MENAMPILKAN form tambah
    @GetMapping("/product/tambah")
    public String form_tambah(){
        return "product/tambah";
    }

    //menyimpan data yang ditambahkan
    @PostMapping("/product/simpan")
    public String simpan(@ModelAttribute Product product){
        //menjalankan perintah di fungsi 
        this.productService.simpan(product);
        //setelah dtanya disimpan, mau kembali ke halaman mana
        return "redirect:/product/"; 
    }


    @GetMapping("/product/view/{id}")
    public String view(@PathVariable Long id, Model model){

        //mengambil data
        Product productnyanya = this.productService.ambilById(id);

        //mengambalikan data ke web
        model.addAttribute("productnyanya", productnyanya);

        return "product/view";
    }

    @GetMapping("/product/edit/{id}")
    //tambah Path karena ada variabel id
    //tambah model karena ketika membuka file edit, datanya sdh terisi dengan data yang ada
        public String edit(@PathVariable Long id, Model model){
              //mengambil data
        Product productnyanya = this.productService.ambilById(id);

        //mengambalikan data ke web
        model.addAttribute("productnyanya", productnyanya);
            return "product/edit";
        }


    @PostMapping("/product/update/{id}")
    //model atribut untuk 
    public String update(@PathVariable Long id, @ModelAttribute Product product){
        this.productService.ubah(id,product);
        return "redirect:/product/"; 
    }

    @GetMapping("/product/hapus/{id}")
    public String hapus(@PathVariable Long id){
        this.productService.hapus(id);


        //karena mengambil data baru dari database
        return "redirect:/product/"; 
    }



}
