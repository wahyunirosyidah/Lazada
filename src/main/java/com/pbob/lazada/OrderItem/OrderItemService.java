package com.pbob.lazada.OrderItem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pbob.lazada.Product.Product;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;


    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void simpan(OrderItem orderItem){
      {}  this.orderItemRepository.save(orderItem);
    }

    public List<OrderItem> ambilSemua(){
        return this.orderItemRepository.findAll();
    }

    public OrderItem ambilById(Long id) {
        OrderItem orderItem = this.orderItemRepository.findById(id).orElse(null);
        return orderItem;
    }

    public void ubah(Long id, OrderItem orderItem) {

        OrderItem data_lama = this.orderItemRepository.findById(id).orElse(null);

        data_lama.setOrderId(orderItem.getOrderId());
        data_lama.setProductId(orderItem.getProductId());
        data_lama.setJumlah(orderItem.getJumlah());

        this.orderItemRepository.save(data_lama);

    }

    public void hapus(Long id){
        this.orderItemRepository.deleteById(id);
    }

    
}
