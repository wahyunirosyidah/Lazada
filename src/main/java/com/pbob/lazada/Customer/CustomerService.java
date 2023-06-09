package com.pbob.lazada.Customer;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void simpan(Customer customer){
        this.customerRepository.save(customer);
    }
    
    public List<Customer> ambilSemua(){
        return this.customerRepository.findAll();
    }

    public Customer ambilById(Long id) {
        Customer customer = this.customerRepository.findById(id).orElse(null);
        return customer;
    }



    
}
