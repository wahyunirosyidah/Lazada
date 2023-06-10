package com.pbob.lazada.OrderItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderItem {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private int orderId;
   private int productId;
   private int jumlah;


    public OrderItem() {
    }


    public OrderItem(Long id, int orderId, int productId, int jumlah) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.jumlah = jumlah;
    }


}
