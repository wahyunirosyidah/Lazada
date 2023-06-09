package com.pbob.lazada.Customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
        this.customerService.simpan(customer);
        return "redirect:/customer/";
    }

    @GetMapping("/customer/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Customer customer = this.customerService.ambilById(id);
        model.addAttribute("datacustomer", customer);
        return "customer/view";
    }

}
