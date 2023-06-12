package com.pbob.lazada.Orders;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;


    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void simpan(Orders orders){
        this.ordersRepository.save(orders);
    }

    public List<Orders> ambilSemua(){
        return this.ordersRepository.findAll();
    }

    public void hapus(Long id) {
        this.ordersRepository.deleteById(id);
    }

    
}
