package com.pbob.lazada.Orders;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbob.lazada.Customer.CustomerRepository;
import com.pbob.lazada.Product.Product;
import com.pbob.lazada.ProductCategory.ProductCategory;
import com.pbob.lazada.Customer.Customer;

@Controller
public class OrdersController {

    private final OrdersService ordersService;
    private CustomerRepository customerRepository;


    public OrdersController(OrdersService ordersService, CustomerRepository customerRepository) {
        this.ordersService = ordersService;
        this.customerRepository = customerRepository;
    }

    //pakai ini utnuk mengaskses and point "/product/"  -GET
    @GetMapping("/orders/")
    public String index(Model model){
        //data yang dikembalikan method akan disimpan di dalam suatu list dengan nama daftar product
        List<Orders> daftarOrders = this.ordersService.ambilSemua();

        //dafarproduct dari list di atas
        //datanya = nama yang akan digynakan pada halaman web
        //pada saat mau mengaskses data yang di daftar product, harus pakai datanya
        model.addAttribute("datanya", daftarOrders);

        return "orders/index";
    }

        //MENAMPILKAN form tambah
    @GetMapping("/orders/tambah")
    public String form_tambah(Model model){
        List<Customer> customer = customerRepository.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("orders", new Orders());
        return "orders/tambah";
    }



     //menyimpan data yang ditambahkan
    @PostMapping("/orders/simpan")
    public String simpan(@ModelAttribute Orders orders){
            // ProductCategory kategori = product.getKategori();
       String customernya = orders.getCustomer().getNamaLengkap();

       Customer customer = new Customer();
       customer.setNamaLengkap(customernya);

    //    productCategoryRepository.save(kategori);

       orders.setCustomer(customer);
        //menjalankan perintah di fungsi 
        this.ordersService.simpan(orders);
        //setelah dtanya disimpan, mau kembali ke halaman mana
        return "redirect:/orders/"; 
    }
}
