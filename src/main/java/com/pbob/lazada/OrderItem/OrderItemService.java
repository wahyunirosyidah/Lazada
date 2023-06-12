package com.pbob.lazada.OrderItem;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    //final menandakan bahwa variabel ini hanya dapat diinisialisasi sekali dan tidak dapat diubah setelahnya.
    private final OrderItemRepository orderItemRepository;
    

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void simpan(OrderItem orderItem){
        this.orderItemRepository.save(orderItem);
    }
    public List<OrderItem> ambilSemua(){
        return this.orderItemRepository.findAll();
    }

    public OrderItem ambilById(Long id){
        OrderItem orderItem = this.orderItemRepository.findById(id).orElse(null);
        return orderItem;
    }

    //menerima dan mengembalikan data dengan id yang sesuai
    public void ubah(Long id, OrderItem orderItem) {
        //mencari objek dengan id yang sesuai
        OrderItem data_lama= this.orderItemRepository.findById(id).orElse(null);

        data_lama.setOrderId(orderItem.getOrderId());
        data_lama.setProductId(orderItem.getProductId());
        data_lama.setJumlah(orderItem.getJumlah());


        this.orderItemRepository.save(data_lama);
    }

    public void hapus(Long id){
        this.orderItemRepository.deleteById(id);
    }


    
}
