package com.pbob.lazada.Orders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

        @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

//     @InitBinder
//     public void initBinder(WebDataBinder binder) {
//     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//     dateFormat.setLenient(false);
//     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
// }

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
       model.addAttribute("tanggalOrder", new Date()); // Tambahkan ini untuk mengakses field tanggalOrder di form
        return "orders/tambah";
    }



     //menyimpan data yang ditambahkan
   @PostMapping("/orders/simpan")
public String simpan(@ModelAttribute Orders orders) {
    String customernya = orders.getCustomer().getNamaLengkap();
    Customer customer = new Customer();
    customer.setNamaLengkap(customernya);
    orders.setCustomer(customer);

    this.ordersService.simpan(orders);
    return "redirect:/orders/";
}

    @GetMapping("/orders/hapus/{id}")
    public String hapus(@PathVariable Long id){
        this.ordersService.hapus(id);


        //karena mengambil data baru dari database
        return "redirect:/orders/"; 
    }

    @GetMapping("/orders/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Orders orders = this.ordersService.ambilById(id);

        List<Customer> customer = customerRepository.findAll();

        model.addAttribute("orders", orders);
        model.addAttribute("customer", customer);
        return "orders/edit";
    }

        @PostMapping("/orders/update/{id}")
    //model atribut untuk 
    public String update(@PathVariable Long id, @ModelAttribute Orders orders){
        Orders existingOrders = ordersService.ambilById(id);
    String customer = orders.getCustomer().getNamaLengkap();

    Customer existingCustomer = existingOrders.getCustomer();
    existingCustomer.setNamaLengkap(customer);

    // Simpan perubahan pada objek orders dan customer
    this.customerRepository.save(existingCustomer);
    this.ordersService.simpan(existingOrders);
        ordersService.ubah(id, orders);
    return "redirect:/orders/";
    }


}
