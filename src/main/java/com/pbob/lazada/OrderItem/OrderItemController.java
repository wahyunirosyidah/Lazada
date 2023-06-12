package com.pbob.lazada.OrderItem;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class OrderItemController {

    private final OrderItemService orderItemService;


    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    } 

    //anotasi dari framework Spring untuk menentukan URL endpoint yang akan ditangani oleh metode index()
    @GetMapping("/orderitem/")
    //mengambil parameter Model untuk menyimpan data yang akan dikirim ke tampilan
    public String index(Model model){
        //ambil semua = mengembalikan daftar semua order item yang ada
        List<OrderItem> daftaOrderItem = this.orderItemService.ambilSemua();
        //  untuk menampilkan daftar order item.
        model.addAttribute("daftarorderitem", daftaOrderItem);
        // mengembalikan nilai String "orderitem/index", yang akan merujuk ke nama tampilan yang akan ditampilkan kepada pengguna
        return "orderitem/index";
    }

    @GetMapping("/orderitem/tambah")
    public String form_tambah(){
        return "orderitem/tambah";
    }

    @PostMapping("/orderitem/simpan")
    //Metode ini akan menyimpan objek orderItem yang diterima ke dalam database melalui orderItemService.
    public String simpan( @ModelAttribute OrderItem orderItem){
        this.orderItemService.simpan(orderItem);
        return "redirect:/orderitem/";
    }

    @GetMapping("/orderitem/view/{id}")
    public String view(@PathVariable Long id, Model model){
        OrderItem orderItem = this.orderItemService.ambilById(id);
        model.addAttribute("orderitem", orderItem);
        return "orderitem/view";
    }

    @GetMapping("/orderitem/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        OrderItem orderItem = this.orderItemService.ambilById(id);
        model.addAttribute("orderitem", orderItem);
        return "orderitem/edit";
    }

    @PostMapping("/orderitem/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute OrderItem orderItem){
        this.orderItemService.ubah(id,orderItem);
        return "redirect:/orderitem/";
    }

    @GetMapping("/orderitem/hapus/{id}")
    public String hapus(@PathVariable Long id){
        this.orderItemService.hapus(id);
        return "redirect:/orderitem/";
    }
    
    
}
