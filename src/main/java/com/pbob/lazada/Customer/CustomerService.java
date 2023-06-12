package com.pbob.lazada.Customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pbob.lazada.Product.Product;
import com.pbob.lazada.User.User;
import com.pbob.lazada.User.UserRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    public void simpan(Customer customer) {
        this.customerRepository.save(customer);
    }

    public List<Customer> ambilSemua() {
        return this.customerRepository.findAll();
    }

    public Customer ambilById(Long id) {
        Customer customer = this.customerRepository.findById(id).orElse(null);
        return customer;
    }

    public void hapus(Long id) {
        this.customerRepository.deleteById(id);
    }

    public void ubah(Long id, Customer customer) {

        // mengambul data lama
        Customer data_lama = this.customerRepository.findById(id).orElse(null);
        User data_lamanya = this.userRepository.findById(id).orElse(null);
        // mengganti isinay dengan yang baru
        data_lama.setNamaLengkap(customer.getNamaLengkap());
        data_lama.setNomorHp(customer.getNomorHp());
        data_lama.setAlamat(customer.getAlamat());
        // data_lama.setUser(customer.getDeskripsi());

        this.customerRepository.save(data_lama);

    }

}
