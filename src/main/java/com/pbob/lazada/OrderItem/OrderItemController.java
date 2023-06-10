package com.pbob.lazada.OrderItem;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbob.lazada.Product.Product;

@Controller
public class OrderItemController {

    private final OrderItemService orderItemService;


    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/orderitem/")
    public String index(Model model){
        List<OrderItem> daftaOrderItem = this.orderItemService.ambilSemua();
        model.addAttribute("dataorderitem", daftaOrderItem);
        return "orderitem/index";
    }
   

        //MENAMPILKAN form tambah
    @GetMapping("/orderitem/tambah")
    public String form_tambah(){
        return "orderitem/tambah";
    }

    //menyimpan data yang ditambahkan
    @PostMapping("/orderitem/simpan")
    public String simpan(@ModelAttribute OrderItem orderItem){
        //menjalankan perintah di fungsi 
        this.orderItemService.simpan(orderItem);
        //setelah dtanya disimpan, mau kembali ke halaman mana
        return "redirect:/orderitem/"; 
    }

    
    @GetMapping("/orderitem/view/{id}")
    public String view(@PathVariable Long id, Model model){

        //mengambil data
        OrderItem orderitem = this.orderItemService.ambilById(id);

        //mengambalikan data ke web
        model.addAttribute("orderitem", orderitem);

        return "orderitem/view";
    }

    @GetMapping("/orderitem/edit/{id}")
    //tambah Path karena ada variabel id
    //tambah model karena ketika membuka file edit, datanya sdh terisi dengan data yang ada
        public String edit(@PathVariable Long id, Model model){
              //mengambil data
        OrderItem orderitem = this.orderItemService.ambilById(id);

        //mengambalikan data ke web
        model.addAttribute("orderitem", orderitem);
            return "orderitem/edit";
        }

    @PostMapping("/orderitem/update/{id}")
    //model atribut untuk 
    public String update(@PathVariable Long id, @ModelAttribute OrderItem orderItem){
    this.orderItemService.ubah(id,orderItem);
    return "redirect:/orderitem/"; 
    }  

        @GetMapping("/orderitem/hapus/{id}")
    public String hapus(@PathVariable Long id){
        this.orderItemService.hapus(id);


        //karena mengambil data baru dari database
        return "redirect:/orderitem/"; 
    }


    
}
