package com.pbob.lazada.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbob.lazada.Customer.CustomerService;

@Controller
public class UserController {

    private final UserService userService;
     private final CustomerService customerService;

    public UserController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }




    @GetMapping("/user/") 
    public String index(Model model){
        List<User> daftarUser = this.userService.ambilSemua();
        model.addAttribute("datauser", daftarUser);
        return "user/index";
    }

    @GetMapping("/user/tambah")
    public String form_tambah(){
        return "/user/tambah";
    }

    @PostMapping("/user/simpan")
    public String simpan(@ModelAttribute User user){

        this.userService.simpan(user);
        return "redirect:/user/";

    }

    @GetMapping("/user/view/{id}")
    public String view(@PathVariable Long id, Model model){
        User user = this.userService.ambilById(id);
        model.addAttribute("user", user);
        return "user/view";
    }

    @GetMapping("/user/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        User user = this.userService.ambilById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/user/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute User user){
       this.userService.ubah(id,user);
       return "redirect:/user/";

    }

        @GetMapping("/user/hapus/{id}")
    public String hapus(@PathVariable Long id){
        // Menghapus customer terlebih dahulu
        customerService.hapusByUserId(id);
        this.userService.hapus(id);
        return "redirect:/user/";
    }
    
}
