package com.pbob.lazada.Customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbob.lazada.Product.Product;
import com.pbob.lazada.User.User;
import com.pbob.lazada.User.UserRepository;

@Controller
public class CustomerController {

    private final CustomerService customerService;
    private final UserRepository userRepository;


    public CustomerController(CustomerService customerService, UserRepository userRepository) {
        this.customerService = customerService;
        this.userRepository = userRepository;
    }


    @GetMapping("/customer/")
    public String index(Model model) {
        List<Customer> daftarCustomer = this.customerService.ambilSemua();

        model.addAttribute("datacustomer", daftarCustomer);
        return "customer/index";
    }

    @GetMapping("/customer/tambah")
    public String form_tambah() {
        return "customer/tambah";
    }

    @PostMapping("/customer/simpan")
    public String simpan(@ModelAttribute Customer customer) {
         // Mengambil username, password, email, dan role dari request
    String username = customer.getUser().getUsername();
    String password = customer.getUser().getPassword();
    String email = customer.getUser().getEmail();

    // Mengambil role dari objek User
    String role = customer.getUser().getRole();

    // Membuat objek User baru dan mengeset username, password, email, dan role
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setRole(role);

    // Menyimpan objek User ke dalam UserRepository
    userRepository.save(user);

    // Mengeset objek User pada objek Customer
    customer.setUser(user);

    this.customerService.simpan(customer);
    return "redirect:/customer/";
    }

    @GetMapping("/customer/view/{id}")
    public String view(@PathVariable Long id, Model model){

        //mengambil data
        Customer customer = this.customerService.ambilById(id);

        //mengambalikan data ke web
        model.addAttribute("customer", customer);

        return "customer/view";
    }

        @GetMapping("/customer/hapus/{id}")
        public String hapus(@PathVariable Long id){
        this.customerService.hapus(id);


        //karena mengambil data baru dari database
        return "redirect:/customer/"; 
    }

    
    @GetMapping("/customer/edit/{id}")
    //tambah Path karena ada variabel id
    //tambah model karena ketika membuka file edit, datanya sdh terisi dengan data yang ada
        public String edit(@PathVariable Long id, Model model){
              //mengambil data
        Customer customer = this.customerService.ambilById(id);

        //mengambalikan data ke web
        model.addAttribute("customer", customer);
            return "customer/edit";
        }

      @PostMapping("/customer/update/{id}")
    //model atribut untuk 
    public String update(@PathVariable Long id, @ModelAttribute Customer customer){
        // this.customerService.ubah(id,customer);
        // return "redirect:/customer/"; 

         // Mengambil data pengguna dari form
    String username = customer.getUser().getUsername();
    String password = customer.getUser().getPassword();
    String email = customer.getUser().getEmail();
    String role = customer.getUser().getRole();

    // Mengambil objek Customer yang akan diubah
    Customer existingCustomer = customerService.ambilById(id);
    User existingUser = existingCustomer.getUser();

    // Mengupdate data pengguna
    existingUser.setUsername(username);
    existingUser.setPassword(password);
    existingUser.setEmail(email);
    existingUser.setRole(role);

    // Menyimpan perubahan data pengguna
    userRepository.save(existingUser);

    // Menyimpan perubahan data Customer
    customerService.ubah(id, customer);

    return "redirect:/customer/";



    }


}
