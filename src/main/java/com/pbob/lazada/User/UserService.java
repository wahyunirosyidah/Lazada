package com.pbob.lazada.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void simpan(User user){
        this.userRepository.save(user);
    }

    public List<User> ambilSemua() {
        return  this.userRepository.findAll();
    }


    public User ambilById(Long id) {
        //mengambil data
        User user = this.userRepository.findById(id).orElse(null);
        return user;
    }

    public void ubah(Long id, User user) {
        User data_lama = this.userRepository.findById(id).orElse(null);

        data_lama.setUsername(user.getUsername());
        data_lama.setPassword(user.getPassword());
        data_lama.setEmail(user.getEmail());
        data_lama.setRole(user.getRole());

        this.userRepository.save(data_lama);
    }

    public void hapus(Long id) {
          this.userRepository.deleteById(id);
    }
    
}
